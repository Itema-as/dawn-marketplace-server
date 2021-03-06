/**
 */
package org.dawnsci.marketplace;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Marketplace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dawnsci.marketplace.Marketplace#getNode <em>Node</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Marketplace#getCatalogs <em>Catalogs</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Marketplace#getMarkets <em>Markets</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Marketplace#getFeatured <em>Featured</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Marketplace#getBaseUrl <em>Base Url</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Marketplace#getSearch <em>Search</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Marketplace#getRecent <em>Recent</em>}</li>
 * </ul>
 *
 * @see org.dawnsci.marketplace.MarketplacePackage#getMarketplace()
 * @model extendedMetaData="name='marketplace'"
 * @generated
 */
public interface Marketplace extends EObject {
	/**
	 * Returns the value of the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' containment reference.
	 * @see #setNode(Node)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getMarketplace_Node()
	 * @model containment="true"
	 * @generated
	 */
	Node getNode();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Marketplace#getNode <em>Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' containment reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(Node value);

	/**
	 * Returns the value of the '<em><b>Catalogs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Catalogs</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Catalogs</em>' containment reference.
	 * @see #setCatalogs(Catalogs)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getMarketplace_Catalogs()
	 * @model containment="true"
	 * @generated
	 */
	Catalogs getCatalogs();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Marketplace#getCatalogs <em>Catalogs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Catalogs</em>' containment reference.
	 * @see #getCatalogs()
	 * @generated
	 */
	void setCatalogs(Catalogs value);

	/**
	 * Returns the value of the '<em><b>Markets</b></em>' containment reference list.
	 * The list contents are of type {@link org.dawnsci.marketplace.Market}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Markets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Markets</em>' containment reference list.
	 * @see org.dawnsci.marketplace.MarketplacePackage#getMarketplace_Markets()
	 * @model containment="true"
	 *        extendedMetaData="name='market'"
	 * @generated
	 */
	EList<Market> getMarkets();

	/**
	 * Returns the value of the '<em><b>Featured</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Featured</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Featured</em>' containment reference.
	 * @see #setFeatured(Featured)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getMarketplace_Featured()
	 * @model containment="true"
	 * @generated
	 */
	Featured getFeatured();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Marketplace#getFeatured <em>Featured</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Featured</em>' containment reference.
	 * @see #getFeatured()
	 * @generated
	 */
	void setFeatured(Featured value);

	/**
	 * Returns the value of the '<em><b>Base Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Used to calcuate URL's in contained objects.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Base Url</em>' attribute.
	 * @see #setBaseUrl(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getMarketplace_BaseUrl()
	 * @model transient="true"
	 * @generated
	 */
	String getBaseUrl();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Marketplace#getBaseUrl <em>Base Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Url</em>' attribute.
	 * @see #getBaseUrl()
	 * @generated
	 */
	void setBaseUrl(String value);

	/**
	 * Returns the value of the '<em><b>Search</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Search</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Search</em>' containment reference.
	 * @see #setSearch(Search)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getMarketplace_Search()
	 * @model containment="true"
	 * @generated
	 */
	Search getSearch();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Marketplace#getSearch <em>Search</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Search</em>' containment reference.
	 * @see #getSearch()
	 * @generated
	 */
	void setSearch(Search value);

	/**
	 * Returns the value of the '<em><b>Recent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recent</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recent</em>' containment reference.
	 * @see #setRecent(Recent)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getMarketplace_Recent()
	 * @model containment="true"
	 * @generated
	 */
	Recent getRecent();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Marketplace#getRecent <em>Recent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recent</em>' containment reference.
	 * @see #getRecent()
	 * @generated
	 */
	void setRecent(Recent value);

} // Marketplace
