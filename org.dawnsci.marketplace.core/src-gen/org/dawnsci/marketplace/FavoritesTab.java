/**
 */
package org.dawnsci.marketplace;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Favorites Tab</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dawnsci.marketplace.FavoritesTab#getEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.FavoritesTab#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.FavoritesTab#getApiserver <em>Apiserver</em>}</li>
 * </ul>
 *
 * @see org.dawnsci.marketplace.MarketplacePackage#getFavoritesTab()
 * @model extendedMetaData="kind='mixed'"
 * @generated
 */
public interface FavoritesTab extends EObject {
	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(Integer)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getFavoritesTab_Enabled()
	 * @model required="true"
	 * @generated
	 */
	Integer getEnabled();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.FavoritesTab#getEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #getEnabled()
	 * @generated
	 */
	void setEnabled(Integer value);

	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see org.dawnsci.marketplace.MarketplacePackage#getFavoritesTab_Mixed()
	 * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" required="true" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>Apiserver</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Apiserver</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Apiserver</em>' attribute.
	 * @see #setApiserver(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getFavoritesTab_Apiserver()
	 * @model
	 * @generated
	 */
	String getApiserver();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.FavoritesTab#getApiserver <em>Apiserver</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Apiserver</em>' attribute.
	 * @see #getApiserver()
	 * @generated
	 */
	void setApiserver(String value);

} // FavoritesTab
