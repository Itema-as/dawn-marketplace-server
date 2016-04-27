/**
 */
package org.dawnsci.marketplace.impl;

import javax.xml.bind.annotation.XmlRootElement;

import org.dawnsci.marketplace.Categories;
import org.dawnsci.marketplace.Ius;
import org.dawnsci.marketplace.Marketplace;
import org.dawnsci.marketplace.MarketplacePackage;
import org.dawnsci.marketplace.Node;
import org.dawnsci.marketplace.Platforms;
import org.dawnsci.marketplace.Tags;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Node</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getCategories <em>Categories</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getFavorited <em>Favorited</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getInstallstotal <em>Installstotal</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getInstallsrecent <em>Installsrecent</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getShortdescription <em>Shortdescription</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getCreated <em>Created</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getChanged <em>Changed</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getFoundationmember <em>Foundationmember</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getHomepageurl <em>Homepageurl</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getImage <em>Image</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getLicense <em>License</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getCompanyname <em>Companyname</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getSupporturl <em>Supporturl</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getEclipseversion <em>Eclipseversion</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getUpdateurl <em>Updateurl</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getIus <em>Ius</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getPlatforms <em>Platforms</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getScreenshot <em>Screenshot</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.impl.NodeImpl#getRawBody <em>Raw Body</em>}</li>
 * </ul>
 *
 * @generated
 */
