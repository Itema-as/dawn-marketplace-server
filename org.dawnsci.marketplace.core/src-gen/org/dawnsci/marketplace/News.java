/**
 */
package org.dawnsci.marketplace;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>News</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dawnsci.marketplace.News#getShorttitle <em>Shorttitle</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.News#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.News#getTimestamp <em>Timestamp</em>}</li>
 * </ul>
 *
 * @see org.dawnsci.marketplace.MarketplacePackage#getNews()
 * @model extendedMetaData="kind='mixed'"
 * @generated
 */
public interface News extends EObject {
	/**
	 * Returns the value of the '<em><b>Shorttitle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shorttitle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shorttitle</em>' attribute.
	 * @see #setShorttitle(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNews_Shorttitle()
	 * @model required="true"
	 * @generated
	 */
	String getShorttitle();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.News#getShorttitle <em>Shorttitle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shorttitle</em>' attribute.
	 * @see #getShorttitle()
	 * @generated
	 */
	void setShorttitle(String value);

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
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNews_Mixed()
	 * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" required="true" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timestamp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timestamp</em>' attribute.
	 * @see #setTimestamp(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNews_Timestamp()
	 * @model
	 * @generated
	 */
	String getTimestamp();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.News#getTimestamp <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timestamp</em>' attribute.
	 * @see #getTimestamp()
	 * @generated
	 */
	void setTimestamp(String value);

} // News
