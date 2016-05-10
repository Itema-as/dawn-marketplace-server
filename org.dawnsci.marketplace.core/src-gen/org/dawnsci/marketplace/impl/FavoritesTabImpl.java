/**
 */
package org.dawnsci.marketplace.impl;

import org.dawnsci.marketplace.FavoritesTab;
import org.dawnsci.marketplace.MarketplacePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Favorites Tab</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dawnsci.marketplace.impl.FavoritesTabImpl#getEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.FavoritesTabImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.FavoritesTabImpl#getApiserver <em>Apiserver</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FavoritesTabImpl extends MinimalEObjectImpl.Container implements FavoritesTab {
	/**
	 * The default value of the '{@link #getEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final Integer ENABLED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnabled()
	 * @generated
	 * @ordered
	 */
	protected Integer enabled = ENABLED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The default value of the '{@link #getApiserver() <em>Apiserver</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApiserver()
	 * @generated
	 * @ordered
	 */
	protected static final String APISERVER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getApiserver() <em>Apiserver</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApiserver()
	 * @generated
	 * @ordered
	 */
	protected String apiserver = APISERVER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FavoritesTabImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MarketplacePackage.Literals.FAVORITES_TAB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getEnabled() {
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabled(Integer newEnabled) {
		Integer oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.FAVORITES_TAB__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, MarketplacePackage.FAVORITES_TAB__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getApiserver() {
		return apiserver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApiserver(String newApiserver) {
		String oldApiserver = apiserver;
		apiserver = newApiserver;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.FAVORITES_TAB__APISERVER, oldApiserver, apiserver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MarketplacePackage.FAVORITES_TAB__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
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
			case MarketplacePackage.FAVORITES_TAB__ENABLED:
				return getEnabled();
			case MarketplacePackage.FAVORITES_TAB__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case MarketplacePackage.FAVORITES_TAB__APISERVER:
				return getApiserver();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MarketplacePackage.FAVORITES_TAB__ENABLED:
				setEnabled((Integer)newValue);
				return;
			case MarketplacePackage.FAVORITES_TAB__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case MarketplacePackage.FAVORITES_TAB__APISERVER:
				setApiserver((String)newValue);
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
			case MarketplacePackage.FAVORITES_TAB__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case MarketplacePackage.FAVORITES_TAB__MIXED:
				getMixed().clear();
				return;
			case MarketplacePackage.FAVORITES_TAB__APISERVER:
				setApiserver(APISERVER_EDEFAULT);
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
			case MarketplacePackage.FAVORITES_TAB__ENABLED:
				return ENABLED_EDEFAULT == null ? enabled != null : !ENABLED_EDEFAULT.equals(enabled);
			case MarketplacePackage.FAVORITES_TAB__MIXED:
				return mixed != null && !mixed.isEmpty();
			case MarketplacePackage.FAVORITES_TAB__APISERVER:
				return APISERVER_EDEFAULT == null ? apiserver != null : !APISERVER_EDEFAULT.equals(apiserver);
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
		result.append(" (enabled: ");
		result.append(enabled);
		result.append(", mixed: ");
		result.append(mixed);
		result.append(", apiserver: ");
		result.append(apiserver);
		result.append(')');
		return result.toString();
	}

} //FavoritesTabImpl
