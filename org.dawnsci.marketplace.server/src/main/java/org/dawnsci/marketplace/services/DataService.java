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
import java.util.List;

import javax.inject.Inject;

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
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @author Torkild U. Resheim, Itema AS
 */
@Service
public class DataService {
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

	@Inject
	private SessionFactory sessionFactory;
	
	@Inject
	Environment environment;
	
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
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("SELECT node FROM Node node WHERE node.id='" + identifier + "'");
			query.setMaxResults(1);
			if (query.list().isEmpty()) {
				return marketplace;
			}
			marketplace.setNode((Node) query.list().get(0));
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			session.close();
		}
		return marketplace;
	}

	@SuppressWarnings("unchecked")
	public Marketplace getCatalogs() {
		Marketplace marketplace = MarketplaceFactory.eINSTANCE.createMarketplace();
		marketplace.setBaseUrl(environment.getProperty("marketplace.base-url"));
		Catalogs catalogs = MarketplaceFactory.eINSTANCE.createCatalogs();
		marketplace.setCatalogs(catalogs);
		Session session = sessionFactory.openSession();
		catalogs.getItems().add(getCatalog());
		Query query = session.createQuery("SELECT catalog FROM Catalog catalog");
		catalogs.getItems().addAll(query.list());
		session.close();
		return marketplace;
	}

	@SuppressWarnings("unchecked")
	public Marketplace getMarkets() {
		Marketplace marketplace = MarketplaceFactory.eINSTANCE.createMarketplace();
		marketplace.setBaseUrl(environment.getProperty("marketplace.base-url"));
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("SELECT market FROM Market market");
		marketplace.getMarkets().addAll(query.list());
		session.close();
		return marketplace;
	}

	/**
	 * Returns the features that was last updated.
	 * 
	 * TODO: Add a featured flag to "node" and use this
	 */
	@SuppressWarnings("unchecked")
	public Marketplace getFeatured() {
		Marketplace marketplace = MarketplaceFactory.eINSTANCE.createMarketplace();
		marketplace.setBaseUrl(environment.getProperty("marketplace.base-url"));
		Featured featured = MarketplaceFactory.eINSTANCE.createFeatured();
		marketplace.setFeatured(featured);
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("SELECT node FROM Node node ORDER BY node.changed DESC");
		query.setMaxResults(Integer.parseInt(environment.getProperty("marketplace.featured-items")));
		featured.getNodes().addAll(query.list());
		featured.setCount(featured.getNodes().size());
		session.close();
		return marketplace;
	}

	/**
	 * Returns the most recent updated solutions.
	 */
	@SuppressWarnings("unchecked")
	public Marketplace getRecent() {
		Marketplace marketplace = MarketplaceFactory.eINSTANCE.createMarketplace();
		marketplace.setBaseUrl(environment.getProperty("marketplace.base-url"));
		Recent recent = MarketplaceFactory.eINSTANCE.createRecent();
		marketplace.setRecent(recent);
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("SELECT node FROM Node node ORDER BY node.changed DESC");
		query.setMaxResults(Integer.parseInt(environment.getProperty("marketplace.recent-items")));
		recent.getNodes().addAll(query.list());
		recent.setCount(recent.getNodes().size());
		session.close();
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
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery(HQL_SEARCH).setString("term", "%"+term+"%");
			List<Node> list = query.list();
			search.getNodes().addAll(list);
			search.setCount(search.getNodes().size());
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			session.close();
		}
		return marketplace;
	}

}
