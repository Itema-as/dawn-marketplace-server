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
package org.dawnsci.marketplace.server;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.dawnsci.marketplace.Marketplace;
import org.dawnsci.marketplace.MarketplacePackage;
import org.dawnsci.marketplace.util.MarketplaceResourceFactoryImpl;
import org.dawnsci.marketplace.util.MarketplaceResourceImpl;
import org.dawnsci.marketplace.server.DataService;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * Special configuration that keeps the marketplace data in XML files so
 * that tests can be executed without access to a persistence layer. The data
 * files are created using output from the official marketplace server at
 * http://marketplace.eclipse.org
 * 
 * @author Torkild U. Resheim
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "org.dawnsci.marketplace.server" })
@Profile("test")
public class TestConfiguration {

	@Bean
	@Primary
	public DataService catalogService() {
		// mock the data service and return hard coded results from XML-files when requested
		DataService dataService = Mockito.mock(DataService.class);
		Mockito.when(dataService.getCatalogs()).thenReturn(loadResource("catalogs.xml"));
		Mockito.when(dataService.getContent("364668")).thenReturn(loadResource("364668.xml"));
		Mockito.when(dataService.getMarkets()).thenReturn(loadResource("markets.xml"));
		Mockito.when(dataService.getFeatured()).thenReturn(loadResource("featured.xml"));
		return dataService;
	}

	@Bean
	@Primary
	public HibernateService hibernateService() {
		// mock the Hibernate service and inhibit setting up the database.
		HibernateService hibernateService = Mockito.mock(HibernateService.class);
		Mockito.when(hibernateService.sessionFactory()).thenReturn(null);
		return hibernateService;
	}

	private Marketplace loadResource(String filename) {
		ResourceSet rs = new ResourceSetImpl();
		rs.getPackageRegistry().put(null, MarketplacePackage.eINSTANCE);
		try {
			Resource resource = rs.createResource(URI.createFileURI(filename));
			InputStream is = TestConfiguration.class.getClassLoader().getResource(filename).openStream();
			resource.load(is,rs.getLoadOptions());
			return (Marketplace) resource.getContents().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Registers a new resource factory for the data structures. This is
	 * normally done through Eclipse extension points but we also need to be
	 * able to create this factory without the Eclipse runtime. Settings here
	 * must be identical to what is done in the CatalogService
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
				saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
				loadOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
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