@XmlRootElement(name = "Node")
public class NodeImpl extends MinimalEObjectImpl.Container implements Node {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final Long ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected Long id = ID_EDEFAULT;
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getCategories() <em>Categories</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCategories()
	 * @generated
	 * @ordered
	 */
	protected Categories categories;
	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected Tags tags;
	/**
	 * The default value of the '{@link #getOwner() <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected static final String OWNER_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected String owner = OWNER_EDEFAULT;
	/**
	 * The default value of the '{@link #getFavorited() <em>Favorited</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFavorited()
	 * @generated
	 * @ordered
	 */
	protected static final Integer FAVORITED_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getFavorited() <em>Favorited</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFavorited()
	 * @generated
	 * @ordered
	 */
	protected Integer favorited = FAVORITED_EDEFAULT;
	/**
	 * The default value of the '{@link #getInstallstotal() <em>Installstotal</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getInstallstotal()
	 * @generated
	 * @ordered
	 */
	protected static final Integer INSTALLSTOTAL_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getInstallstotal() <em>Installstotal</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getInstallstotal()
	 * @generated
	 * @ordered
	 */
	protected Integer installstotal = INSTALLSTOTAL_EDEFAULT;
	/**
	 * The default value of the '{@link #getInstallsrecent() <em>Installsrecent</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getInstallsrecent()
	 * @generated
	 * @ordered
	 */
	protected static final Integer INSTALLSRECENT_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getInstallsrecent() <em>Installsrecent</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getInstallsrecent()
	 * @generated
	 * @ordered
	 */
	protected Integer installsrecent = INSTALLSRECENT_EDEFAULT;
	/**
	 * The default value of the '{@link #getShortdescription() <em>Shortdescription</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getShortdescription()
	 * @generated
	 * @ordered
	 */
	protected static final String SHORTDESCRIPTION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getShortdescription() <em>Shortdescription</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getShortdescription()
	 * @generated
	 * @ordered
	 */
	protected String shortdescription = SHORTDESCRIPTION_EDEFAULT;
	/**
	 * The default value of the '{@link #getBody() <em>Body</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected static final String BODY_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected String body = BODY_EDEFAULT;
	/**
	 * The default value of the '{@link #getCreated() <em>Created</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCreated()
	 * @generated
	 * @ordered
	 */
	protected static final Long CREATED_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getCreated() <em>Created</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCreated()
	 * @generated
	 * @ordered
	 */
	protected Long created = CREATED_EDEFAULT;
	/**
	 * The default value of the '{@link #getChanged() <em>Changed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getChanged()
	 * @generated
	 * @ordered
	 */
	protected static final Long CHANGED_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getChanged() <em>Changed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getChanged()
	 * @generated
	 * @ordered
	 */
	protected Long changed = CHANGED_EDEFAULT;
	/**
	 * The default value of the '{@link #getFoundationmember() <em>Foundationmember</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getFoundationmember()
	 * @generated
	 * @ordered
	 */
	protected static final Integer FOUNDATIONMEMBER_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getFoundationmember() <em>Foundationmember</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getFoundationmember()
	 * @generated
	 * @ordered
	 */
	protected Integer foundationmember = FOUNDATIONMEMBER_EDEFAULT;
	/**
	 * The default value of the '{@link #getHomepageurl() <em>Homepageurl</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getHomepageurl()
	 * @generated
	 * @ordered
	 */
	protected static final String HOMEPAGEURL_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getHomepageurl() <em>Homepageurl</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getHomepageurl()
	 * @generated
	 * @ordered
	 */
	protected String homepageurl = HOMEPAGEURL_EDEFAULT;
	/**
	 * The default value of the '{@link #getImage() <em>Image</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected static final String IMAGE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getImage() <em>Image</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected String image = IMAGE_EDEFAULT;
	/**
	 * The default value of the '{@link #getLicense() <em>License</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLicense()
	 * @generated
	 * @ordered
	 */
	protected static final String LICENSE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getLicense() <em>License</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLicense()
	 * @generated
	 * @ordered
	 */
	protected String license = LICENSE_EDEFAULT;
	/**
	 * The default value of the '{@link #getCompanyname() <em>Companyname</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCompanyname()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPANYNAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getCompanyname() <em>Companyname</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCompanyname()
	 * @generated
	 * @ordered
	 */
	protected String companyname = COMPANYNAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final String STATUS_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected String status = STATUS_EDEFAULT;
	/**
	 * The default value of the '{@link #getSupporturl() <em>Supporturl</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSupporturl()
	 * @generated
	 * @ordered
	 */
	protected static final String SUPPORTURL_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSupporturl() <em>Supporturl</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSupporturl()
	 * @generated
	 * @ordered
	 */
	protected String supporturl = SUPPORTURL_EDEFAULT;
	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;
	/**
	 * The default value of the '{@link #getEclipseversion() <em>Eclipseversion</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getEclipseversion()
	 * @generated
	 * @ordered
	 */
	protected static final String ECLIPSEVERSION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getEclipseversion() <em>Eclipseversion</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getEclipseversion()
	 * @generated
	 * @ordered
	 */
	protected String eclipseversion = ECLIPSEVERSION_EDEFAULT;
	/**
	 * The default value of the '{@link #getUpdateurl() <em>Updateurl</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUpdateurl()
	 * @generated
	 * @ordered
	 */
	protected static final String UPDATEURL_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getUpdateurl() <em>Updateurl</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUpdateurl()
	 * @generated
	 * @ordered
	 */
	protected String updateurl = UPDATEURL_EDEFAULT;
	/**
	 * The cached value of the '{@link #getIus() <em>Ius</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIus()
	 * @generated
	 * @ordered
	 */
	protected Ius ius;
	/**
	 * The cached value of the '{@link #getPlatforms() <em>Platforms</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPlatforms()
	 * @generated
	 * @ordered
	 */
	protected Platforms platforms;
	/**
	 * The default value of the '{@link #getUrl() <em>Url</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String URL_EDEFAULT = "";
	/**
	 * The default value of the '{@link #getScreenshot() <em>Screenshot</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getScreenshot()
	 * @generated
	 * @ordered
	 */
	protected static final String SCREENSHOT_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getScreenshot() <em>Screenshot</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getScreenshot()
	 * @generated
	 * @ordered
	 */
	protected String screenshot = SCREENSHOT_EDEFAULT;

