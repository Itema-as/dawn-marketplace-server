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
 *   <li>{@link org.dawnsci.marketplace.Marketplace#getMarket <em>Market</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Marketplace#getFeatured <em>Featured</em>}</li>
 * </ul>
 *
 * @see org.dawnsci.marketplace.MarketplacePackage#getMarketplace()
 * @model extendedMetaData="name='marketplace'"
 * @generated
 */
public interface Marketplace extends EObject {
	/**
	 * Returns the value of the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' reference.
	 * @see #setNode(Node)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getMarketplace_Node()
	 * @model
	 * @generated
	 */
	Node getNode();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Marketplace#getNode <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' reference.
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
	 * Returns the value of the '<em><b>Market</b></em>' containment reference list.
	 * The list contents are of type {@link org.dawnsci.marketplace.Market}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Market</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Market</em>' containment reference list.
	 * @see org.dawnsci.marketplace.MarketplacePackage#getMarketplace_Market()
	 * @model containment="true"
	 *        extendedMetaData="name='market'"
	 * @generated
	 */
	EList<Market> getMarket();

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

} // Marketplace
