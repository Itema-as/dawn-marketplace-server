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
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.dawnsci.marketplace.Catalog;
import org.dawnsci.marketplace.Catalogs;
import org.dawnsci.marketplace.Market;
import org.dawnsci.marketplace.Marketplace;
import org.dawnsci.marketplace.MarketplacePackage;
import org.dawnsci.marketplace.Node;
import org.dawnsci.marketplace.util.MarketplaceResourceFactoryImpl;
import org.dawnsci.marketplace.util.MarketplaceResourceImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.teneo.PersistenceOptions;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
/**
 * @author Torkild U. Resheim, Itema AS
 */
@Service
public class HibernateService {
	
	private HbDataStore hbds;
	 
	@Bean
	public SessionFactory sessionFactory(){
		// http://hsqldb.org/doc/2.0/guide/deployment-chapt.html#dec_app_dev_testing
		final Properties props = new Properties();
		props.setProperty(Environment.DRIVER, "org.hsqldb.jdbcDriver");
		props.setProperty(Environment.USER, "sa");
		// close database when all connections are lost.
//		props.setProperty(Environment.URL, "jdbc:hsqldb:file:database/Marketplace;shutdown=true;hsqldb.default_table_type=cached");
		props.setProperty(Environment.URL, "jdbc:hsqldb:mem:database/Marketplace");
		props.setProperty(Environment.PASS, "");
		props.setProperty(Environment.DIALECT, org.hibernate.dialect.HSQLDialect.class.getName());
		props.setProperty(Environment.ENABLE_LAZY_LOAD_NO_TRANS, "true");
		// http://wiki.eclipse.org/Teneo/Hibernate/Configuration_Options
		props.setProperty(PersistenceOptions.CASCADE_POLICY_ON_NON_CONTAINMENT, "REFRESH,PERSIST,MERGE");

		String hbName = "Marketplace";
		hbds = HbHelper.INSTANCE.createRegisterDataStore(hbName);
		hbds.setDataStoreProperties(props);
		hbds.setEPackages(new EPackage[] { MarketplacePackage.eINSTANCE });

		try {
			hbds.initialize();
		} finally {
		}
		prepopulate();
		return hbds.getSessionFactory();
	}
	
	/**
	 * Populate the database with some initial data.
	 */
	void prepopulate() {
		Session session = hbds.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			// EcoreUtil.copy is used here to avoid having Hibernate
			// persisting container objects, such as "Marketplace".
			Node node = loadResource("sample.xml").getNode();
			// create 50 sample plug-ins
			for (int i=1000;i<=1200;i++){
				node.setId(Long.valueOf(i));
				node.setName("Sample plug-in #"+(i-999));
				node.setChanged(LocalDate.now().toEpochDay());
				session.saveOrUpdate(EcoreUtil.copy(node));
			}
			// create the markets
			EList<Market> markets = loadResource("markets.xml").getMarkets();
			for (Market market : markets) {
				session.saveOrUpdate(EcoreUtil.copy(market));			
			}
			// create the catalogs list
			Catalogs catalogs = loadResource("catalogs.xml").getCatalogs();
			EList<Catalog> items = catalogs.getItems();
			for (Catalog catalog : items) {
				session.saveOrUpdate(EcoreUtil.copy(catalog));			
			}
			session.flush();
			session.getTransaction().commit();
		} catch (Exception e){
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
	/**
	 * Loads a marketplace resource from XML. The file requested must be 
	 * present in the classpath.
	 * 
	 * @param filename the filename to load
	 * @return
	 */
	private Marketplace loadResource(String filename) {
		ResourceSet rs = new ResourceSetImpl();
		rs.getPackageRegistry().put(null, MarketplacePackage.eINSTANCE);
		try {
			Resource resource = rs.createResource(URI.createFileURI(filename));
			InputStream is = DataService.class.getClassLoader().getResource(filename).openStream();
			resource.load(is,rs.getLoadOptions());
			return (Marketplace) resource.getContents().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Registers a new resource factory for the data structures. This is
	 * normally done through Eclipse extension points but we also need to be
	 * able to create this factory without the Eclipse runtime.
	 */
	static {
		// register package so that it is available even without the Eclipse
		// runtime
		@SuppressWarnings("unused")
		MarketplacePackage packageInstance = MarketplacePackage.eINSTANCE;
		// register the resource factory
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new MarketplaceResourceFactoryImpl() {
			@Override
			public Resource createResource(URI uri) {
				// create the new resource implementation
				MarketplaceResourceImpl xmiResource = new MarketplaceResourceImpl(uri);
				// obtain options
				Map<Object, Object> loadOptions = xmiResource.getDefaultLoadOptions();
				Map<Object, Object> saveOptions = xmiResource.getDefaultSaveOptions();
				// use extended metadata for both loading and saving
				saveOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
				loadOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
				// Treat "href" attributes as features
				loadOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
				// required in order to correctly read in attributes
				loadOptions.put(XMLResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE);
				// We UTF-8 encoding
				loadOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
				saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
				// do not download any external DTDs.
				Map<String, Object> parserFeatures = new HashMap<String, Object>();
				parserFeatures.put("http://xml.org/sax/features/validation", Boolean.FALSE); //$NON-NLS-1$
				parserFeatures.put("http://apache.org/xml/features/nonvalidating/load-external-dtd", //$NON-NLS-1$
						Boolean.FALSE);
				loadOptions.put(XMLResource.OPTION_PARSER_FEATURES, parserFeatures);
				return xmiResource;
			}
		});
	}

}
