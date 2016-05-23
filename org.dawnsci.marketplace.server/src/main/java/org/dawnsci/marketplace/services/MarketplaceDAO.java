/*****************************************************************************
 * Copyright (c) 2016 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Torkild U. Resheim - initial API and implementation
 ****************************************************************************/
package org.dawnsci.marketplace.services;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.naming.NamingException;

import org.dawnsci.marketplace.Catalog;
import org.dawnsci.marketplace.Catalogs;
import org.dawnsci.marketplace.Featured;
import org.dawnsci.marketplace.ForbiddenException;
import org.dawnsci.marketplace.InternalErrorException;
import org.dawnsci.marketplace.Marketplace;
import org.dawnsci.marketplace.MarketplaceFactory;
import org.dawnsci.marketplace.MarketplacePackage;
import org.dawnsci.marketplace.Node;
import org.dawnsci.marketplace.Recent;
import org.dawnsci.marketplace.Search;
import org.dawnsci.marketplace.SearchTab;
import org.dawnsci.marketplace.Wizard;
import org.dawnsci.marketplace.social.account.Account;
import org.dawnsci.marketplace.social.account.AccountRepository;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MarketplaceDAO {

	private static final Logger logger = LoggerFactory.getLogger(MarketplaceDAO.class);

	@Inject
	private AccountRepository accountRepository;

	@Inject
	private SessionFactory sessionFactory;

	@Inject
	private Environment environment;

	@Inject
	private FileService fileService;

	@Value("${marketplace.featured.solutions:1}")
	List<Long> featuredItems;

	@Value("${marketplace.featured.maximum:3}")
	private int maxFeaturedItems;

	@Value("${marketplace.max-recent-solutions:12}")
	private int maxRecentItems;

	@Value("${marketplace.base-url:http://localhost:8080}")
	private String marketplaceBaseUrl;

	/**
	 * HQL query to use when searching for a solution using a simple substring
	 * search.
	 */
	private static final String HQL_SEARCH =
			"select node from Node node where " +
			"lower(node.name) like :term or " +
			"lower(node.owner) like :term or " +
			"lower(str(node.shortdescription)) like :term or " +
			"lower(str(node.body)) like :term " +
			"order by node.changed desc";

	/**
	 * Creates and returns the catalog representing this particular marketplace
	 * instance.
	 *
	 * @return this marketplace's catalog
	 */
	private Catalog getCatalog() {
		Catalog catalog = MarketplaceFactory.eINSTANCE.createCatalog();
		catalog.setTitle(environment.getProperty("marketplace.title"));
		catalog.setUrl(marketplaceBaseUrl+"/mpc");
		catalog.setIcon(environment.getProperty("marketplace.catalog-icon"));
		catalog.setDescription(environment.getProperty("marketplace.description"));
		Wizard wizard = MarketplaceFactory.eINSTANCE.createWizard();
		wizard.setTitle(environment.getProperty("marketplace.wizard-title"));
		wizard.setIcon(environment.getProperty("marketplace.wizard-icon"));
		SearchTab st = MarketplaceFactory.eINSTANCE.createSearchTab();
		FeatureMapUtil.addText(st.getMixed(), "Search");
		st.setEnabled(1);
		wizard.setSearchtab(st);
		catalog.setWizard(wizard);
		return catalog;
	}

	@Transactional
	public Marketplace getContent(Long identifier) {
		Marketplace marketplace = MarketplaceFactory.eINSTANCE.createMarketplace();
		marketplace.setBaseUrl(marketplaceBaseUrl);
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Query query = sessionFactory.getCurrentSession()
					.createQuery("SELECT node FROM Node node WHERE node.id='" + identifier + "'");
			query.setMaxResults(1);
			if (!query.list().isEmpty()) {
				marketplace.setNode((EcoreUtil.copy((Node)query.list().get(0))));
			}
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw new InternalErrorException(e);
		}
		return marketplace;
	}

	private Marketplace loadSerialized(URL url) {
		ResourceSet rs = new ResourceSetImpl();
		rs.getPackageRegistry().put(null, MarketplacePackage.eINSTANCE);
		try {
			Resource resource = rs.createResource(URI.createURI(url.toExternalForm()));
			InputStream is = url.openStream();
			resource.load(is, rs.getLoadOptions());
			return (Marketplace) resource.getContents().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public Marketplace getCatalogs() {
		Marketplace marketplace = MarketplaceFactory.eINSTANCE.createMarketplace();
		marketplace.setBaseUrl(marketplaceBaseUrl);
		Catalogs catalogs = MarketplaceFactory.eINSTANCE.createCatalogs();
		marketplace.setCatalogs(catalogs);
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			catalogs.getItems().add(getCatalog());
			Query query = sessionFactory.getCurrentSession().createQuery("SELECT catalog FROM Catalog catalog");
			catalogs.getItems().addAll(EcoreUtil.copyAll(query.list()));
			sessionFactory.getCurrentSession().getTransaction().commit();
			// also obtain catalogs from the Eclipse Marketplace
			try {
				Marketplace em = loadSerialized(new URL("http://marketplace.eclipse.org/catalogs/api/p"));
				catalogs.getItems().addAll(EcoreUtil.copyAll(em.getCatalogs().getItems()));
			} catch (Exception e){
				// it's not a big deal if we cannot reach the Eclipse Marketplace
				// but we would like to know what happened.
				e.printStackTrace();
			}
		} catch (Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw new InternalErrorException(e);
		}
		return marketplace;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Marketplace getMarkets() {
		Marketplace marketplace = MarketplaceFactory.eINSTANCE.createMarketplace();
		marketplace.setBaseUrl(marketplaceBaseUrl);
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Query query = sessionFactory.getCurrentSession().createQuery("SELECT market FROM Market market");
			marketplace.getMarkets().addAll(EcoreUtil.copyAll(query.list()));
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw new InternalErrorException(e);
		}
		return marketplace;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Marketplace getFeatured() {
		Marketplace marketplace = MarketplaceFactory.eINSTANCE.createMarketplace();
		marketplace.setBaseUrl(marketplaceBaseUrl);
		Featured featured = MarketplaceFactory.eINSTANCE.createFeatured();
		marketplace.setFeatured(featured);
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Query query = sessionFactory.getCurrentSession()
					.createQuery("SELECT node FROM Node node WHERE node.id IN (:f)");
			query.setParameterList("f", featuredItems);
			query.setMaxResults(maxFeaturedItems);
			featured.getNodes().addAll(EcoreUtil.copyAll(query.list()));
			featured.setCount(featured.getNodes().size());
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw new InternalErrorException(e);
		}
		return marketplace;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Marketplace getRecent() {
		Marketplace marketplace = MarketplaceFactory.eINSTANCE.createMarketplace();
		marketplace.setBaseUrl(marketplaceBaseUrl);
		Recent recent = MarketplaceFactory.eINSTANCE.createRecent();
		marketplace.setRecent(recent);
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Query query = sessionFactory.getCurrentSession().createQuery("SELECT node FROM Node node ORDER BY node.changed DESC");
			query.setMaxResults(maxRecentItems);
			recent.getNodes().addAll(EcoreUtil.copyAll(query.list()));
			recent.setCount(recent.getNodes().size());
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw new InternalErrorException(e);
		}
		return marketplace;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Marketplace getSearchResult(String term) {
		Marketplace marketplace = MarketplaceFactory.eINSTANCE.createMarketplace();
		marketplace.setBaseUrl(marketplaceBaseUrl);
		Search search = MarketplaceFactory.eINSTANCE.createSearch();
		term = term.toLowerCase();
		search.setTerm(term);
		search.setUrl(marketplaceBaseUrl+"/search?term="+term);
		marketplace.setSearch(search);
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Query query = sessionFactory.getCurrentSession().createQuery(HQL_SEARCH).setString("term","%" + term + "%");
			List<Node> list = query.list();
			search.getNodes().addAll(EcoreUtil.copyAll(list));
			search.setCount(search.getNodes().size());
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw new InternalErrorException(e);
		}
		return marketplace;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<String> getTags() {
		List<String> tags = Collections.EMPTY_LIST;
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Query query = sessionFactory.getCurrentSession().createQuery("select distinct name from Tag");
			query.setMaxResults(50);
			tags = query.list();
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw new InternalErrorException(e);
		}
		return tags;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Marketplace getSolutionsWithTag(String tag) {
		Marketplace marketplace = MarketplaceFactory.eINSTANCE.createMarketplace();
		marketplace.setBaseUrl(marketplaceBaseUrl);
		Search search = MarketplaceFactory.eINSTANCE.createSearch();
		search.setTerm(tag);
		search.setUrl(marketplaceBaseUrl+"/search?tag="+tag);
		marketplace.setSearch(search);
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Query query = sessionFactory.getCurrentSession().createQuery(
					"SELECT node "
					+ "FROM Node node "
					+ "JOIN node.tags.items nti "
					+ "WHERE nti.name=:term").setString("term", tag);
			search.getNodes().addAll(EcoreUtil.copyAll(query.list()));
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw new InternalErrorException(e);
		}
		return marketplace;
	}

	/**
	 * Returns a <b>detached</b> copy of the solution with the specified
	 * identifier.
	 *
	 * @param identifier
	 *            the solution identifier
	 * @return a detached {@link Node} instance
	 */
	@Transactional
	public Node getSolution(Long identifier) {
		Node node = null;
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Query query = sessionFactory.getCurrentSession().createQuery("SELECT node FROM Node node WHERE node.id='" + identifier + "'");
			if (!query.list().isEmpty()) {
				node = EcoreUtil.copy((Node) query.list().get(0));
			}
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw new InternalErrorException(e);
		}
		return node;
	}

	/**
	 * Deletes the specified solution from the marketplace or throws a
	 * {@link ForbiddenException} if the solution does not belong to the
	 * specified account.
	 *
	 * @param account
	 *            the account that executes the operation
	 * @param id
	 *            identifier of the solution
	 */
	@Transactional
	public void deleteSolution(Account account, Long id) {
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			if (!canEdit(id)) {
				throw new ForbiddenException();
			}
			Object object = sessionFactory.getCurrentSession().get("Node", id);
			sessionFactory.getCurrentSession().delete(object);
			sessionFactory.getCurrentSession().getTransaction().commit();
			fileService.deleteSolution(id);
		} catch (Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw new InternalErrorException(e);
		}
	}

	/**
	 * <p>
	 * If clones are serialized/deserialized as different object instances then
	 * we need to have an explicit version attribute in the model itself (which
	 * stays with the object). Since we don't want to keep multiple version, the
	 * <i>created</i> field on <code>node</code> is annotated with "Version". Using
	 * the <i>changed</i> field opens a can of worms.
	 * </p>
	 *
	 * @param solution the solution as XML
	 * @param account the user identifier
	 * @return
	 * @throws NamingException
	 * @see https://docs.jboss.org/hibernate/core/3.3/reference/en/html/objectstate.html#objectstate-detached
	 */
	@Transactional
	public Object saveOrUpdateSolution(Node s, Account account) {
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			boolean isNewSolution = s.getId() == null ? true : false;
			// if the solution has an assigned identifier, but does not exist
			// we'll clear the identifier and create a fresh instance. The new
			// identifier will be returned so that the client can update it's
			// copy. Also make sure we have the same "created" value as this
			// is used for identity.
			if (!isNewSolution) {
				Object object = sessionFactory.getCurrentSession().get("Node", s.getId());
				if (object == null) {
					s.setId(null);
					isNewSolution = true;
					logger.info("Reset identifier for solution " + s.getName());
				} else {
					// make sure we have the same value as the database
					s.setCreated(((Node)object).getCreated());
					sessionFactory.getCurrentSession().evict(object);
				}
			}
			// verify that we have the correct owner
			if (!isNewSolution) {
				if (!canEdit(s.getId())) {
					throw new ForbiddenException();
				}
				logger.info("Updating solution #"+s.getId());
			}

			s.setChanged(System.currentTimeMillis());

			// set a few values for new entities
			if (isNewSolution) {
				logger.info("Creating a new solution instance in database");
				s.setCreated(System.currentTimeMillis());
				s.setUpdateurl(""); // http://localhost:8080/files/1 for solution #1
				s.setOwner(account.getFirstName()+" "+account.getLastName());
			}

			// do the update in the databse
			sessionFactory.getCurrentSession().saveOrUpdate(s);
			sessionFactory.getCurrentSession().getTransaction().commit();

			if (isNewSolution) {
				// associate the new solution with the user account
				accountRepository.createAccountSolutionMapping(account, s.getId());
			}

			logger.info("Saved solution #" + s.getId() + " - " + s.getName());

			return s;
		} catch (Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw new InternalErrorException(e);
		}
	}
	/**
	 * Creates a new node or solution, ready for editing.
	 *
	 * @return the new node
	 */
	public Marketplace getNewNode() {
		Marketplace marketplace = MarketplaceFactory.eINSTANCE.createMarketplace();
		marketplace.setBaseUrl(marketplaceBaseUrl);
		Node node = MarketplaceFactory.eINSTANCE.createNode();
		marketplace.setNode(node);
		return marketplace;
	}

	/**
	 * Tests whether or not the current user have access to edit the solution
	 * with the given identifier. The user must be an administrator or own the
	 * solution.
	 *
	 * @param identifier
	 *            the identifier of the solution
	 * @return <code>true</code> if editable
	 */
	public boolean canEdit(Long identifier) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return false;
		}
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
				return true;
			}
		}
		// new solution
		if (identifier == null) {
			return true;
		}
		Account account = accountRepository.findOne(authentication.getName());
		Account a = accountRepository.findAccountBySolutionId(identifier);
		if (account.getUsername().equals(a.getUsername())) {
			return true;
		}
		return false;
	}

}
