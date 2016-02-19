/**
 */
package org.dawnsci.marketplace.impl;

import java.util.Collection;

import org.dawnsci.marketplace.Catalogs;
import org.dawnsci.marketplace.Featured;
import org.dawnsci.marketplace.Market;
import org.dawnsci.marketplace.Marketplace;
import org.dawnsci.marketplace.MarketplacePackage;
import org.dawnsci.marketplace.Node;
import org.dawnsci.marketplace.Recent;
import org.dawnsci.marketplace.Search;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Marketplace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dawnsci.marketplace.impl.MarketplaceImpl#getNode <em>Node</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.MarketplaceImpl#getCatalogs <em>Catalogs</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.MarketplaceImpl#getMarkets <em>Markets</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.MarketplaceImpl#getFeatured <em>Featured</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.MarketplaceImpl#getBaseUrl <em>Base Url</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.MarketplaceImpl#getSearch <em>Search</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.MarketplaceImpl#getRecent <em>Recent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MarketplaceImpl extends MinimalEObjectImpl.Container implements Marketplace {
	/**
	 * The cached value of the '{@link #getNode() <em>Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode()
	 * @generated
	 * @ordered
	 */
	protected Node node;

	/**
	 * The cached value of the '{@link #getCatalogs() <em>Catalogs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatalogs()
	 * @generated
	 * @ordered
	 */
	protected Catalogs catalogs;

	/**
	 * The cached value of the '{@link #getMarkets() <em>Markets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMarkets()
	 * @generated
	 * @ordered
	 */
	protected EList<Market> markets;

	/**
	 * The cached value of the '{@link #getFeatured() <em>Featured</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatured()
	 * @generated
	 * @ordered
	 */
	protected Featured featured;

	/**
	 * The default value of the '{@link #getBaseUrl() <em>Base Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBaseUrl() <em>Base Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseUrl()
	 * @generated
	 * @ordered
	 */
	protected String baseUrl = BASE_URL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSearch() <em>Search</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSearch()
	 * @generated
	 * @ordered
	 */
	protected Search search;

	/**
	 * The cached value of the '{@link #getRecent() <em>Recent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecent()
	 * @generated
	 * @ordered
	 */
	protected Recent recent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MarketplaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MarketplacePackage.Literals.MARKETPLACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getNode() {
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNode(Node newNode, NotificationChain msgs) {
		Node oldNode = node;
		node = newNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MarketplacePackage.MARKETPLACE__NODE, oldNode, newNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode(Node newNode) {
		if (newNode != node) {
			NotificationChain msgs = null;
			if (node != null)
				msgs = ((InternalEObject)node).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.MARKETPLACE__NODE, null, msgs);
			if (newNode != null)
				msgs = ((InternalEObject)newNode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.MARKETPLACE__NODE, null, msgs);
			msgs = basicSetNode(newNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.MARKETPLACE__NODE, newNode, newNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Catalogs getCatalogs() {
		return catalogs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCatalogs(Catalogs newCatalogs, NotificationChain msgs) {
		Catalogs oldCatalogs = catalogs;
		catalogs = newCatalogs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MarketplacePackage.MARKETPLACE__CATALOGS, oldCatalogs, newCatalogs);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCatalogs(Catalogs newCatalogs) {
		if (newCatalogs != catalogs) {
			NotificationChain msgs = null;
			if (catalogs != null)
				msgs = ((InternalEObject)catalogs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.MARKETPLACE__CATALOGS, null, msgs);
			if (newCatalogs != null)
				msgs = ((InternalEObject)newCatalogs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.MARKETPLACE__CATALOGS, null, msgs);
			msgs = basicSetCatalogs(newCatalogs, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.MARKETPLACE__CATALOGS, newCatalogs, newCatalogs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Market> getMarkets() {
		if (markets == null) {
			markets = new EObjectContainmentEList<Market>(Market.class, this, MarketplacePackage.MARKETPLACE__MARKETS);
		}
		return markets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Featured getFeatured() {
		return featured;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFeatured(Featured newFeatured, NotificationChain msgs) {
		Featured oldFeatured = featured;
		featured = newFeatured;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MarketplacePackage.MARKETPLACE__FEATURED, oldFeatured, newFeatured);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatured(Featured newFeatured) {
		if (newFeatured != featured) {
			NotificationChain msgs = null;
			if (featured != null)
				msgs = ((InternalEObject)featured).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.MARKETPLACE__FEATURED, null, msgs);
			if (newFeatured != null)
				msgs = ((InternalEObject)newFeatured).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.MARKETPLACE__FEATURED, null, msgs);
			msgs = basicSetFeatured(newFeatured, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.MARKETPLACE__FEATURED, newFeatured, newFeatured));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseUrl(String newBaseUrl) {
		String oldBaseUrl = baseUrl;
		baseUrl = newBaseUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.MARKETPLACE__BASE_URL, oldBaseUrl, baseUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Search getSearch() {
		return search;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSearch(Search newSearch, NotificationChain msgs) {
		Search oldSearch = search;
		search = newSearch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MarketplacePackage.MARKETPLACE__SEARCH, oldSearch, newSearch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSearch(Search newSearch) {
		if (newSearch != search) {
			NotificationChain msgs = null;
			if (search != null)
				msgs = ((InternalEObject)search).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.MARKETPLACE__SEARCH, null, msgs);
			if (newSearch != null)
				msgs = ((InternalEObject)newSearch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.MARKETPLACE__SEARCH, null, msgs);
			msgs = basicSetSearch(newSearch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.MARKETPLACE__SEARCH, newSearch, newSearch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Recent getRecent() {
		return recent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRecent(Recent newRecent, NotificationChain msgs) {
		Recent oldRecent = recent;
		recent = newRecent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MarketplacePackage.MARKETPLACE__RECENT, oldRecent, newRecent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecent(Recent newRecent) {
		if (newRecent != recent) {
			NotificationChain msgs = null;
			if (recent != null)
				msgs = ((InternalEObject)recent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.MARKETPLACE__RECENT, null, msgs);
			if (newRecent != null)
				msgs = ((InternalEObject)newRecent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.MARKETPLACE__RECENT, null, msgs);
			msgs = basicSetRecent(newRecent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.MARKETPLACE__RECENT, newRecent, newRecent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MarketplacePackage.MARKETPLACE__NODE:
				return basicSetNode(null, msgs);
			case MarketplacePackage.MARKETPLACE__CATALOGS:
				return basicSetCatalogs(null, msgs);
			case MarketplacePackage.MARKETPLACE__MARKETS:
				return ((InternalEList<?>)getMarkets()).basicRemove(otherEnd, msgs);
			case MarketplacePackage.MARKETPLACE__FEATURED:
				return basicSetFeatured(null, msgs);
			case MarketplacePackage.MARKETPLACE__SEARCH:
				return basicSetSearch(null, msgs);
			case MarketplacePackage.MARKETPLACE__RECENT:
				return basicSetRecent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MarketplacePackage.MARKETPLACE__NODE:
				return getNode();
			case MarketplacePackage.MARKETPLACE__CATALOGS:
				return getCatalogs();
			case MarketplacePackage.MARKETPLACE__MARKETS:
				return getMarkets();
			case MarketplacePackage.MARKETPLACE__FEATURED:
				return getFeatured();
			case MarketplacePackage.MARKETPLACE__BASE_URL:
				return getBaseUrl();
			case MarketplacePackage.MARKETPLACE__SEARCH:
				return getSearch();
			case MarketplacePackage.MARKETPLACE__RECENT:
				return getRecent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MarketplacePackage.MARKETPLACE__NODE:
				setNode((Node)newValue);
				return;
			case MarketplacePackage.MARKETPLACE__CATALOGS:
				setCatalogs((Catalogs)newValue);
				return;
			case MarketplacePackage.MARKETPLACE__MARKETS:
				getMarkets().clear();
				getMarkets().addAll((Collection<? extends Market>)newValue);
				return;
			case MarketplacePackage.MARKETPLACE__FEATURED:
				setFeatured((Featured)newValue);
				return;
			case MarketplacePackage.MARKETPLACE__BASE_URL:
				setBaseUrl((String)newValue);
				return;
			case MarketplacePackage.MARKETPLACE__SEARCH:
				setSearch((Search)newValue);
				return;
			case MarketplacePackage.MARKETPLACE__RECENT:
				setRecent((Recent)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MarketplacePackage.MARKETPLACE__NODE:
				setNode((Node)null);
				return;
			case MarketplacePackage.MARKETPLACE__CATALOGS:
				setCatalogs((Catalogs)null);
				return;
			case MarketplacePackage.MARKETPLACE__MARKETS:
				getMarkets().clear();
				return;
			case MarketplacePackage.MARKETPLACE__FEATURED:
				setFeatured((Featured)null);
				return;
			case MarketplacePackage.MARKETPLACE__BASE_URL:
				setBaseUrl(BASE_URL_EDEFAULT);
				return;
			case MarketplacePackage.MARKETPLACE__SEARCH:
				setSearch((Search)null);
				return;
			case MarketplacePackage.MARKETPLACE__RECENT:
				setRecent((Recent)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MarketplacePackage.MARKETPLACE__NODE:
				return node != null;
			case MarketplacePackage.MARKETPLACE__CATALOGS:
				return catalogs != null;
			case MarketplacePackage.MARKETPLACE__MARKETS:
				return markets != null && !markets.isEmpty();
			case MarketplacePackage.MARKETPLACE__FEATURED:
				return featured != null;
			case MarketplacePackage.MARKETPLACE__BASE_URL:
				return BASE_URL_EDEFAULT == null ? baseUrl != null : !BASE_URL_EDEFAULT.equals(baseUrl);
			case MarketplacePackage.MARKETPLACE__SEARCH:
				return search != null;
			case MarketplacePackage.MARKETPLACE__RECENT:
				return recent != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (baseUrl: ");
		result.append(baseUrl);
		result.append(')');
		return result.toString();
	}

} //MarketplaceImpl
