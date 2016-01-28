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
 *   <li>{@link org.dawnsci.marketplace.impl.MarketplaceImpl#getMarket <em>Market</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.MarketplaceImpl#getFeatured <em>Featured</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MarketplaceImpl extends MinimalEObjectImpl.Container implements Marketplace {
	/**
	 * The cached value of the '{@link #getNode() <em>Node</em>}' reference.
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
	 * The cached value of the '{@link #getMarket() <em>Market</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMarket()
	 * @generated
	 * @ordered
	 */
	protected EList<Market> market;

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
		if (node != null && node.eIsProxy()) {
			InternalEObject oldNode = (InternalEObject)node;
			node = (Node)eResolveProxy(oldNode);
			if (node != oldNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MarketplacePackage.MARKETPLACE__NODE, oldNode, node));
			}
		}
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetNode() {
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode(Node newNode) {
		Node oldNode = node;
		node = newNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.MARKETPLACE__NODE, oldNode, node));
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
	public EList<Market> getMarket() {
		if (market == null) {
			market = new EObjectContainmentEList<Market>(Market.class, this, MarketplacePackage.MARKETPLACE__MARKET);
		}
		return market;
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
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MarketplacePackage.MARKETPLACE__CATALOGS:
				return basicSetCatalogs(null, msgs);
			case MarketplacePackage.MARKETPLACE__MARKET:
				return ((InternalEList<?>)getMarket()).basicRemove(otherEnd, msgs);
			case MarketplacePackage.MARKETPLACE__FEATURED:
				return basicSetFeatured(null, msgs);
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
				if (resolve) return getNode();
				return basicGetNode();
			case MarketplacePackage.MARKETPLACE__CATALOGS:
				return getCatalogs();
			case MarketplacePackage.MARKETPLACE__MARKET:
				return getMarket();
			case MarketplacePackage.MARKETPLACE__FEATURED:
				return getFeatured();
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
			case MarketplacePackage.MARKETPLACE__MARKET:
				getMarket().clear();
				getMarket().addAll((Collection<? extends Market>)newValue);
				return;
			case MarketplacePackage.MARKETPLACE__FEATURED:
				setFeatured((Featured)newValue);
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
			case MarketplacePackage.MARKETPLACE__MARKET:
				getMarket().clear();
				return;
			case MarketplacePackage.MARKETPLACE__FEATURED:
				setFeatured((Featured)null);
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
			case MarketplacePackage.MARKETPLACE__MARKET:
				return market != null && !market.isEmpty();
			case MarketplacePackage.MARKETPLACE__FEATURED:
				return featured != null;
		}
		return super.eIsSet(featureID);
	}

} //MarketplaceImpl
