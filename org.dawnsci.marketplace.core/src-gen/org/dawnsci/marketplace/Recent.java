/**
 */
package org.dawnsci.marketplace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Recent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dawnsci.marketplace.Recent#getCount <em>Count</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Recent#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @see org.dawnsci.marketplace.MarketplacePackage#getRecent()
 * @model
 * @generated
 */
public interface Recent extends EObject {
	/**
	 * Returns the value of the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count</em>' attribute.
	 * @see #setCount(int)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getRecent_Count()
	 * @model required="true"
	 * @generated
	 */
	int getCount();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Recent#getCount <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count</em>' attribute.
	 * @see #getCount()
	 * @generated
	 */
	void setCount(int value);

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.dawnsci.marketplace.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.dawnsci.marketplace.MarketplacePackage#getRecent_Nodes()
	 * @model containment="true"
	 *        extendedMetaData="name='node'"
	 * @generated
	 */
	EList<Node> getNodes();

} // Recent
