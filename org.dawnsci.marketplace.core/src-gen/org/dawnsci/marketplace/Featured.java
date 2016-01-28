/**
 */
package org.dawnsci.marketplace;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Featured</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dawnsci.marketplace.Featured#getCount <em>Count</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Featured#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @see org.dawnsci.marketplace.MarketplacePackage#getFeatured()
 * @model
 * @generated
 */
public interface Featured extends EObject {
	/**
	 * Returns the value of the '<em><b>Count</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count</em>' attribute.
	 * @see #setCount(Integer)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getFeatured_Count()
	 * @model default="0"
	 * @generated
	 */
	Integer getCount();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Featured#getCount <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count</em>' attribute.
	 * @see #getCount()
	 * @generated
	 */
	void setCount(Integer value);

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.dawnsci.marketplace.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.dawnsci.marketplace.MarketplacePackage#getFeatured_Nodes()
	 * @model containment="true"
	 *        extendedMetaData="name='node'"
	 * @generated
	 */
	EList<Node> getNodes();

} // Featured
