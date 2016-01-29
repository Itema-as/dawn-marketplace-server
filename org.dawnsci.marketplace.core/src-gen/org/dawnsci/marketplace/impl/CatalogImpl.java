/**
 */
package org.dawnsci.marketplace.impl;

import org.dawnsci.marketplace.Catalog;
import org.dawnsci.marketplace.MarketplacePackage;
import org.dawnsci.marketplace.Wizard;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Catalog</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dawnsci.marketplace.impl.CatalogImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.CatalogImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.CatalogImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.CatalogImpl#getSelfContained <em>Self Contained</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.CatalogImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.CatalogImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.CatalogImpl#getDependenciesRepository <em>Dependencies Repository</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.CatalogImpl#getWizard <em>Wizard</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CatalogImpl extends MinimalEObjectImpl.Container implements Catalog {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final Long ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected Long id = ID_EDEFAULT;

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
	 * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected String url = URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getSelfContained() <em>Self Contained</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelfContained()
	 * @generated
	 * @ordered
	 */
	protected static final String SELF_CONTAINED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSelfContained() <em>Self Contained</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelfContained()
	 * @generated
	 * @ordered
	 */
	protected String selfContained = SELF_CONTAINED_EDEFAULT;

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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDependenciesRepository() <em>Dependencies Repository</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependenciesRepository()
	 * @generated
	 * @ordered
	 */
	protected static final String DEPENDENCIES_REPOSITORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDependenciesRepository() <em>Dependencies Repository</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependenciesRepository()
	 * @generated
	 * @ordered
	 */
	protected String dependenciesRepository = DEPENDENCIES_REPOSITORY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWizard() <em>Wizard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWizard()
	 * @generated
	 * @ordered
	 */
	protected Wizard wizard;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CatalogImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MarketplacePackage.Literals.CATALOG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(Long newId) {
		Long oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.CATALOG__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.CATALOG__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrl(String newUrl) {
		String oldUrl = url;
		url = newUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.CATALOG__URL, oldUrl, url));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSelfContained() {
		return selfContained;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelfContained(String newSelfContained) {
		String oldSelfContained = selfContained;
		selfContained = newSelfContained;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.CATALOG__SELF_CONTAINED, oldSelfContained, selfContained));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.CATALOG__ICON, oldIcon, icon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.CATALOG__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDependenciesRepository() {
		return dependenciesRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependenciesRepository(String newDependenciesRepository) {
		String oldDependenciesRepository = dependenciesRepository;
		dependenciesRepository = newDependenciesRepository;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.CATALOG__DEPENDENCIES_REPOSITORY, oldDependenciesRepository, dependenciesRepository));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Wizard getWizard() {
		return wizard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWizard(Wizard newWizard, NotificationChain msgs) {
		Wizard oldWizard = wizard;
		wizard = newWizard;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MarketplacePackage.CATALOG__WIZARD, oldWizard, newWizard);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWizard(Wizard newWizard) {
		if (newWizard != wizard) {
			NotificationChain msgs = null;
			if (wizard != null)
				msgs = ((InternalEObject)wizard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.CATALOG__WIZARD, null, msgs);
			if (newWizard != null)
				msgs = ((InternalEObject)newWizard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.CATALOG__WIZARD, null, msgs);
			msgs = basicSetWizard(newWizard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.CATALOG__WIZARD, newWizard, newWizard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MarketplacePackage.CATALOG__WIZARD:
				return basicSetWizard(null, msgs);
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
			case MarketplacePackage.CATALOG__ID:
				return getId();
			case MarketplacePackage.CATALOG__TITLE:
				return getTitle();
			case MarketplacePackage.CATALOG__URL:
				return getUrl();
			case MarketplacePackage.CATALOG__SELF_CONTAINED:
				return getSelfContained();
			case MarketplacePackage.CATALOG__ICON:
				return getIcon();
			case MarketplacePackage.CATALOG__DESCRIPTION:
				return getDescription();
			case MarketplacePackage.CATALOG__DEPENDENCIES_REPOSITORY:
				return getDependenciesRepository();
			case MarketplacePackage.CATALOG__WIZARD:
				return getWizard();
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
			case MarketplacePackage.CATALOG__ID:
				setId((Long)newValue);
				return;
			case MarketplacePackage.CATALOG__TITLE:
				setTitle((String)newValue);
				return;
			case MarketplacePackage.CATALOG__URL:
				setUrl((String)newValue);
				return;
			case MarketplacePackage.CATALOG__SELF_CONTAINED:
				setSelfContained((String)newValue);
				return;
			case MarketplacePackage.CATALOG__ICON:
				setIcon((String)newValue);
				return;
			case MarketplacePackage.CATALOG__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case MarketplacePackage.CATALOG__DEPENDENCIES_REPOSITORY:
				setDependenciesRepository((String)newValue);
				return;
			case MarketplacePackage.CATALOG__WIZARD:
				setWizard((Wizard)newValue);
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
			case MarketplacePackage.CATALOG__ID:
				setId(ID_EDEFAULT);
				return;
			case MarketplacePackage.CATALOG__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case MarketplacePackage.CATALOG__URL:
				setUrl(URL_EDEFAULT);
				return;
			case MarketplacePackage.CATALOG__SELF_CONTAINED:
				setSelfContained(SELF_CONTAINED_EDEFAULT);
				return;
			case MarketplacePackage.CATALOG__ICON:
				setIcon(ICON_EDEFAULT);
				return;
			case MarketplacePackage.CATALOG__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case MarketplacePackage.CATALOG__DEPENDENCIES_REPOSITORY:
				setDependenciesRepository(DEPENDENCIES_REPOSITORY_EDEFAULT);
				return;
			case MarketplacePackage.CATALOG__WIZARD:
				setWizard((Wizard)null);
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
			case MarketplacePackage.CATALOG__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case MarketplacePackage.CATALOG__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case MarketplacePackage.CATALOG__URL:
				return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
			case MarketplacePackage.CATALOG__SELF_CONTAINED:
				return SELF_CONTAINED_EDEFAULT == null ? selfContained != null : !SELF_CONTAINED_EDEFAULT.equals(selfContained);
			case MarketplacePackage.CATALOG__ICON:
				return ICON_EDEFAULT == null ? icon != null : !ICON_EDEFAULT.equals(icon);
			case MarketplacePackage.CATALOG__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case MarketplacePackage.CATALOG__DEPENDENCIES_REPOSITORY:
				return DEPENDENCIES_REPOSITORY_EDEFAULT == null ? dependenciesRepository != null : !DEPENDENCIES_REPOSITORY_EDEFAULT.equals(dependenciesRepository);
			case MarketplacePackage.CATALOG__WIZARD:
				return wizard != null;
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
		result.append(" (id: ");
		result.append(id);
		result.append(", title: ");
		result.append(title);
		result.append(", url: ");
		result.append(url);
		result.append(", selfContained: ");
		result.append(selfContained);
		result.append(", icon: ");
		result.append(icon);
		result.append(", description: ");
		result.append(description);
		result.append(", dependenciesRepository: ");
		result.append(dependenciesRepository);
		result.append(')');
		return result.toString();
	}

} //CatalogImpl
