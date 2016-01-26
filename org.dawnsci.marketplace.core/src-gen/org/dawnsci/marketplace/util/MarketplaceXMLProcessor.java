/**
 */
package org.dawnsci.marketplace.util;

import java.util.Map;

import org.dawnsci.marketplace.MarketplacePackage;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MarketplaceXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarketplaceXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		MarketplacePackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the MarketplaceResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new MarketplaceResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new MarketplaceResourceFactoryImpl());
		}
		return registrations;
	}

} //MarketplaceXMLProcessor
