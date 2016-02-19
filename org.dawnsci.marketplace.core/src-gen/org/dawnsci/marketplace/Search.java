/**
 */
package org.dawnsci.marketplace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Search</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dawnsci.marketplace.Search#getTerm <em>Term</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Search#getUrl <em>Url</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Search#getCount <em>Count</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Search#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @see org.dawnsci.marketplace.MarketplacePackage#getSearch()
 * @model
 * @generated
 */
public interface Search extends EObject {
	/**
	 * Returns the value of the '<em><b>Term</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Term</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Term</em>' attribute.
	 * @see #setTerm(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getSearch_Term()
	 * @model required="true"
	 * @generated
	 */
	String getTerm();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Search#getTerm <em>Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Term</em>' attribute.
	 * @see #getTerm()
	 * @generated
	 */
	void setTerm(String value);

	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getSearch_Url()
	 * @model required="true"
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Search#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

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
	 * @see org.dawnsci.marketplace.MarketplacePackage#getSearch_Count()
	 * @model required="true"
	 * @generated
	 */
	int getCount();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Search#getCount <em>Count</em>}' attribute.
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
	 * @see org.dawnsci.marketplace.MarketplacePackage#getSearch_Nodes()
	 * @model containment="true"
	 *        extendedMetaData="name='node'"
	 * @generated
	 */
	EList<Node> getNodes();

} // Search