	/**
	 * The default value of the '{@link #getRawBody() <em>Raw Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawBody()
	 * @generated
	 * @ordered
	 */
	protected static final String RAW_BODY_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getRawBody() <em>Raw Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawBody()
	 * @generated
	 * @ordered
	 */
	protected String rawBody = RAW_BODY_EDEFAULT;
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MarketplacePackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getFavorited() {
		return favorited;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFavorited(Integer newFavorited) {
		Integer oldFavorited = favorited;
		favorited = newFavorited;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__FAVORITED, oldFavorited, favorited));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getInstallstotal() {
		return installstotal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstallstotal(Integer newInstallstotal) {
		Integer oldInstallstotal = installstotal;
		installstotal = newInstallstotal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__INSTALLSTOTAL, oldInstallstotal, installstotal));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getInstallsrecent() {
		return installsrecent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstallsrecent(Integer newInstallsrecent) {
		Integer oldInstallsrecent = installsrecent;
		installsrecent = newInstallsrecent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__INSTALLSRECENT, oldInstallsrecent, installsrecent));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getShortdescription() {
		return shortdescription;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setShortdescription(String newShortdescription) {
		String oldShortdescription = shortdescription;
		shortdescription = newShortdescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__SHORTDESCRIPTION, oldShortdescription, shortdescription));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(String newBody) {
		String oldBody = body;
		body = newBody;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__BODY, oldBody, body));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Long getCreated() {
		return created;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreated(Long newCreated) {
		Long oldCreated = created;
		created = newCreated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__CREATED, oldCreated, created));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Long getChanged() {
		return changed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChanged(Long newChanged) {
		Long oldChanged = changed;
		changed = newChanged;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__CHANGED, oldChanged, changed));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getFoundationmember() {
		return foundationmember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFoundationmember(Integer newFoundationmember) {
		Integer oldFoundationmember = foundationmember;
		foundationmember = newFoundationmember;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__FOUNDATIONMEMBER, oldFoundationmember, foundationmember));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getHomepageurl() {
		return homepageurl;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHomepageurl(String newHomepageurl) {
		String oldHomepageurl = homepageurl;
		homepageurl = newHomepageurl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__HOMEPAGEURL, oldHomepageurl, homepageurl));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated Not
	 */
	public String getImage() {
		if (image == null || image.isEmpty()) {
			return null;
		}
		if (getBaseUrl() == null) {
			return image;
		}
		return getBaseUrl()+"/files/" + getId() + "/" + image;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setImage(String newImage) {
		String oldImage = image;
		image = newImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__IMAGE, oldImage, image));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLicense(String newLicense) {
		String oldLicense = license;
		license = newLicense;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__LICENSE, oldLicense, license));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCompanyname() {
		return companyname;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompanyname(String newCompanyname) {
		String oldCompanyname = companyname;
		companyname = newCompanyname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__COMPANYNAME, oldCompanyname, companyname));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(String newStatus) {
		String oldStatus = status;
		status = newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSupporturl() {
		return supporturl;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupporturl(String newSupporturl) {
		String oldSupporturl = supporturl;
		supporturl = newSupporturl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__SUPPORTURL, oldSupporturl, supporturl));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getEclipseversion() {
		return eclipseversion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEclipseversion(String newEclipseversion) {
		String oldEclipseversion = eclipseversion;
		eclipseversion = newEclipseversion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__ECLIPSEVERSION, oldEclipseversion, eclipseversion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated Not
	 */
	public String getUpdateurl() {
		if (getBaseUrl() == null) {
			return updateurl;
		}
		return getBaseUrl()+"/files/" + getId() + "/" + updateurl;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpdateurl(String newUpdateurl) {
		String oldUpdateurl = updateurl;
		updateurl = newUpdateurl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__UPDATEURL, oldUpdateurl, updateurl));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Ius getIus() {
		return ius;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIus(Ius newIus, NotificationChain msgs) {
		Ius oldIus = ius;
		ius = newIus;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__IUS, oldIus, newIus);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIus(Ius newIus) {
		if (newIus != ius) {
			NotificationChain msgs = null;
			if (ius != null)
				msgs = ((InternalEObject)ius).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.NODE__IUS, null, msgs);
			if (newIus != null)
				msgs = ((InternalEObject)newIus).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.NODE__IUS, null, msgs);
			msgs = basicSetIus(newIus, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__IUS, newIus, newIus));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Platforms getPlatforms() {
		return platforms;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlatforms(Platforms newPlatforms, NotificationChain msgs) {
		Platforms oldPlatforms = platforms;
		platforms = newPlatforms;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__PLATFORMS, oldPlatforms, newPlatforms);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlatforms(Platforms newPlatforms) {
		if (newPlatforms != platforms) {
			NotificationChain msgs = null;
			if (platforms != null)
				msgs = ((InternalEObject)platforms).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.NODE__PLATFORMS, null, msgs);
			if (newPlatforms != null)
				msgs = ((InternalEObject)newPlatforms).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.NODE__PLATFORMS, null, msgs);
			msgs = basicSetPlatforms(newPlatforms, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__PLATFORMS, newPlatforms, newPlatforms));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated Not
	 */
	public String getUrl() {
		if (getBaseUrl() == null) {
			return "";
		}
		return getBaseUrl() + "/" + getId();
	}

	/**
	 * Used to calculate the base URL of URL's relative to the marketplace 
	 * server. This can only be found if this instance is contained within an
	 * object which root container is a Marketplace instance.
	 *  
	 * @return the base URL or <code>null</code>
	 */
	private String getBaseUrl() {
		EObject rootContainer = EcoreUtil.getRootContainer(this);
		if (rootContainer != null && rootContainer instanceof Marketplace) {
			String baseUrl = ((Marketplace) rootContainer).getBaseUrl();
			if (baseUrl != null) {
				return baseUrl;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated Not
	 */
	public void setUrl(String newUrl) {
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated Not
	 */
	public String getScreenshot() {
		if (screenshot == null || screenshot.isEmpty()) {
			return null;
		}
		if (getBaseUrl() == null) {
			return screenshot;
		}
		return getBaseUrl()+"/files/" + getId() + "/" + screenshot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setScreenshot(String newScreenshot) {
		String oldScreenshot = screenshot;
		screenshot = newScreenshot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__SCREENSHOT, oldScreenshot, screenshot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRawBody() {
		return rawBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRawBody(String newRawBody) {
		String oldRawBody = rawBody;
		rawBody = newRawBody;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__RAW_BODY, oldRawBody, rawBody));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MarketplacePackage.NODE__CATEGORIES:
				return basicSetCategories(null, msgs);
			case MarketplacePackage.NODE__TAGS:
				return basicSetTags(null, msgs);
			case MarketplacePackage.NODE__IUS:
				return basicSetIus(null, msgs);
			case MarketplacePackage.NODE__PLATFORMS:
				return basicSetPlatforms(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Categories getCategories() {
		return categories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCategories(Categories newCategories, NotificationChain msgs) {
		Categories oldCategories = categories;
		categories = newCategories;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__CATEGORIES, oldCategories, newCategories);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCategories(Categories newCategories) {
		if (newCategories != categories) {
			NotificationChain msgs = null;
			if (categories != null)
				msgs = ((InternalEObject)categories).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.NODE__CATEGORIES, null, msgs);
			if (newCategories != null)
				msgs = ((InternalEObject)newCategories).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.NODE__CATEGORIES, null, msgs);
			msgs = basicSetCategories(newCategories, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__CATEGORIES, newCategories, newCategories));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Tags getTags() {
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTags(Tags newTags, NotificationChain msgs) {
		Tags oldTags = tags;
		tags = newTags;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__TAGS, oldTags, newTags);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTags(Tags newTags) {
		if (newTags != tags) {
			NotificationChain msgs = null;
			if (tags != null)
				msgs = ((InternalEObject)tags).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.NODE__TAGS, null, msgs);
			if (newTags != null)
				msgs = ((InternalEObject)newTags).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MarketplacePackage.NODE__TAGS, null, msgs);
			msgs = basicSetTags(newTags, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__TAGS, newTags, newTags));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(String newOwner) {
		String oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MarketplacePackage.NODE__OWNER, oldOwner, owner));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MarketplacePackage.NODE__ID:
				return getId();
			case MarketplacePackage.NODE__NAME:
				return getName();
			case MarketplacePackage.NODE__TYPE:
				return getType();
			case MarketplacePackage.NODE__CATEGORIES:
				return getCategories();
			case MarketplacePackage.NODE__TAGS:
				return getTags();
			case MarketplacePackage.NODE__OWNER:
				return getOwner();
			case MarketplacePackage.NODE__FAVORITED:
				return getFavorited();
			case MarketplacePackage.NODE__INSTALLSTOTAL:
				return getInstallstotal();
			case MarketplacePackage.NODE__INSTALLSRECENT:
				return getInstallsrecent();
			case MarketplacePackage.NODE__SHORTDESCRIPTION:
				return getShortdescription();
			case MarketplacePackage.NODE__BODY:
				return getBody();
			case MarketplacePackage.NODE__CREATED:
				return getCreated();
			case MarketplacePackage.NODE__CHANGED:
				return getChanged();
			case MarketplacePackage.NODE__FOUNDATIONMEMBER:
				return getFoundationmember();
			case MarketplacePackage.NODE__HOMEPAGEURL:
				return getHomepageurl();
			case MarketplacePackage.NODE__IMAGE:
				return getImage();
			case MarketplacePackage.NODE__LICENSE:
				return getLicense();
			case MarketplacePackage.NODE__COMPANYNAME:
				return getCompanyname();
			case MarketplacePackage.NODE__STATUS:
				return getStatus();
			case MarketplacePackage.NODE__SUPPORTURL:
				return getSupporturl();
			case MarketplacePackage.NODE__VERSION:
				return getVersion();
			case MarketplacePackage.NODE__ECLIPSEVERSION:
				return getEclipseversion();
			case MarketplacePackage.NODE__UPDATEURL:
				return getUpdateurl();
			case MarketplacePackage.NODE__IUS:
				return getIus();
			case MarketplacePackage.NODE__PLATFORMS:
				return getPlatforms();
			case MarketplacePackage.NODE__URL:
				return getUrl();
			case MarketplacePackage.NODE__SCREENSHOT:
				return getScreenshot();
			case MarketplacePackage.NODE__RAW_BODY:
				return getRawBody();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MarketplacePackage.NODE__ID:
				setId((Long)newValue);
				return;
			case MarketplacePackage.NODE__NAME:
				setName((String)newValue);
				return;
			case MarketplacePackage.NODE__TYPE:
				setType((String)newValue);
				return;
			case MarketplacePackage.NODE__CATEGORIES:
				setCategories((Categories)newValue);
				return;
			case MarketplacePackage.NODE__TAGS:
				setTags((Tags)newValue);
				return;
			case MarketplacePackage.NODE__OWNER:
				setOwner((String)newValue);
				return;
			case MarketplacePackage.NODE__FAVORITED:
				setFavorited((Integer)newValue);
				return;
			case MarketplacePackage.NODE__INSTALLSTOTAL:
				setInstallstotal((Integer)newValue);
				return;
			case MarketplacePackage.NODE__INSTALLSRECENT:
				setInstallsrecent((Integer)newValue);
				return;
			case MarketplacePackage.NODE__SHORTDESCRIPTION:
				setShortdescription((String)newValue);
				return;
			case MarketplacePackage.NODE__BODY:
				setBody((String)newValue);
				return;
			case MarketplacePackage.NODE__CREATED:
				setCreated((Long)newValue);
				return;
			case MarketplacePackage.NODE__CHANGED:
				setChanged((Long)newValue);
				return;
			case MarketplacePackage.NODE__FOUNDATIONMEMBER:
				setFoundationmember((Integer)newValue);
				return;
			case MarketplacePackage.NODE__HOMEPAGEURL:
				setHomepageurl((String)newValue);
				return;
			case MarketplacePackage.NODE__IMAGE:
				setImage((String)newValue);
				return;
			case MarketplacePackage.NODE__LICENSE:
				setLicense((String)newValue);
				return;
			case MarketplacePackage.NODE__COMPANYNAME:
				setCompanyname((String)newValue);
				return;
			case MarketplacePackage.NODE__STATUS:
				setStatus((String)newValue);
				return;
			case MarketplacePackage.NODE__SUPPORTURL:
				setSupporturl((String)newValue);
				return;
			case MarketplacePackage.NODE__VERSION:
				setVersion((String)newValue);
				return;
			case MarketplacePackage.NODE__ECLIPSEVERSION:
				setEclipseversion((String)newValue);
				return;
			case MarketplacePackage.NODE__UPDATEURL:
				setUpdateurl((String)newValue);
				return;
			case MarketplacePackage.NODE__IUS:
				setIus((Ius)newValue);
				return;
			case MarketplacePackage.NODE__PLATFORMS:
				setPlatforms((Platforms)newValue);
				return;
			case MarketplacePackage.NODE__URL:
				setUrl((String)newValue);
				return;
			case MarketplacePackage.NODE__SCREENSHOT:
				setScreenshot((String)newValue);
				return;
			case MarketplacePackage.NODE__RAW_BODY:
				setRawBody((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MarketplacePackage.NODE__ID:
				setId(ID_EDEFAULT);
				return;
			case MarketplacePackage.NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MarketplacePackage.NODE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case MarketplacePackage.NODE__CATEGORIES:
				setCategories((Categories)null);
				return;
			case MarketplacePackage.NODE__TAGS:
				setTags((Tags)null);
				return;
			case MarketplacePackage.NODE__OWNER:
				setOwner(OWNER_EDEFAULT);
				return;
			case MarketplacePackage.NODE__FAVORITED:
				setFavorited(FAVORITED_EDEFAULT);
				return;
			case MarketplacePackage.NODE__INSTALLSTOTAL:
				setInstallstotal(INSTALLSTOTAL_EDEFAULT);
				return;
			case MarketplacePackage.NODE__INSTALLSRECENT:
				setInstallsrecent(INSTALLSRECENT_EDEFAULT);
				return;
			case MarketplacePackage.NODE__SHORTDESCRIPTION:
				setShortdescription(SHORTDESCRIPTION_EDEFAULT);
				return;
			case MarketplacePackage.NODE__BODY:
				setBody(BODY_EDEFAULT);
				return;
			case MarketplacePackage.NODE__CREATED:
				setCreated(CREATED_EDEFAULT);
				return;
			case MarketplacePackage.NODE__CHANGED:
				setChanged(CHANGED_EDEFAULT);
				return;
			case MarketplacePackage.NODE__FOUNDATIONMEMBER:
				setFoundationmember(FOUNDATIONMEMBER_EDEFAULT);
				return;
			case MarketplacePackage.NODE__HOMEPAGEURL:
				setHomepageurl(HOMEPAGEURL_EDEFAULT);
				return;
			case MarketplacePackage.NODE__IMAGE:
				setImage(IMAGE_EDEFAULT);
				return;
			case MarketplacePackage.NODE__LICENSE:
				setLicense(LICENSE_EDEFAULT);
				return;
			case MarketplacePackage.NODE__COMPANYNAME:
				setCompanyname(COMPANYNAME_EDEFAULT);
				return;
			case MarketplacePackage.NODE__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case MarketplacePackage.NODE__SUPPORTURL:
				setSupporturl(SUPPORTURL_EDEFAULT);
				return;
			case MarketplacePackage.NODE__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case MarketplacePackage.NODE__ECLIPSEVERSION:
				setEclipseversion(ECLIPSEVERSION_EDEFAULT);
				return;
			case MarketplacePackage.NODE__UPDATEURL:
				setUpdateurl(UPDATEURL_EDEFAULT);
				return;
			case MarketplacePackage.NODE__IUS:
				setIus((Ius)null);
				return;
			case MarketplacePackage.NODE__PLATFORMS:
				setPlatforms((Platforms)null);
				return;
			case MarketplacePackage.NODE__URL:
				setUrl(URL_EDEFAULT);
				return;
			case MarketplacePackage.NODE__SCREENSHOT:
				setScreenshot(SCREENSHOT_EDEFAULT);
				return;
			case MarketplacePackage.NODE__RAW_BODY:
				setRawBody(RAW_BODY_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MarketplacePackage.NODE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case MarketplacePackage.NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MarketplacePackage.NODE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case MarketplacePackage.NODE__CATEGORIES:
				return categories != null;
			case MarketplacePackage.NODE__TAGS:
				return tags != null;
			case MarketplacePackage.NODE__OWNER:
				return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
			case MarketplacePackage.NODE__FAVORITED:
				return FAVORITED_EDEFAULT == null ? favorited != null : !FAVORITED_EDEFAULT.equals(favorited);
			case MarketplacePackage.NODE__INSTALLSTOTAL:
				return INSTALLSTOTAL_EDEFAULT == null ? installstotal != null : !INSTALLSTOTAL_EDEFAULT.equals(installstotal);
			case MarketplacePackage.NODE__INSTALLSRECENT:
				return INSTALLSRECENT_EDEFAULT == null ? installsrecent != null : !INSTALLSRECENT_EDEFAULT.equals(installsrecent);
			case MarketplacePackage.NODE__SHORTDESCRIPTION:
				return SHORTDESCRIPTION_EDEFAULT == null ? shortdescription != null : !SHORTDESCRIPTION_EDEFAULT.equals(shortdescription);
			case MarketplacePackage.NODE__BODY:
				return BODY_EDEFAULT == null ? body != null : !BODY_EDEFAULT.equals(body);
			case MarketplacePackage.NODE__CREATED:
				return CREATED_EDEFAULT == null ? created != null : !CREATED_EDEFAULT.equals(created);
			case MarketplacePackage.NODE__CHANGED:
				return CHANGED_EDEFAULT == null ? changed != null : !CHANGED_EDEFAULT.equals(changed);
			case MarketplacePackage.NODE__FOUNDATIONMEMBER:
				return FOUNDATIONMEMBER_EDEFAULT == null ? foundationmember != null : !FOUNDATIONMEMBER_EDEFAULT.equals(foundationmember);
			case MarketplacePackage.NODE__HOMEPAGEURL:
				return HOMEPAGEURL_EDEFAULT == null ? homepageurl != null : !HOMEPAGEURL_EDEFAULT.equals(homepageurl);
			case MarketplacePackage.NODE__IMAGE:
				return IMAGE_EDEFAULT == null ? image != null : !IMAGE_EDEFAULT.equals(image);
			case MarketplacePackage.NODE__LICENSE:
				return LICENSE_EDEFAULT == null ? license != null : !LICENSE_EDEFAULT.equals(license);
			case MarketplacePackage.NODE__COMPANYNAME:
				return COMPANYNAME_EDEFAULT == null ? companyname != null : !COMPANYNAME_EDEFAULT.equals(companyname);
			case MarketplacePackage.NODE__STATUS:
				return STATUS_EDEFAULT == null ? status != null : !STATUS_EDEFAULT.equals(status);
			case MarketplacePackage.NODE__SUPPORTURL:
				return SUPPORTURL_EDEFAULT == null ? supporturl != null : !SUPPORTURL_EDEFAULT.equals(supporturl);
			case MarketplacePackage.NODE__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case MarketplacePackage.NODE__ECLIPSEVERSION:
				return ECLIPSEVERSION_EDEFAULT == null ? eclipseversion != null : !ECLIPSEVERSION_EDEFAULT.equals(eclipseversion);
			case MarketplacePackage.NODE__UPDATEURL:
				return UPDATEURL_EDEFAULT == null ? updateurl != null : !UPDATEURL_EDEFAULT.equals(updateurl);
			case MarketplacePackage.NODE__IUS:
				return ius != null;
			case MarketplacePackage.NODE__PLATFORMS:
				return platforms != null;
			case MarketplacePackage.NODE__URL:
				return URL_EDEFAULT == null ? getUrl() != null : !URL_EDEFAULT.equals(getUrl());
			case MarketplacePackage.NODE__SCREENSHOT:
				return SCREENSHOT_EDEFAULT == null ? screenshot != null : !SCREENSHOT_EDEFAULT.equals(screenshot);
			case MarketplacePackage.NODE__RAW_BODY:
				return RAW_BODY_EDEFAULT == null ? rawBody != null : !RAW_BODY_EDEFAULT.equals(rawBody);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", type: ");
		result.append(type);
		result.append(", owner: ");
		result.append(owner);
		result.append(", favorited: ");
		result.append(favorited);
		result.append(", installstotal: ");
		result.append(installstotal);
		result.append(", installsrecent: ");
		result.append(installsrecent);
		result.append(", shortdescription: ");
		result.append(shortdescription);
		result.append(", body: ");
		result.append(body);
		result.append(", created: ");
		result.append(created);
		result.append(", changed: ");
		result.append(changed);
		result.append(", foundationmember: ");
		result.append(foundationmember);
		result.append(", homepageurl: ");
		result.append(homepageurl);
		result.append(", image: ");
		result.append(image);
		result.append(", license: ");
		result.append(license);
		result.append(", companyname: ");
		result.append(companyname);
		result.append(", status: ");
		result.append(status);
		result.append(", supporturl: ");
		result.append(supporturl);
		result.append(", version: ");
		result.append(version);
		result.append(", eclipseversion: ");
		result.append(eclipseversion);
		result.append(", updateurl: ");
		result.append(updateurl);
		result.append(", screenshot: ");
		result.append(screenshot);
		result.append(", rawBody: ");
		result.append(rawBody);
		result.append(')');
		return result.toString();
	}

} // NodeImpl
