/**
 */
package org.dawnsci.marketplace.impl;

import org.dawnsci.marketplace.MarketplacePackage;
import org.dawnsci.marketplace.News;
import org.dawnsci.marketplace.PopularTab;
import org.dawnsci.marketplace.RecentTab;
import org.dawnsci.marketplace.SearchTab;
import org.dawnsci.marketplace.Wizard;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Wizard</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dawnsci.marketplace.impl.WizardImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.WizardImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.WizardImpl#getSearchtab <em>Searchtab</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.WizardImpl#getPopulartab <em>Populartab</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.WizardImpl#getRecenttab <em>Recenttab</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.WizardImpl#getNews <em>News</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WizardImpl extends MinimalEObjectImpl.Container implements Wizard {
	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected String icon = ICON_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSearchtab() <em>Searchtab</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSearchtab()
	 * @generated
	 * @ordered
	 */
	protected SearchTab searchtab;

	/**
	 * The cached value of the '{@link #getPopulartab() <em>Populartab</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPopulartab()
	 * @generated
	 * @ordered
	 */
	protected PopularTab populartab;

	/**
	 * The cached value of the '{@link #getRecenttab() <em>Recenttab</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecenttab()
	 * @generated
	 * @ordered
	 */
	protected RecentTab recenttab;

	/**
	 * The cached value of the '{@link #getNews() <em>News</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNews()
	 * @generated
	 * @ordered
	 */
	protected News news;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WizardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MarketplacePackage.Literals.WIZARD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.WIZARD__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcon(String newIcon) {
		String oldIcon = icon;
		icon = newIcon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.WIZARD__ICON, oldIcon, icon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchTab getSearchtab() {
		return searchtab;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSearchtab(SearchTab newSearchtab, NotificationChain msgs) {
		SearchTab oldSearchtab = searchtab;
		searchtab = newSearchtab;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MarketplacePackage.WIZARD__SEARCHTAB, oldSearchtab, newSearchtab);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSearchtab(SearchTab newSearchtab) {
		if (newSearchtab != searchtab) {
			NotificationChain msgs = null;
			if (searchtab != null)
				msgs = ((InternalEObject)searchtab).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.WIZARD__SEARCHTAB, null, msgs);
			if (newSearchtab != null)
				msgs = ((InternalEObject)newSearchtab).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.WIZARD__SEARCHTAB, null, msgs);
			msgs = basicSetSearchtab(newSearchtab, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.WIZARD__SEARCHTAB, newSearchtab, newSearchtab));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PopularTab getPopulartab() {
		return populartab;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPopulartab(PopularTab newPopulartab, NotificationChain msgs) {
		PopularTab oldPopulartab = populartab;
		populartab = newPopulartab;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MarketplacePackage.WIZARD__POPULARTAB, oldPopulartab, newPopulartab);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPopulartab(PopularTab newPopulartab) {
		if (newPopulartab != populartab) {
			NotificationChain msgs = null;
			if (populartab != null)
				msgs = ((InternalEObject)populartab).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.WIZARD__POPULARTAB, null, msgs);
			if (newPopulartab != null)
				msgs = ((InternalEObject)newPopulartab).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.WIZARD__POPULARTAB, null, msgs);
			msgs = basicSetPopulartab(newPopulartab, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.WIZARD__POPULARTAB, newPopulartab, newPopulartab));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecentTab getRecenttab() {
		return recenttab;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRecenttab(RecentTab newRecenttab, NotificationChain msgs) {
		RecentTab oldRecenttab = recenttab;
		recenttab = newRecenttab;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MarketplacePackage.WIZARD__RECENTTAB, oldRecenttab, newRecenttab);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecenttab(RecentTab newRecenttab) {
		if (newRecenttab != recenttab) {
			NotificationChain msgs = null;
			if (recenttab != null)
				msgs = ((InternalEObject)recenttab).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.WIZARD__RECENTTAB, null, msgs);
			if (newRecenttab != null)
				msgs = ((InternalEObject)newRecenttab).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.WIZARD__RECENTTAB, null, msgs);
			msgs = basicSetRecenttab(newRecenttab, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.WIZARD__RECENTTAB, newRecenttab, newRecenttab));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public News getNews() {
		return news;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNews(News newNews, NotificationChain msgs) {
		News oldNews = news;
		news = newNews;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MarketplacePackage.WIZARD__NEWS, oldNews, newNews);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNews(News newNews) {
		if (newNews != news) {
			NotificationChain msgs = null;
			if (news != null)
				msgs = ((InternalEObject)news).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.WIZARD__NEWS, null, msgs);
			if (newNews != null)
				msgs = ((InternalEObject)newNews).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.WIZARD__NEWS, null, msgs);
			msgs = basicSetNews(newNews, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.WIZARD__NEWS, newNews, newNews));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MarketplacePackage.WIZARD__SEARCHTAB:
				return basicSetSearchtab(null, msgs);
			case MarketplacePackage.WIZARD__POPULARTAB:
				return basicSetPopulartab(null, msgs);
			case MarketplacePackage.WIZARD__RECENTTAB:
				return basicSetRecenttab(null, msgs);
			case MarketplacePackage.WIZARD__NEWS:
				return basicSetNews(null, msgs);
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
			case MarketplacePackage.WIZARD__TITLE:
				return getTitle();
			case MarketplacePackage.WIZARD__ICON:
				return getIcon();
			case MarketplacePackage.WIZARD__SEARCHTAB:
				return getSearchtab();
			case MarketplacePackage.WIZARD__POPULARTAB:
				return getPopulartab();
			case MarketplacePackage.WIZARD__RECENTTAB:
				return getRecenttab();
			case MarketplacePackage.WIZARD__NEWS:
				return getNews();
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
			case MarketplacePackage.WIZARD__TITLE:
				setTitle((String)newValue);
				return;
			case MarketplacePackage.WIZARD__ICON:
				setIcon((String)newValue);
				return;
			case MarketplacePackage.WIZARD__SEARCHTAB:
				setSearchtab((SearchTab)newValue);
				return;
			case MarketplacePackage.WIZARD__POPULARTAB:
				setPopulartab((PopularTab)newValue);
				return;
			case MarketplacePackage.WIZARD__RECENTTAB:
				setRecenttab((RecentTab)newValue);
				return;
			case MarketplacePackage.WIZARD__NEWS:
				setNews((News)newValue);
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
			case MarketplacePackage.WIZARD__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case MarketplacePackage.WIZARD__ICON:
				setIcon(ICON_EDEFAULT);
				return;
			case MarketplacePackage.WIZARD__SEARCHTAB:
				setSearchtab((SearchTab)null);
				return;
			case MarketplacePackage.WIZARD__POPULARTAB:
				setPopulartab((PopularTab)null);
				return;
			case MarketplacePackage.WIZARD__RECENTTAB:
				setRecenttab((RecentTab)null);
				return;
			case MarketplacePackage.WIZARD__NEWS:
				setNews((News)null);
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
			case MarketplacePackage.WIZARD__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case MarketplacePackage.WIZARD__ICON:
				return ICON_EDEFAULT == null ? icon != null : !ICON_EDEFAULT.equals(icon);
			case MarketplacePackage.WIZARD__SEARCHTAB:
				return searchtab != null;
			case MarketplacePackage.WIZARD__POPULARTAB:
				return populartab != null;
			case MarketplacePackage.WIZARD__RECENTTAB:
				return recenttab != null;
			case MarketplacePackage.WIZARD__NEWS:
				return news != null;
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
		result.append(" (title: ");
		result.append(title);
		result.append(", icon: ");
		result.append(icon);
		result.append(')');
		return result.toString();
	}

} //WizardImpl
