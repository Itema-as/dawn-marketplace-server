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
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.naming.NamingException;

import org.dawnsci.marketplace.Catalog;
import org.dawnsci.marketplace.Catalogs;
import org.dawnsci.marketplace.Featured;
import org.dawnsci.marketplace.Marketplace;
import org.dawnsci.marketplace.MarketplaceFactory;
import org.dawnsci.marketplace.Node;
import org.dawnsci.marketplace.Recent;
import org.dawnsci.marketplace.Search;
import org.dawnsci.marketplace.SearchTab;
import org.dawnsci.marketplace.Wizard;
import org.dawnsci.marketplace.social.account.Account;
import org.dawnsci.marketplace.social.account.AccountRepository;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MarketplaceDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(MarketplaceDAO.class);
	
	@Inject
	private AccountRepository accountRepository;

	@Inject
	private SessionFactory sessionFactory;
		
	@Inject
	private Environment environment;
	
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
	
	public Catalog getCatalog(){
		Catalog catalog = MarketplaceFactory.eINSTANCE.createCatalog();
		catalog.setTitle(environment.getProperty("marketplace.title"));
		catalog.setUrl(environment.getProperty("marketplace.base-url")+"/mpc");
		catalog.setIcon(environment.getProperty("marketplace.icon"));
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

	public Marketplace getContent(int identifier) {
		Marketplace marketplace = MarketplaceFactory.eINSTANCE.createMarketplace();
		marketplace.setBaseUrl(environment.getProperty("marketplace.base-url"));
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Query query = sessionFactory.getCurrentSession()
					.createQuery("SELECT node FROM Node node WHERE node.id='" + identifier + "'");
			query.setMaxResults(1);
			if (query.list().isEmpty()) {
				return marketplace;
			}
			marketplace.setNode((EcoreUtil.copy((Node)query.list().get(0))));
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		}
		return marketplace;
	}

	@SuppressWarnings("unchecked")
	public Marketplace getCatalogs() {
		Marketplace marketplace = MarketplaceFactory.eINSTANCE.createMarketplace();
		marketplace.setBaseUrl(environment.getProperty("marketplace.base-url"));
		Catalogs catalogs = MarketplaceFactory.eINSTANCE.createCatalogs();
		marketplace.setCatalogs(catalogs);
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			catalogs.getItems().add(getCatalog());
			Query query = sessionFactory.getCurrentSession().createQuery("SELECT catalog FROM Catalog catalog");
			catalogs.getItems().addAll(EcoreUtil.copyAll(query.list()));
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		}
		return marketplace;
	}

	@SuppressWarnings("unchecked")
	public Marketplace getMarkets() {
		Marketplace marketplace = MarketplaceFactory.eINSTANCE.createMarketplace();
		marketplace.setBaseUrl(environment.getProperty("marketplace.base-url"));
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Query query = sessionFactory.getCurrentSession().createQuery("SELECT market FROM Market market");
			marketplace.getMarkets().addAll(EcoreUtil.copyAll(query.list()));
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		}
		return marketplace;
	}

	@SuppressWarnings("unchecked")
	public Marketplace getFeatured() {
		Marketplace marketplace = MarketplaceFactory.eINSTANCE.createMarketplace();
		marketplace.setBaseUrl(environment.getProperty("marketplace.base-url"));
		Featured featured = MarketplaceFactory.eINSTANCE.createFeatured();
		marketplace.setFeatured(featured);
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Query query = sessionFactory.getCurrentSession()
					.createQuery("SELECT node FROM Node node ORDER BY node.changed DESC");
			query.setMaxResults(Integer.parseInt(environment.getProperty("marketplace.featured-items")));
			featured.getNodes().addAll(EcoreUtil.copyAll(query.list()));
			featured.setCount(featured.getNodes().size());
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		}
		return marketplace;
	}

	@SuppressWarnings("unchecked")
	public Marketplace getRecent() {
		Marketplace marketplace = MarketplaceFactory.eINSTANCE.createMarketplace();
		marketplace.setBaseUrl(environment.getProperty("marketplace.base-url"));
		Recent recent = MarketplaceFactory.eINSTANCE.createRecent();
		marketplace.setRecent(recent);
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Query query = sessionFactory.getCurrentSession().createQuery("SELECT node FROM Node node ORDER BY node.changed DESC");
			query.setMaxResults(Integer.parseInt(environment.getProperty("marketplace.recent-items")));
			recent.getNodes().addAll(EcoreUtil.copyAll(query.list()));
			recent.setCount(recent.getNodes().size());
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		}
		return marketplace;
	}

	@SuppressWarnings("unchecked")
	public Marketplace getSearchResult(String term) {
		Marketplace marketplace = MarketplaceFactory.eINSTANCE.createMarketplace();
		marketplace.setBaseUrl(environment.getProperty("marketplace.base-url"));
		Search search = MarketplaceFactory.eINSTANCE.createSearch();
		term = term.toLowerCase();
		search.setTerm(term);
		search.setUrl(environment.getProperty("marketplace.base-url")+"/search?term="+term);
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
			e.printStackTrace();
		}
		return marketplace;
	}
	
	@SuppressWarnings("unchecked")
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
			e.printStackTrace();
		}
		return tags;
	}
		
	@SuppressWarnings("unchecked")
	public Marketplace getSolutionsWithTag(String tag) {
		Marketplace marketplace = MarketplaceFactory.eINSTANCE.createMarketplace();
		marketplace.setBaseUrl(environment.getProperty("marketplace.base-url"));
		Search search = MarketplaceFactory.eINSTANCE.createSearch();
		search.setTerm(tag);
		search.setUrl(environment.getProperty("marketplace.base-url")+"/search?tag="+tag);
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
			e.printStackTrace();
		}
		return marketplace;
	}
	
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
			e.printStackTrace();
		}
		return node;
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
	public synchronized Object saveOrUpdateSolution(Node s, Account account) throws NamingException{
		
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
			
			s.setChanged(System.currentTimeMillis());
			s.setOwner(account.getFirstName()+" "+account.getLastName());

			// set a few values for new entities
			if (isNewSolution) {
				logger.info("Creating a new solution instance in database");
				s.setCreated(null);
				s.setUpdateurl(""); // http://localhost:8080/files/1 for solution #1
			}
			// verify that we have the correct owner
			if (!isNewSolution) {
				Account a = accountRepository.findAccountBySolutionId(s.getId()); 
				if (!account.getUsername().equals(a.getUsername())) {
					return "Invalid solution owner";
				}
				logger.info("Updating solution #"+s.getId());
			}
			sessionFactory.getCurrentSession().saveOrUpdate(s);
			sessionFactory.getCurrentSession().getTransaction().commit();
			// associate the new solution with the user account
			if (isNewSolution) {
				accountRepository.createAccountSolutionMapping(account, s.getId());
			}
			logger.info("Saved solution #" + s.getId() + " - " + s.getName());
			return s;
		} catch (Exception e) {			
			sessionFactory.getCurrentSession().getTransaction().rollback();
			return e;
		}
	}

}
