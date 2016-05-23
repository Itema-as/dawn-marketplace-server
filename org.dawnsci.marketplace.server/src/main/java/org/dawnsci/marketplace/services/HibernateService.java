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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.dawnsci.marketplace.Marketplace;
import org.dawnsci.marketplace.MarketplacePackage;
import org.dawnsci.marketplace.Node;
import org.dawnsci.marketplace.util.MarketplaceResourceFactoryImpl;
import org.dawnsci.marketplace.util.MarketplaceResourceImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.teneo.PersistenceOptions;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.zeroturnaround.zip.ZipUtil;

/**
 * Instantiates Hibernate and Teneo for use as the persistence store for
 * marketplace EMF object.
 *
 * @author Torkild U. Resheim, Itema AS
 */
@Service
public class HibernateService {

	private HbDataStore hbds;

	@Inject
	private FileService fileService;

	@Inject
	private org.springframework.core.env.Environment environment;

	@Bean
	public SessionFactory sessionFactory() {
		// http://hsqldb.org/doc/2.0/guide/deployment-chapt.html#dec_app_dev_testing
		final Properties props = new Properties();
		props.setProperty(Environment.DRIVER, "org.hsqldb.jdbcDriver");
		props.setProperty(Environment.USER, "sa");
		// close database when all connections are lost.
		props.setProperty(Environment.URL, environment.getProperty("marketplace.marketplace-db"));
		props.setProperty(Environment.PASS, "");
		props.setProperty(Environment.DIALECT, org.hibernate.dialect.HSQLDialect.class.getName());
		props.setProperty(Environment.ENABLE_LAZY_LOAD_NO_TRANS, "true");
		// for debugging
		//props.setProperty(Environment.SHOW_SQL, "true");
		// http://wiki.eclipse.org/Teneo/Hibernate/Configuration_Options
		props.setProperty(PersistenceOptions.CASCADE_POLICY_ON_CONTAINMENT, "all");
		props.setProperty(PersistenceOptions.CASCADE_POLICY_ON_NON_CONTAINMENT, "all");

		// configure synthetic version column (hsqldb no like e_version)
		props.setProperty(PersistenceOptions.VERSION_COLUMN_NAME, "pversion");
		props.setProperty(PersistenceOptions.ALWAYS_VERSION, "true");

		// enable the thread-bound strategy for obtaining currentSession
		// see https://developer.jboss.org/wiki/Sessionsandtransactions#jive_content_id_Transaction_demarcation_with_plain_JDBC
		props.setProperty("hibernate.current_session_context_class", "thread");
		props.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");

		// make sure the "id" feature of each EClass is used as identifier.
		// when an "id" feature does not exist, an "e_id" column will be created
		props.setProperty(PersistenceOptions.DEFAULT_ID_FEATURE_NAME, "id");

		// we have specified these using annotations
		props.setProperty(PersistenceOptions.ID_FEATURE_AS_PRIMARY_KEY, "false");
		props.setProperty(PersistenceOptions.SET_GENERATED_VALUE_ON_ID_FEATURE, "false");
		hbds = HbHelper.INSTANCE.createRegisterDataStore("marketplace");
		hbds.setDataStoreProperties(props);
		hbds.setEPackages(new EPackage[] { MarketplacePackage.eINSTANCE });

		hbds.initialize();
		loadMarkets();
		loadSolutions();

		return hbds.getSessionFactory();
	}

	public void loadMarkets() {
		try {
			hbds.getSessionFactory().getCurrentSession().beginTransaction();
			// load catalogs from test or sample data
			// TODO: Enable when we do have some catalogs
//			EList<EObject> catalogList = loadSerialized("data/catalogs.xml");
//			for (EObject catalog : catalogList) {
//				session.saveOrUpdate(catalog);
//			}
			// remove old data
			Query query = hbds.getSessionFactory().getCurrentSession().createQuery("delete from Market");
			query.executeUpdate();
			// load markets from test or sample data
			EList<EObject> markets = loadSerialized("data/markets.xml");
			for (EObject market : markets) {
				hbds.getSessionFactory().getCurrentSession().saveOrUpdate(market);
			}
			hbds.getSessionFactory().getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			hbds.getSessionFactory().getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		}

	}

	@Transactional
	public void loadSolutions() {
			// load solutions from file
			EList<EObject> solutions = loadSerialized("data/solutions.xml");
			EList<Node> nodes = ((Marketplace)solutions.get(0)).getFeatured().getNodes();
			for (Node node : nodes) {
				Node copy = EcoreUtil.copy(node);
			try {
				hbds.getSessionFactory().getCurrentSession().beginTransaction();
				// remove the old node, and replace it with a version loaded from file
				Query createQuery = hbds.getSessionFactory().getCurrentSession().createQuery("SELECT node FROM Node node WHERE node.id='" + copy.getId() + "'");
				if (createQuery.list().isEmpty()) {
					hbds.getSessionFactory().getCurrentSession().saveOrUpdate(copy);
				}
				hbds.getSessionFactory().getCurrentSession().getTransaction().commit();
			} catch (Exception e) {
				hbds.getSessionFactory().getCurrentSession().getTransaction().rollback();
				e.printStackTrace();
			}
				// copy the screenshot image
				if (StringUtils.isNotEmpty(copy.getScreenshot())){
					try {
						FileUtils.copyInputStreamToFile(
								getSolutionsInputStream(copy.getScreenshot()),
								fileService.getFile(Long.toString(copy.getId()),
										copy.getScreenshot()));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				// copy the icon image
				if (StringUtils.isNotEmpty(copy.getImage())){
					try {
						FileUtils.copyInputStreamToFile(
								getSolutionsInputStream(copy.getImage()),
								fileService.getFile(Long.toString(copy.getId()),
										copy.getImage()));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				// unzip the p2-repository
				File p2repo = fileService.getSolutionFile(String.valueOf(copy.getId()));
				ZipUtil.unpack(getSolutionsInputStream("p2-repo.zip"), p2repo);
			}

	}

	private InputStream getSolutionsInputStream(String filename) {
		try {
			InputStream is = MarketplaceDAO.class.getClassLoader().getResource("data/solutions/"+filename).openStream();
			return is;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Loads a marketplace resource from XML. The file requested must be present
	 * in the classpath.
	 *
	 * @param filename
	 *            the filename to load
	 * @return
	 */
	private EList<EObject> loadSerialized(String filename) {
		ResourceSet rs = new ResourceSetImpl();
		rs.getPackageRegistry().put(null, MarketplacePackage.eINSTANCE);
		try {
			Resource resource = rs.createResource(URI.createFileURI(filename));
			InputStream is = MarketplaceDAO.class.getClassLoader().getResource(filename).openStream();
			resource.load(is, rs.getLoadOptions());
			return resource.getContents();
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
				// treat "href" attributes as features
				loadOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
				// required in order to correctly read in attributes
				loadOptions.put(XMLResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE);
				// we use UTF-8 encoding
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
