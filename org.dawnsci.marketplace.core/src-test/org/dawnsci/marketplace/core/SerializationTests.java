package org.dawnsci.marketplace.core;


import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.dawnsci.marketplace.MarketplacePackage;
import org.dawnsci.marketplace.util.MarketplaceResourceFactoryImpl;
import org.dawnsci.marketplace.util.MarketplaceResourceImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.junit.Test;

public class SerializationTests {
	
	/**
	 * Tests parsing the result from a REST API call to marketplace.eclipse.org
	 * <pre>
	 * curl http://marketplace.eclipse.org/featured/api/p
	 * </pre>
	 * @throws IOException 
	 */
	@Test
	public void testFeatured() throws IOException{		
		registerResourceFactory();		
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(null, MarketplacePackage.eINSTANCE);
		URL url = SerializationTests.class.getResource("featured.xml");
		URI uri = URI.createURI(url.toString());
		Resource resource = resourceSet.createResource(uri);
		resource.load(null);
		// load will fail of the there's not a match in structure or fields
		resource.getContents();
	}

	/**
	 * Tests parsing the result from a REST API call to marketplace.eclipse.org
	 * <pre>
	 * curl http://marketplace.eclipse.org/node/364668/api/p
	 * </pre>
	 * @throws IOException 
	 */
	@Test
	public void testNode() throws IOException{		
		registerResourceFactory();		
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(null, MarketplacePackage.eINSTANCE);
		URL url = SerializationTests.class.getResource("364668.xml");
		URI uri = URI.createURI(url.toString());
		Resource resource = resourceSet.createResource(uri);
		resource.load(null);
		// load will fail of the there's not a match in structure or fields
		resource.getContents();
	}
	/**
	 * Tests parsing the result from a REST API call to marketplace.eclipse.org
	 * <pre>
	 * curl http://marketplace.eclipse.org/catalogs/api/p 
	 * </pre>
	 * @throws IOException 
	 */
	@Test
	public void testCatalogs() throws IOException{		
		registerResourceFactory();		
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(null, MarketplacePackage.eINSTANCE);
		URL url = SerializationTests.class.getResource("catalogs.xml");
		URI uri = URI.createURI(url.toString());
		Resource resource = resourceSet.createResource(uri);
		resource.load(null);
		// load will fail of the there's not a match in structure or fields
		resource.getContents();
	}
	/**
	 * Tests parsing the result from a REST API call to marketplace.eclipse.org
	 * <pre>
	 * curl [ ] http://marketplace.eclipse.org/api/p 
	 * </pre>
	 * @throws IOException 
	 */
	@Test
	public void testMarkets() throws IOException{		
		registerResourceFactory();		
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(null, MarketplacePackage.eINSTANCE);
		URL url = SerializationTests.class.getResource("markets.xml");
		URI uri = URI.createURI(url.toString());
		Resource resource = resourceSet.createResource(uri);
		resource.load(null);
		// load will fail of the there's not a match in structure or fields
		resource.getContents();
	}
	/**
	 * Registers a new resource factory for e data structures. This is normally done through Eclipse extension points
	 * but we also need to be able to create this factory without the Eclipse runtime.
	 */
	private void registerResourceFactory() {
		// register package so that it is available even without the Eclipse runtime
		@SuppressWarnings("unused")
		MarketplacePackage packageInstance = MarketplacePackage.eINSTANCE;
		// register the resource factory
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*",
				new MarketplaceResourceFactoryImpl() {
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
						// required in order to correctly read in attributes
						loadOptions.put(XMLResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE);
						// UTF-8 encoding is required per specification
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
