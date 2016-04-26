/**
 */
package org.dawnsci.marketplace;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dawnsci.marketplace.Node#getId <em>Id</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getName <em>Name</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getType <em>Type</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getCategories <em>Categories</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getTags <em>Tags</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getFavorited <em>Favorited</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getInstallstotal <em>Installstotal</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getInstallsrecent <em>Installsrecent</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getShortdescription <em>Shortdescription</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getBody <em>Body</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getCreated <em>Created</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getChanged <em>Changed</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getFoundationmember <em>Foundationmember</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getHomepageurl <em>Homepageurl</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getImage <em>Image</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getLicense <em>License</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getCompanyname <em>Companyname</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getStatus <em>Status</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getSupporturl <em>Supporturl</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getVersion <em>Version</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getEclipseversion <em>Eclipseversion</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getUpdateurl <em>Updateurl</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getIus <em>Ius</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getPlatforms <em>Platforms</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getUrl <em>Url</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getScreenshot <em>Screenshot</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getRawBody <em>Raw Body</em>}</li>
 *   <li>{@link org.dawnsci.marketplace.Node#getRawShortdescription <em>Raw Shortdescription</em>}</li>
 * </ul>
 *
 * @see org.dawnsci.marketplace.MarketplacePackage#getNode()
 * @model extendedMetaData="name='node'"
 * @generated
 */
public interface Node extends EObject {

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(Long)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Id()
	 * @model id="true"
	 *        annotation="teneo.jpa value='@Id\n@GeneratedValue(strategy=GenerationType.IDENTITY)'"
	 * @generated
	 */
	Long getId();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(Long value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Listing title
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Favorited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Favorited</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Favorited</em>' attribute.
	 * @see #setFavorited(Integer)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Favorited()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	Integer getFavorited();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getFavorited <em>Favorited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Favorited</em>' attribute.
	 * @see #getFavorited()
	 * @generated
	 */
	void setFavorited(Integer value);

	/**
	 * Returns the value of the '<em><b>Installstotal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Installstotal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Installstotal</em>' attribute.
	 * @see #setInstallstotal(Integer)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Installstotal()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	Integer getInstallstotal();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getInstallstotal <em>Installstotal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Installstotal</em>' attribute.
	 * @see #getInstallstotal()
	 * @generated
	 */
	void setInstallstotal(Integer value);

	/**
	 * Returns the value of the '<em><b>Installsrecent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Installsrecent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Installsrecent</em>' attribute.
	 * @see #setInstallsrecent(Integer)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Installsrecent()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	Integer getInstallsrecent();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getInstallsrecent <em>Installsrecent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Installsrecent</em>' attribute.
	 * @see #getInstallsrecent()
	 * @generated
	 */
	void setInstallsrecent(Integer value);

	/**
	 * Returns the value of the '<em><b>Shortdescription</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shortdescription</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shortdescription</em>' attribute.
	 * @see #setShortdescription(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Shortdescription()
	 * @model extendedMetaData="kind='element'"
	 *        annotation="teneo.jpa value='@Lob'"
	 * @generated
	 */
	String getShortdescription();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getShortdescription <em>Shortdescription</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shortdescription</em>' attribute.
	 * @see #getShortdescription()
	 * @generated
	 */
	void setShortdescription(String value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' attribute.
	 * @see #setBody(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Body()
	 * @model extendedMetaData="kind='element'"
	 *        annotation="teneo.jpa value='@Lob'"
	 * @generated
	 */
	String getBody();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getBody <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' attribute.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(String value);

	/**
	 * Returns the value of the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created</em>' attribute.
	 * @see #setCreated(Long)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Created()
	 * @model extendedMetaData="kind='element'"
	 *        annotation="teneo.jpa value='@Version'"
	 * @generated
	 */
	Long getCreated();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getCreated <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created</em>' attribute.
	 * @see #getCreated()
	 * @generated
	 */
	void setCreated(Long value);

	/**
	 * Returns the value of the '<em><b>Changed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Changed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Changed</em>' attribute.
	 * @see #setChanged(Long)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Changed()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	Long getChanged();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getChanged <em>Changed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Changed</em>' attribute.
	 * @see #getChanged()
	 * @generated
	 */
	void setChanged(Long value);

	/**
	 * Returns the value of the '<em><b>Foundationmember</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foundationmember</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foundationmember</em>' attribute.
	 * @see #setFoundationmember(Integer)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Foundationmember()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	Integer getFoundationmember();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getFoundationmember <em>Foundationmember</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Foundationmember</em>' attribute.
	 * @see #getFoundationmember()
	 * @generated
	 */
	void setFoundationmember(Integer value);

	/**
	 * Returns the value of the '<em><b>Homepageurl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Homepageurl</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Home page URL.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Homepageurl</em>' attribute.
	 * @see #setHomepageurl(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Homepageurl()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getHomepageurl();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getHomepageurl <em>Homepageurl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Homepageurl</em>' attribute.
	 * @see #getHomepageurl()
	 * @generated
	 */
	void setHomepageurl(String value);

	/**
	 * Returns the value of the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Image URL.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Image</em>' attribute.
	 * @see #setImage(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Image()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getImage();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getImage <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image</em>' attribute.
	 * @see #getImage()
	 * @generated
	 */
	void setImage(String value);

	/**
	 * Returns the value of the '<em><b>License</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>License</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>License</em>' attribute.
	 * @see #setLicense(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_License()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getLicense();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getLicense <em>License</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>License</em>' attribute.
	 * @see #getLicense()
	 * @generated
	 */
	void setLicense(String value);

	/**
	 * Returns the value of the '<em><b>Companyname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Companyname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Companyname</em>' attribute.
	 * @see #setCompanyname(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Companyname()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getCompanyname();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getCompanyname <em>Companyname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Companyname</em>' attribute.
	 * @see #getCompanyname()
	 * @generated
	 */
	void setCompanyname(String value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see #setStatus(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Status()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getStatus();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(String value);

	/**
	 * Returns the value of the '<em><b>Supporturl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supporturl</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Support site URL.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Supporturl</em>' attribute.
	 * @see #setSupporturl(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Supporturl()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getSupporturl();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getSupporturl <em>Supporturl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supporturl</em>' attribute.
	 * @see #getSupporturl()
	 * @generated
	 */
	void setSupporturl(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Version()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Eclipseversion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eclipseversion</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eclipseversion</em>' attribute.
	 * @see #setEclipseversion(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Eclipseversion()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getEclipseversion();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getEclipseversion <em>Eclipseversion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eclipseversion</em>' attribute.
	 * @see #getEclipseversion()
	 * @generated
	 */
	void setEclipseversion(String value);

	/**
	 * Returns the value of the '<em><b>Updateurl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Updateurl</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * p2-repository URL.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Updateurl</em>' attribute.
	 * @see #setUpdateurl(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Updateurl()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getUpdateurl();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getUpdateurl <em>Updateurl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Updateurl</em>' attribute.
	 * @see #getUpdateurl()
	 * @generated
	 */
	void setUpdateurl(String value);

	/**
	 * Returns the value of the '<em><b>Ius</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ius</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ius</em>' containment reference.
	 * @see #setIus(Ius)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Ius()
	 * @model containment="true"
	 *        extendedMetaData="name='ius'"
	 * @generated
	 */
	Ius getIus();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getIus <em>Ius</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ius</em>' containment reference.
	 * @see #getIus()
	 * @generated
	 */
	void setIus(Ius value);

	/**
	 * Returns the value of the '<em><b>Platforms</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Platforms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Platforms</em>' containment reference.
	 * @see #setPlatforms(Platforms)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Platforms()
	 * @model containment="true"
	 *        extendedMetaData="name='platforms'"
	 * @generated
	 */
	Platforms getPlatforms();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getPlatforms <em>Platforms</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Platforms</em>' containment reference.
	 * @see #getPlatforms()
	 * @generated
	 */
	void setPlatforms(Platforms value);

	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Marketplace relateive URL.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Url()
	 * @model default="" unique="false" volatile="true" derived="true"
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

	/**
	 * Returns the value of the '<em><b>Screenshot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Screenshot</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Screenshot URL.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Screenshot</em>' attribute.
	 * @see #setScreenshot(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Screenshot()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getScreenshot();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getScreenshot <em>Screenshot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Screenshot</em>' attribute.
	 * @see #getScreenshot()
	 * @generated
	 */
	void setScreenshot(String value);

	/**
	 * Returns the value of the '<em><b>Raw Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw Body</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Body</em>' attribute.
	 * @see #setRawBody(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_RawBody()
	 * @model extendedMetaData="kind='element'"
	 *        annotation="teneo.jpa value='@Lob'"
	 * @generated
	 */
	String getRawBody();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getRawBody <em>Raw Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw Body</em>' attribute.
	 * @see #getRawBody()
	 * @generated
	 */
	void setRawBody(String value);

	/**
	 * Returns the value of the '<em><b>Raw Shortdescription</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw Shortdescription</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Shortdescription</em>' attribute.
	 * @see #setRawShortdescription(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_RawShortdescription()
	 * @model extendedMetaData="kind='element'"
	 *        annotation="teneo.jpa value='@Lob'"
	 * @generated
	 */
	String getRawShortdescription();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getRawShortdescription <em>Raw Shortdescription</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw Shortdescription</em>' attribute.
	 * @see #getRawShortdescription()
	 * @generated
	 */
	void setRawShortdescription(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Type()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Categories</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Categories</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Categories</em>' containment reference.
	 * @see #setCategories(Categories)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Categories()
	 * @model containment="true"
	 * @generated
	 */
	Categories getCategories();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getCategories <em>Categories</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Categories</em>' containment reference.
	 * @see #getCategories()
	 * @generated
	 */
	void setCategories(Categories value);

	/**
	 * Returns the value of the '<em><b>Tags</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tags</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tags</em>' containment reference.
	 * @see #setTags(Tags)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Tags()
	 * @model containment="true"
	 * @generated
	 */
	Tags getTags();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getTags <em>Tags</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tags</em>' containment reference.
	 * @see #getTags()
	 * @generated
	 */
	void setTags(Tags value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the listing owner.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owner</em>' attribute.
	 * @see #setOwner(String)
	 * @see org.dawnsci.marketplace.MarketplacePackage#getNode_Owner()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getOwner();

	/**
	 * Sets the value of the '{@link org.dawnsci.marketplace.Node#getOwner <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' attribute.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(String value);
} // Node
