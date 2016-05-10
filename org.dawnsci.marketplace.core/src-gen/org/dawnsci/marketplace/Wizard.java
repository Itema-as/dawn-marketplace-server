/**
 */
package org.dawnsci.marketplace;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wizard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dawnsci.marketplace.Wizard#getTitle <em>Title</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Wizard#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Wizard#getSearchtab <em>Searchtab</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Wizard#getPopulartab <em>Populartab</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Wizard#getRecenttab <em>Recenttab</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Wizard#getFavoritestab <em>Favoritestab</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Wizard#getNews <em>News</em>}</li>
 * </ul>
 *
 * @see org.dawnsci.marketplace.MarketplacePackage#getWizard()
 * @model
 * @generated
 */
public interface Wizard extends EObject {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getWizard_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Wizard#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' attribute.
	 * @see #setIcon(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getWizard_Icon()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getIcon();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Wizard#getIcon <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon</em>' attribute.
	 * @see #getIcon()
	 * @generated
	 */
	void setIcon(String value);

	/**
	 * Returns the value of the '<em><b>Searchtab</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Searchtab</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Searchtab</em>' containment reference.
	 * @see #setSearchtab(SearchTab)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getWizard_Searchtab()
	 * @model containment="true"
	 * @generated
	 */
	SearchTab getSearchtab();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Wizard#getSearchtab <em>Searchtab</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Searchtab</em>' containment reference.
	 * @see #getSearchtab()
	 * @generated
	 */
	void setSearchtab(SearchTab value);

	/**
	 * Returns the value of the '<em><b>Populartab</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Populartab</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Populartab</em>' containment reference.
	 * @see #setPopulartab(PopularTab)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getWizard_Populartab()
	 * @model containment="true"
	 * @generated
	 */
	PopularTab getPopulartab();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Wizard#getPopulartab <em>Populartab</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Populartab</em>' containment reference.
	 * @see #getPopulartab()
	 * @generated
	 */
	void setPopulartab(PopularTab value);

	/**
	 * Returns the value of the '<em><b>Recenttab</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recenttab</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recenttab</em>' containment reference.
	 * @see #setRecenttab(RecentTab)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getWizard_Recenttab()
	 * @model containment="true"
	 * @generated
	 */
	RecentTab getRecenttab();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Wizard#getRecenttab <em>Recenttab</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recenttab</em>' containment reference.
	 * @see #getRecenttab()
	 * @generated
	 */
	void setRecenttab(RecentTab value);

	/**
	 * Returns the value of the '<em><b>Favoritestab</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Favoritestab</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Favoritestab</em>' containment reference.
	 * @see #setFavoritestab(FavoritesTab)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getWizard_Favoritestab()
	 * @model containment="true"
	 * @generated
	 */
	FavoritesTab getFavoritestab();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Wizard#getFavoritestab <em>Favoritestab</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Favoritestab</em>' containment reference.
	 * @see #getFavoritestab()
	 * @generated
	 */
	void setFavoritestab(FavoritesTab value);

	/**
	 * Returns the value of the '<em><b>News</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>News</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>News</em>' containment reference.
	 * @see #setNews(News)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getWizard_News()
	 * @model containment="true"
	 * @generated
	 */
	News getNews();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Wizard#getNews <em>News</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>News</em>' containment reference.
	 * @see #getNews()
	 * @generated
	 */
	void setNews(News value);

} // Wizard
