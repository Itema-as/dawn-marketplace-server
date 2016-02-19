/**
 */
package org.dawnsci.marketplace;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.dawnsci.marketplace.MarketplaceFactory
 * @model kind="package"
 * @generated
 */
public interface MarketplacePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "marketplace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.dawnsci/marketplace";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.dawnsci";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MarketplacePackage eINSTANCE = org.dawnsci.marketplace.impl.MarketplacePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.dawnsci.marketplace.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dawnsci.marketplace.impl.NodeImpl
	 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getNode()
	 * @generated
	 */
	int NODE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CATEGORIES = 3;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__TAGS = 4;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OWNER = 5;

	/**
	 * The feature id for the '<em><b>Favorited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__FAVORITED = 6;

	/**
	 * The feature id for the '<em><b>Installstotal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__INSTALLSTOTAL = 7;

	/**
	 * The feature id for the '<em><b>Installsrecent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__INSTALLSRECENT = 8;

	/**
	 * The feature id for the '<em><b>Shortdescription</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__SHORTDESCRIPTION = 9;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__BODY = 10;

	/**
	 * The feature id for the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CREATED = 11;

	/**
	 * The feature id for the '<em><b>Changed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CHANGED = 12;

	/**
	 * The feature id for the '<em><b>Foundationmember</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__FOUNDATIONMEMBER = 13;

	/**
	 * The feature id for the '<em><b>Homepageurl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__HOMEPAGEURL = 14;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__IMAGE = 15;

	/**
	 * The feature id for the '<em><b>License</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__LICENSE = 16;

	/**
	 * The feature id for the '<em><b>Companyname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__COMPANYNAME = 17;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__STATUS = 18;

	/**
	 * The feature id for the '<em><b>Supporturl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__SUPPORTURL = 19;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__VERSION = 20;

	/**
	 * The feature id for the '<em><b>Eclipseversion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ECLIPSEVERSION = 21;

	/**
	 * The feature id for the '<em><b>Updateurl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__UPDATEURL = 22;

	/**
	 * The feature id for the '<em><b>Ius</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__IUS = 23;

	/**
	 * The feature id for the '<em><b>Platforms</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__PLATFORMS = 24;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__URL = 25;

	/**
	 * The feature id for the '<em><b>Screenshot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__SCREENSHOT = 26;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 27;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.dawnsci.marketplace.impl.CategoryImpl <em>Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dawnsci.marketplace.impl.CategoryImpl
	 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getCategory()
	 * @generated
	 */
	int CATEGORY = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__NAME = 1;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__URL = 2;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__COUNT = 3;

	/**
	 * The number of structural features of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.dawnsci.marketplace.impl.TagImpl <em>Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dawnsci.marketplace.impl.TagImpl
	 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getTag()
	 * @generated
	 */
	int TAG = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__NAME = 1;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__URL = 2;

	/**
	 * The number of structural features of the '<em>Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.dawnsci.marketplace.impl.IuImpl <em>Iu</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dawnsci.marketplace.impl.IuImpl
	 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getIu()
	 * @generated
	 */
	int IU = 3;

	/**
	 * The feature id for the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IU__SELECTED = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IU__MIXED = 1;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IU__REQUIRED = 2;

	/**
	 * The number of structural features of the '<em>Iu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IU_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Iu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IU_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.dawnsci.marketplace.impl.PlatformImpl <em>Platform</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dawnsci.marketplace.impl.PlatformImpl
	 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getPlatform()
	 * @generated
	 */
	int PLATFORM = 4;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM__MIXED = 0;

	/**
	 * The number of structural features of the '<em>Platform</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Platform</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.dawnsci.marketplace.impl.PlatformsImpl <em>Platforms</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dawnsci.marketplace.impl.PlatformsImpl
	 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getPlatforms()
	 * @generated
	 */
	int PLATFORMS = 5;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORMS__ITEMS = 0;

	/**
	 * The number of structural features of the '<em>Platforms</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORMS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Platforms</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORMS_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.dawnsci.marketplace.impl.IusImpl <em>Ius</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dawnsci.marketplace.impl.IusImpl
	 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getIus()
	 * @generated
	 */
	int IUS = 6;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUS__ITEMS = 0;

	/**
	 * The number of structural features of the '<em>Ius</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Ius</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUS_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.dawnsci.marketplace.impl.MarketplaceImpl <em>Marketplace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dawnsci.marketplace.impl.MarketplaceImpl
	 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getMarketplace()
	 * @generated
	 */
	int MARKETPLACE = 7;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKETPLACE__NODE = 0;

	/**
	 * The feature id for the '<em><b>Catalogs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKETPLACE__CATALOGS = 1;

	/**
	 * The feature id for the '<em><b>Markets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKETPLACE__MARKETS = 2;

	/**
	 * The feature id for the '<em><b>Featured</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKETPLACE__FEATURED = 3;

	/**
	 * The feature id for the '<em><b>Base Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKETPLACE__BASE_URL = 4;

	/**
	 * The feature id for the '<em><b>Search</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKETPLACE__SEARCH = 5;

	/**
	 * The feature id for the '<em><b>Recent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKETPLACE__RECENT = 6;

	/**
	 * The number of structural features of the '<em>Marketplace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKETPLACE_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Marketplace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKETPLACE_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.dawnsci.marketplace.impl.CategoriesImpl <em>Categories</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dawnsci.marketplace.impl.CategoriesImpl
	 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getCategories()
	 * @generated
	 */
	int CATEGORIES = 8;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORIES__ITEMS = 0;

	/**
	 * The number of structural features of the '<em>Categories</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORIES_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Categories</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORIES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.dawnsci.marketplace.impl.TagsImpl <em>Tags</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dawnsci.marketplace.impl.TagsImpl
	 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getTags()
	 * @generated
	 */
	int TAGS = 9;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGS__ITEMS = 0;

	/**
	 * The number of structural features of the '<em>Tags</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Tags</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGS_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.dawnsci.marketplace.impl.CatalogsImpl <em>Catalogs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dawnsci.marketplace.impl.CatalogsImpl
	 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getCatalogs()
	 * @generated
	 */
	int CATALOGS = 10;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOGS__ITEMS = 0;

	/**
	 * The number of structural features of the '<em>Catalogs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOGS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Catalogs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOGS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.dawnsci.marketplace.impl.CatalogImpl <em>Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dawnsci.marketplace.impl.CatalogImpl
	 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getCatalog()
	 * @generated
	 */
	int CATALOG = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG__ID = 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG__TITLE = 1;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG__URL = 2;

	/**
	 * The feature id for the '<em><b>Self Contained</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG__SELF_CONTAINED = 3;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG__ICON = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG__DESCRIPTION = 5;

	/**
	 * The feature id for the '<em><b>Dependencies Repository</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG__DEPENDENCIES_REPOSITORY = 6;

	/**
	 * The feature id for the '<em><b>Wizard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG__WIZARD = 7;

	/**
	 * The number of structural features of the '<em>Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.dawnsci.marketplace.impl.WizardImpl <em>Wizard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dawnsci.marketplace.impl.WizardImpl
	 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getWizard()
	 * @generated
	 */
	int WIZARD = 12;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIZARD__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIZARD__ICON = 1;

	/**
	 * The feature id for the '<em><b>Searchtab</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIZARD__SEARCHTAB = 2;

	/**
	 * The feature id for the '<em><b>Populartab</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIZARD__POPULARTAB = 3;

	/**
	 * The feature id for the '<em><b>Recenttab</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIZARD__RECENTTAB = 4;

	/**
	 * The feature id for the '<em><b>News</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIZARD__NEWS = 5;

	/**
	 * The number of structural features of the '<em>Wizard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIZARD_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Wizard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIZARD_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.dawnsci.marketplace.impl.SearchTabImpl <em>Search Tab</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dawnsci.marketplace.impl.SearchTabImpl
	 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getSearchTab()
	 * @generated
	 */
	int SEARCH_TAB = 13;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_TAB__ENABLED = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_TAB__MIXED = 1;

	/**
	 * The number of structural features of the '<em>Search Tab</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_TAB_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Search Tab</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_TAB_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.dawnsci.marketplace.impl.PopularTabImpl <em>Popular Tab</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dawnsci.marketplace.impl.PopularTabImpl
	 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getPopularTab()
	 * @generated
	 */
	int POPULAR_TAB = 14;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULAR_TAB__ENABLED = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULAR_TAB__MIXED = 1;

	/**
	 * The number of structural features of the '<em>Popular Tab</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULAR_TAB_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Popular Tab</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POPULAR_TAB_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.dawnsci.marketplace.impl.RecentTabImpl <em>Recent Tab</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dawnsci.marketplace.impl.RecentTabImpl
	 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getRecentTab()
	 * @generated
	 */
	int RECENT_TAB = 15;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECENT_TAB__ENABLED = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECENT_TAB__MIXED = 1;

	/**
	 * The number of structural features of the '<em>Recent Tab</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECENT_TAB_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Recent Tab</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECENT_TAB_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.dawnsci.marketplace.impl.NewsImpl <em>News</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dawnsci.marketplace.impl.NewsImpl
	 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getNews()
	 * @generated
	 */
	int NEWS = 16;

	/**
	 * The feature id for the '<em><b>Shorttitle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWS__SHORTTITLE = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWS__MIXED = 1;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWS__TIMESTAMP = 2;

	/**
	 * The number of structural features of the '<em>News</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWS_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>News</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWS_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.dawnsci.marketplace.impl.MarketImpl <em>Market</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dawnsci.marketplace.impl.MarketImpl
	 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getMarket()
	 * @generated
	 */
	int MARKET = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKET__NAME = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKET__ID = 1;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKET__URL = 2;

	/**
	 * The feature id for the '<em><b>Category</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKET__CATEGORY = 3;

	/**
	 * The number of structural features of the '<em>Market</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKET_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Market</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.dawnsci.marketplace.impl.FeaturedImpl <em>Featured</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dawnsci.marketplace.impl.FeaturedImpl
	 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getFeatured()
	 * @generated
	 */
	int FEATURED = 18;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURED__COUNT = 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURED__NODES = 1;

	/**
	 * The number of structural features of the '<em>Featured</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURED_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Featured</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURED_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.dawnsci.marketplace.impl.SearchImpl <em>Search</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dawnsci.marketplace.impl.SearchImpl
	 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getSearch()
	 * @generated
	 */
	int SEARCH = 19;

	/**
	 * The feature id for the '<em><b>Term</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH__TERM = 0;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH__URL = 1;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH__COUNT = 2;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH__NODES = 3;

	/**
	 * The number of structural features of the '<em>Search</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Search</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.dawnsci.marketplace.impl.RecentImpl <em>Recent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dawnsci.marketplace.impl.RecentImpl
	 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getRecent()
	 * @generated
	 */
	int RECENT = 20;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECENT__COUNT = 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECENT__NODES = 1;

	/**
	 * The number of structural features of the '<em>Recent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Recent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECENT_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link org.dawnsci.marketplace.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.dawnsci.marketplace.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.dawnsci.marketplace.Node#getId()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.dawnsci.marketplace.Node#getName()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getFavorited <em>Favorited</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Favorited</em>'.
	 * @see org.dawnsci.marketplace.Node#getFavorited()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Favorited();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getInstallstotal <em>Installstotal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Installstotal</em>'.
	 * @see org.dawnsci.marketplace.Node#getInstallstotal()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Installstotal();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getInstallsrecent <em>Installsrecent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Installsrecent</em>'.
	 * @see org.dawnsci.marketplace.Node#getInstallsrecent()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Installsrecent();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getShortdescription <em>Shortdescription</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shortdescription</em>'.
	 * @see org.dawnsci.marketplace.Node#getShortdescription()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Shortdescription();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see org.dawnsci.marketplace.Node#getBody()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Body();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getCreated <em>Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created</em>'.
	 * @see org.dawnsci.marketplace.Node#getCreated()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Created();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getChanged <em>Changed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Changed</em>'.
	 * @see org.dawnsci.marketplace.Node#getChanged()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Changed();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getFoundationmember <em>Foundationmember</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Foundationmember</em>'.
	 * @see org.dawnsci.marketplace.Node#getFoundationmember()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Foundationmember();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getHomepageurl <em>Homepageurl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Homepageurl</em>'.
	 * @see org.dawnsci.marketplace.Node#getHomepageurl()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Homepageurl();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see org.dawnsci.marketplace.Node#getImage()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Image();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getLicense <em>License</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>License</em>'.
	 * @see org.dawnsci.marketplace.Node#getLicense()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_License();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getCompanyname <em>Companyname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Companyname</em>'.
	 * @see org.dawnsci.marketplace.Node#getCompanyname()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Companyname();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.dawnsci.marketplace.Node#getStatus()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Status();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getSupporturl <em>Supporturl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Supporturl</em>'.
	 * @see org.dawnsci.marketplace.Node#getSupporturl()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Supporturl();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.dawnsci.marketplace.Node#getVersion()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getEclipseversion <em>Eclipseversion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Eclipseversion</em>'.
	 * @see org.dawnsci.marketplace.Node#getEclipseversion()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Eclipseversion();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getUpdateurl <em>Updateurl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Updateurl</em>'.
	 * @see org.dawnsci.marketplace.Node#getUpdateurl()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Updateurl();

	/**
	 * Returns the meta object for the containment reference '{@link org.dawnsci.marketplace.Node#getIus <em>Ius</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ius</em>'.
	 * @see org.dawnsci.marketplace.Node#getIus()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Ius();

	/**
	 * Returns the meta object for the containment reference '{@link org.dawnsci.marketplace.Node#getPlatforms <em>Platforms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Platforms</em>'.
	 * @see org.dawnsci.marketplace.Node#getPlatforms()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Platforms();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.dawnsci.marketplace.Node#getUrl()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Url();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getScreenshot <em>Screenshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Screenshot</em>'.
	 * @see org.dawnsci.marketplace.Node#getScreenshot()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Screenshot();

	/**
	 * Returns the meta object for class '{@link org.dawnsci.marketplace.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category</em>'.
	 * @see org.dawnsci.marketplace.Category
	 * @generated
	 */
	EClass getCategory();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Category#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.dawnsci.marketplace.Category#getId()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Category#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.dawnsci.marketplace.Category#getName()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Category#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.dawnsci.marketplace.Category#getUrl()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Url();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Category#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see org.dawnsci.marketplace.Category#getCount()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Count();

	/**
	 * Returns the meta object for class '{@link org.dawnsci.marketplace.Tag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag</em>'.
	 * @see org.dawnsci.marketplace.Tag
	 * @generated
	 */
	EClass getTag();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Tag#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.dawnsci.marketplace.Tag#getId()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Tag#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.dawnsci.marketplace.Tag#getName()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Tag#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.dawnsci.marketplace.Tag#getUrl()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_Url();

	/**
	 * Returns the meta object for class '{@link org.dawnsci.marketplace.Iu <em>Iu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iu</em>'.
	 * @see org.dawnsci.marketplace.Iu
	 * @generated
	 */
	EClass getIu();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Iu#isSelected <em>Selected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selected</em>'.
	 * @see org.dawnsci.marketplace.Iu#isSelected()
	 * @see #getIu()
	 * @generated
	 */
	EAttribute getIu_Selected();

	/**
	 * Returns the meta object for the attribute list '{@link org.dawnsci.marketplace.Iu#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.dawnsci.marketplace.Iu#getMixed()
	 * @see #getIu()
	 * @generated
	 */
	EAttribute getIu_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Iu#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see org.dawnsci.marketplace.Iu#isRequired()
	 * @see #getIu()
	 * @generated
	 */
	EAttribute getIu_Required();

	/**
	 * Returns the meta object for class '{@link org.dawnsci.marketplace.Platform <em>Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Platform</em>'.
	 * @see org.dawnsci.marketplace.Platform
	 * @generated
	 */
	EClass getPlatform();

	/**
	 * Returns the meta object for the attribute list '{@link org.dawnsci.marketplace.Platform#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.dawnsci.marketplace.Platform#getMixed()
	 * @see #getPlatform()
	 * @generated
	 */
	EAttribute getPlatform_Mixed();

	/**
	 * Returns the meta object for class '{@link org.dawnsci.marketplace.Platforms <em>Platforms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Platforms</em>'.
	 * @see org.dawnsci.marketplace.Platforms
	 * @generated
	 */
	EClass getPlatforms();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dawnsci.marketplace.Platforms#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see org.dawnsci.marketplace.Platforms#getItems()
	 * @see #getPlatforms()
	 * @generated
	 */
	EReference getPlatforms_Items();

	/**
	 * Returns the meta object for class '{@link org.dawnsci.marketplace.Ius <em>Ius</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ius</em>'.
	 * @see org.dawnsci.marketplace.Ius
	 * @generated
	 */
	EClass getIus();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dawnsci.marketplace.Ius#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see org.dawnsci.marketplace.Ius#getItems()
	 * @see #getIus()
	 * @generated
	 */
	EReference getIus_Items();

	/**
	 * Returns the meta object for class '{@link org.dawnsci.marketplace.Marketplace <em>Marketplace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Marketplace</em>'.
	 * @see org.dawnsci.marketplace.Marketplace
	 * @generated
	 */
	EClass getMarketplace();

	/**
	 * Returns the meta object for the containment reference '{@link org.dawnsci.marketplace.Marketplace#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Node</em>'.
	 * @see org.dawnsci.marketplace.Marketplace#getNode()
	 * @see #getMarketplace()
	 * @generated
	 */
	EReference getMarketplace_Node();

	/**
	 * Returns the meta object for the containment reference '{@link org.dawnsci.marketplace.Marketplace#getCatalogs <em>Catalogs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Catalogs</em>'.
	 * @see org.dawnsci.marketplace.Marketplace#getCatalogs()
	 * @see #getMarketplace()
	 * @generated
	 */
	EReference getMarketplace_Catalogs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dawnsci.marketplace.Marketplace#getMarkets <em>Markets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Markets</em>'.
	 * @see org.dawnsci.marketplace.Marketplace#getMarkets()
	 * @see #getMarketplace()
	 * @generated
	 */
	EReference getMarketplace_Markets();

	/**
	 * Returns the meta object for the containment reference '{@link org.dawnsci.marketplace.Marketplace#getFeatured <em>Featured</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Featured</em>'.
	 * @see org.dawnsci.marketplace.Marketplace#getFeatured()
	 * @see #getMarketplace()
	 * @generated
	 */
	EReference getMarketplace_Featured();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Marketplace#getBaseUrl <em>Base Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base Url</em>'.
	 * @see org.dawnsci.marketplace.Marketplace#getBaseUrl()
	 * @see #getMarketplace()
	 * @generated
	 */
	EAttribute getMarketplace_BaseUrl();

	/**
	 * Returns the meta object for the containment reference '{@link org.dawnsci.marketplace.Marketplace#getSearch <em>Search</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Search</em>'.
	 * @see org.dawnsci.marketplace.Marketplace#getSearch()
	 * @see #getMarketplace()
	 * @generated
	 */
	EReference getMarketplace_Search();

	/**
	 * Returns the meta object for the containment reference '{@link org.dawnsci.marketplace.Marketplace#getRecent <em>Recent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Recent</em>'.
	 * @see org.dawnsci.marketplace.Marketplace#getRecent()
	 * @see #getMarketplace()
	 * @generated
	 */
	EReference getMarketplace_Recent();

	/**
	 * Returns the meta object for class '{@link org.dawnsci.marketplace.Categories <em>Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Categories</em>'.
	 * @see org.dawnsci.marketplace.Categories
	 * @generated
	 */
	EClass getCategories();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dawnsci.marketplace.Categories#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see org.dawnsci.marketplace.Categories#getItems()
	 * @see #getCategories()
	 * @generated
	 */
	EReference getCategories_Items();

	/**
	 * Returns the meta object for class '{@link org.dawnsci.marketplace.Tags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tags</em>'.
	 * @see org.dawnsci.marketplace.Tags
	 * @generated
	 */
	EClass getTags();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dawnsci.marketplace.Tags#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see org.dawnsci.marketplace.Tags#getItems()
	 * @see #getTags()
	 * @generated
	 */
	EReference getTags_Items();

	/**
	 * Returns the meta object for class '{@link org.dawnsci.marketplace.Catalogs <em>Catalogs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Catalogs</em>'.
	 * @see org.dawnsci.marketplace.Catalogs
	 * @generated
	 */
	EClass getCatalogs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dawnsci.marketplace.Catalogs#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see org.dawnsci.marketplace.Catalogs#getItems()
	 * @see #getCatalogs()
	 * @generated
	 */
	EReference getCatalogs_Items();

	/**
	 * Returns the meta object for class '{@link org.dawnsci.marketplace.Catalog <em>Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Catalog</em>'.
	 * @see org.dawnsci.marketplace.Catalog
	 * @generated
	 */
	EClass getCatalog();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Catalog#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.dawnsci.marketplace.Catalog#getId()
	 * @see #getCatalog()
	 * @generated
	 */
	EAttribute getCatalog_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Catalog#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.dawnsci.marketplace.Catalog#getTitle()
	 * @see #getCatalog()
	 * @generated
	 */
	EAttribute getCatalog_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Catalog#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.dawnsci.marketplace.Catalog#getUrl()
	 * @see #getCatalog()
	 * @generated
	 */
	EAttribute getCatalog_Url();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Catalog#getSelfContained <em>Self Contained</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Self Contained</em>'.
	 * @see org.dawnsci.marketplace.Catalog#getSelfContained()
	 * @see #getCatalog()
	 * @generated
	 */
	EAttribute getCatalog_SelfContained();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Catalog#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see org.dawnsci.marketplace.Catalog#getIcon()
	 * @see #getCatalog()
	 * @generated
	 */
	EAttribute getCatalog_Icon();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Catalog#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.dawnsci.marketplace.Catalog#getDescription()
	 * @see #getCatalog()
	 * @generated
	 */
	EAttribute getCatalog_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Catalog#getDependenciesRepository <em>Dependencies Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dependencies Repository</em>'.
	 * @see org.dawnsci.marketplace.Catalog#getDependenciesRepository()
	 * @see #getCatalog()
	 * @generated
	 */
	EAttribute getCatalog_DependenciesRepository();

	/**
	 * Returns the meta object for the containment reference '{@link org.dawnsci.marketplace.Catalog#getWizard <em>Wizard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Wizard</em>'.
	 * @see org.dawnsci.marketplace.Catalog#getWizard()
	 * @see #getCatalog()
	 * @generated
	 */
	EReference getCatalog_Wizard();

	/**
	 * Returns the meta object for class '{@link org.dawnsci.marketplace.Wizard <em>Wizard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wizard</em>'.
	 * @see org.dawnsci.marketplace.Wizard
	 * @generated
	 */
	EClass getWizard();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Wizard#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.dawnsci.marketplace.Wizard#getTitle()
	 * @see #getWizard()
	 * @generated
	 */
	EAttribute getWizard_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Wizard#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see org.dawnsci.marketplace.Wizard#getIcon()
	 * @see #getWizard()
	 * @generated
	 */
	EAttribute getWizard_Icon();

	/**
	 * Returns the meta object for the containment reference '{@link org.dawnsci.marketplace.Wizard#getSearchtab <em>Searchtab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Searchtab</em>'.
	 * @see org.dawnsci.marketplace.Wizard#getSearchtab()
	 * @see #getWizard()
	 * @generated
	 */
	EReference getWizard_Searchtab();

	/**
	 * Returns the meta object for the containment reference '{@link org.dawnsci.marketplace.Wizard#getPopulartab <em>Populartab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Populartab</em>'.
	 * @see org.dawnsci.marketplace.Wizard#getPopulartab()
	 * @see #getWizard()
	 * @generated
	 */
	EReference getWizard_Populartab();

	/**
	 * Returns the meta object for the containment reference '{@link org.dawnsci.marketplace.Wizard#getRecenttab <em>Recenttab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Recenttab</em>'.
	 * @see org.dawnsci.marketplace.Wizard#getRecenttab()
	 * @see #getWizard()
	 * @generated
	 */
	EReference getWizard_Recenttab();

	/**
	 * Returns the meta object for the containment reference '{@link org.dawnsci.marketplace.Wizard#getNews <em>News</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>News</em>'.
	 * @see org.dawnsci.marketplace.Wizard#getNews()
	 * @see #getWizard()
	 * @generated
	 */
	EReference getWizard_News();

	/**
	 * Returns the meta object for class '{@link org.dawnsci.marketplace.SearchTab <em>Search Tab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Search Tab</em>'.
	 * @see org.dawnsci.marketplace.SearchTab
	 * @generated
	 */
	EClass getSearchTab();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.SearchTab#getEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.dawnsci.marketplace.SearchTab#getEnabled()
	 * @see #getSearchTab()
	 * @generated
	 */
	EAttribute getSearchTab_Enabled();

	/**
	 * Returns the meta object for the attribute list '{@link org.dawnsci.marketplace.SearchTab#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.dawnsci.marketplace.SearchTab#getMixed()
	 * @see #getSearchTab()
	 * @generated
	 */
	EAttribute getSearchTab_Mixed();

	/**
	 * Returns the meta object for class '{@link org.dawnsci.marketplace.PopularTab <em>Popular Tab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Popular Tab</em>'.
	 * @see org.dawnsci.marketplace.PopularTab
	 * @generated
	 */
	EClass getPopularTab();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.PopularTab#getEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.dawnsci.marketplace.PopularTab#getEnabled()
	 * @see #getPopularTab()
	 * @generated
	 */
	EAttribute getPopularTab_Enabled();

	/**
	 * Returns the meta object for the attribute list '{@link org.dawnsci.marketplace.PopularTab#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.dawnsci.marketplace.PopularTab#getMixed()
	 * @see #getPopularTab()
	 * @generated
	 */
	EAttribute getPopularTab_Mixed();

	/**
	 * Returns the meta object for class '{@link org.dawnsci.marketplace.RecentTab <em>Recent Tab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recent Tab</em>'.
	 * @see org.dawnsci.marketplace.RecentTab
	 * @generated
	 */
	EClass getRecentTab();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.RecentTab#getEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.dawnsci.marketplace.RecentTab#getEnabled()
	 * @see #getRecentTab()
	 * @generated
	 */
	EAttribute getRecentTab_Enabled();

	/**
	 * Returns the meta object for the attribute list '{@link org.dawnsci.marketplace.RecentTab#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.dawnsci.marketplace.RecentTab#getMixed()
	 * @see #getRecentTab()
	 * @generated
	 */
	EAttribute getRecentTab_Mixed();

	/**
	 * Returns the meta object for class '{@link org.dawnsci.marketplace.News <em>News</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>News</em>'.
	 * @see org.dawnsci.marketplace.News
	 * @generated
	 */
	EClass getNews();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.News#getShorttitle <em>Shorttitle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shorttitle</em>'.
	 * @see org.dawnsci.marketplace.News#getShorttitle()
	 * @see #getNews()
	 * @generated
	 */
	EAttribute getNews_Shorttitle();

	/**
	 * Returns the meta object for the attribute list '{@link org.dawnsci.marketplace.News#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.dawnsci.marketplace.News#getMixed()
	 * @see #getNews()
	 * @generated
	 */
	EAttribute getNews_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.News#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see org.dawnsci.marketplace.News#getTimestamp()
	 * @see #getNews()
	 * @generated
	 */
	EAttribute getNews_Timestamp();

	/**
	 * Returns the meta object for class '{@link org.dawnsci.marketplace.Market <em>Market</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Market</em>'.
	 * @see org.dawnsci.marketplace.Market
	 * @generated
	 */
	EClass getMarket();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Market#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.dawnsci.marketplace.Market#getName()
	 * @see #getMarket()
	 * @generated
	 */
	EAttribute getMarket_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Market#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.dawnsci.marketplace.Market#getId()
	 * @see #getMarket()
	 * @generated
	 */
	EAttribute getMarket_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Market#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.dawnsci.marketplace.Market#getUrl()
	 * @see #getMarket()
	 * @generated
	 */
	EAttribute getMarket_Url();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dawnsci.marketplace.Market#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Category</em>'.
	 * @see org.dawnsci.marketplace.Market#getCategory()
	 * @see #getMarket()
	 * @generated
	 */
	EReference getMarket_Category();

	/**
	 * Returns the meta object for class '{@link org.dawnsci.marketplace.Featured <em>Featured</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Featured</em>'.
	 * @see org.dawnsci.marketplace.Featured
	 * @generated
	 */
	EClass getFeatured();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Featured#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see org.dawnsci.marketplace.Featured#getCount()
	 * @see #getFeatured()
	 * @generated
	 */
	EAttribute getFeatured_Count();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dawnsci.marketplace.Featured#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.dawnsci.marketplace.Featured#getNodes()
	 * @see #getFeatured()
	 * @generated
	 */
	EReference getFeatured_Nodes();

	/**
	 * Returns the meta object for class '{@link org.dawnsci.marketplace.Search <em>Search</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Search</em>'.
	 * @see org.dawnsci.marketplace.Search
	 * @generated
	 */
	EClass getSearch();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Search#getTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Term</em>'.
	 * @see org.dawnsci.marketplace.Search#getTerm()
	 * @see #getSearch()
	 * @generated
	 */
	EAttribute getSearch_Term();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Search#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.dawnsci.marketplace.Search#getUrl()
	 * @see #getSearch()
	 * @generated
	 */
	EAttribute getSearch_Url();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Search#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see org.dawnsci.marketplace.Search#getCount()
	 * @see #getSearch()
	 * @generated
	 */
	EAttribute getSearch_Count();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dawnsci.marketplace.Search#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.dawnsci.marketplace.Search#getNodes()
	 * @see #getSearch()
	 * @generated
	 */
	EReference getSearch_Nodes();

	/**
	 * Returns the meta object for class '{@link org.dawnsci.marketplace.Recent <em>Recent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recent</em>'.
	 * @see org.dawnsci.marketplace.Recent
	 * @generated
	 */
	EClass getRecent();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Recent#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see org.dawnsci.marketplace.Recent#getCount()
	 * @see #getRecent()
	 * @generated
	 */
	EAttribute getRecent_Count();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dawnsci.marketplace.Recent#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.dawnsci.marketplace.Recent#getNodes()
	 * @see #getRecent()
	 * @generated
	 */
	EReference getRecent_Nodes();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.dawnsci.marketplace.Node#getType()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Type();

	/**
	 * Returns the meta object for the containment reference '{@link org.dawnsci.marketplace.Node#getCategories <em>Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Categories</em>'.
	 * @see org.dawnsci.marketplace.Node#getCategories()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Categories();

	/**
	 * Returns the meta object for the containment reference '{@link org.dawnsci.marketplace.Node#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Tags</em>'.
	 * @see org.dawnsci.marketplace.Node#getTags()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Tags();

	/**
	 * Returns the meta object for the attribute '{@link org.dawnsci.marketplace.Node#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Owner</em>'.
	 * @see org.dawnsci.marketplace.Node#getOwner()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Owner();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MarketplaceFactory getMarketplaceFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.dawnsci.marketplace.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dawnsci.marketplace.impl.NodeImpl
		 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__ID = eINSTANCE.getNode_Id();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__NAME = eINSTANCE.getNode_Name();
		/**
		 * The meta object literal for the '<em><b>Favorited</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__FAVORITED = eINSTANCE.getNode_Favorited();
		/**
		 * The meta object literal for the '<em><b>Installstotal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__INSTALLSTOTAL = eINSTANCE.getNode_Installstotal();
		/**
		 * The meta object literal for the '<em><b>Installsrecent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__INSTALLSRECENT = eINSTANCE.getNode_Installsrecent();
		/**
		 * The meta object literal for the '<em><b>Shortdescription</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__SHORTDESCRIPTION = eINSTANCE.getNode_Shortdescription();
		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__BODY = eINSTANCE.getNode_Body();
		/**
		 * The meta object literal for the '<em><b>Created</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__CREATED = eINSTANCE.getNode_Created();
		/**
		 * The meta object literal for the '<em><b>Changed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__CHANGED = eINSTANCE.getNode_Changed();
		/**
		 * The meta object literal for the '<em><b>Foundationmember</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__FOUNDATIONMEMBER = eINSTANCE.getNode_Foundationmember();
		/**
		 * The meta object literal for the '<em><b>Homepageurl</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__HOMEPAGEURL = eINSTANCE.getNode_Homepageurl();
		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__IMAGE = eINSTANCE.getNode_Image();
		/**
		 * The meta object literal for the '<em><b>License</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__LICENSE = eINSTANCE.getNode_License();
		/**
		 * The meta object literal for the '<em><b>Companyname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__COMPANYNAME = eINSTANCE.getNode_Companyname();
		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__STATUS = eINSTANCE.getNode_Status();
		/**
		 * The meta object literal for the '<em><b>Supporturl</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__SUPPORTURL = eINSTANCE.getNode_Supporturl();
		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__VERSION = eINSTANCE.getNode_Version();
		/**
		 * The meta object literal for the '<em><b>Eclipseversion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__ECLIPSEVERSION = eINSTANCE.getNode_Eclipseversion();
		/**
		 * The meta object literal for the '<em><b>Updateurl</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__UPDATEURL = eINSTANCE.getNode_Updateurl();
		/**
		 * The meta object literal for the '<em><b>Ius</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__IUS = eINSTANCE.getNode_Ius();
		/**
		 * The meta object literal for the '<em><b>Platforms</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__PLATFORMS = eINSTANCE.getNode_Platforms();
		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__URL = eINSTANCE.getNode_Url();
		/**
		 * The meta object literal for the '<em><b>Screenshot</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__SCREENSHOT = eINSTANCE.getNode_Screenshot();
		/**
		 * The meta object literal for the '{@link org.dawnsci.marketplace.impl.CategoryImpl <em>Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dawnsci.marketplace.impl.CategoryImpl
		 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getCategory()
		 * @generated
		 */
		EClass CATEGORY = eINSTANCE.getCategory();
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__ID = eINSTANCE.getCategory_Id();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__NAME = eINSTANCE.getCategory_Name();
		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__URL = eINSTANCE.getCategory_Url();
		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__COUNT = eINSTANCE.getCategory_Count();
		/**
		 * The meta object literal for the '{@link org.dawnsci.marketplace.impl.TagImpl <em>Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dawnsci.marketplace.impl.TagImpl
		 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getTag()
		 * @generated
		 */
		EClass TAG = eINSTANCE.getTag();
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__ID = eINSTANCE.getTag_Id();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__NAME = eINSTANCE.getTag_Name();
		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__URL = eINSTANCE.getTag_Url();
		/**
		 * The meta object literal for the '{@link org.dawnsci.marketplace.impl.IuImpl <em>Iu</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dawnsci.marketplace.impl.IuImpl
		 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getIu()
		 * @generated
		 */
		EClass IU = eINSTANCE.getIu();
		/**
		 * The meta object literal for the '<em><b>Selected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IU__SELECTED = eINSTANCE.getIu_Selected();
		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IU__MIXED = eINSTANCE.getIu_Mixed();
		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IU__REQUIRED = eINSTANCE.getIu_Required();
		/**
		 * The meta object literal for the '{@link org.dawnsci.marketplace.impl.PlatformImpl <em>Platform</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dawnsci.marketplace.impl.PlatformImpl
		 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getPlatform()
		 * @generated
		 */
		EClass PLATFORM = eINSTANCE.getPlatform();
		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLATFORM__MIXED = eINSTANCE.getPlatform_Mixed();
		/**
		 * The meta object literal for the '{@link org.dawnsci.marketplace.impl.PlatformsImpl <em>Platforms</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dawnsci.marketplace.impl.PlatformsImpl
		 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getPlatforms()
		 * @generated
		 */
		EClass PLATFORMS = eINSTANCE.getPlatforms();
		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLATFORMS__ITEMS = eINSTANCE.getPlatforms_Items();
		/**
		 * The meta object literal for the '{@link org.dawnsci.marketplace.impl.IusImpl <em>Ius</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dawnsci.marketplace.impl.IusImpl
		 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getIus()
		 * @generated
		 */
		EClass IUS = eINSTANCE.getIus();
		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IUS__ITEMS = eINSTANCE.getIus_Items();
		/**
		 * The meta object literal for the '{@link org.dawnsci.marketplace.impl.MarketplaceImpl <em>Marketplace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dawnsci.marketplace.impl.MarketplaceImpl
		 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getMarketplace()
		 * @generated
		 */
		EClass MARKETPLACE = eINSTANCE.getMarketplace();
		/**
		 * The meta object literal for the '<em><b>Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKETPLACE__NODE = eINSTANCE.getMarketplace_Node();
		/**
		 * The meta object literal for the '<em><b>Catalogs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKETPLACE__CATALOGS = eINSTANCE.getMarketplace_Catalogs();
		/**
		 * The meta object literal for the '<em><b>Markets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKETPLACE__MARKETS = eINSTANCE.getMarketplace_Markets();
		/**
		 * The meta object literal for the '<em><b>Featured</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKETPLACE__FEATURED = eINSTANCE.getMarketplace_Featured();
		/**
		 * The meta object literal for the '<em><b>Base Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MARKETPLACE__BASE_URL = eINSTANCE.getMarketplace_BaseUrl();
		/**
		 * The meta object literal for the '<em><b>Search</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKETPLACE__SEARCH = eINSTANCE.getMarketplace_Search();
		/**
		 * The meta object literal for the '<em><b>Recent</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKETPLACE__RECENT = eINSTANCE.getMarketplace_Recent();
		/**
		 * The meta object literal for the '{@link org.dawnsci.marketplace.impl.CategoriesImpl <em>Categories</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dawnsci.marketplace.impl.CategoriesImpl
		 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getCategories()
		 * @generated
		 */
		EClass CATEGORIES = eINSTANCE.getCategories();
		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATEGORIES__ITEMS = eINSTANCE.getCategories_Items();
		/**
		 * The meta object literal for the '{@link org.dawnsci.marketplace.impl.TagsImpl <em>Tags</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dawnsci.marketplace.impl.TagsImpl
		 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getTags()
		 * @generated
		 */
		EClass TAGS = eINSTANCE.getTags();
		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAGS__ITEMS = eINSTANCE.getTags_Items();
		/**
		 * The meta object literal for the '{@link org.dawnsci.marketplace.impl.CatalogsImpl <em>Catalogs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dawnsci.marketplace.impl.CatalogsImpl
		 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getCatalogs()
		 * @generated
		 */
		EClass CATALOGS = eINSTANCE.getCatalogs();
		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATALOGS__ITEMS = eINSTANCE.getCatalogs_Items();
		/**
		 * The meta object literal for the '{@link org.dawnsci.marketplace.impl.CatalogImpl <em>Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dawnsci.marketplace.impl.CatalogImpl
		 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getCatalog()
		 * @generated
		 */
		EClass CATALOG = eINSTANCE.getCatalog();
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATALOG__ID = eINSTANCE.getCatalog_Id();
		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATALOG__TITLE = eINSTANCE.getCatalog_Title();
		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATALOG__URL = eINSTANCE.getCatalog_Url();
		/**
		 * The meta object literal for the '<em><b>Self Contained</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATALOG__SELF_CONTAINED = eINSTANCE.getCatalog_SelfContained();
		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATALOG__ICON = eINSTANCE.getCatalog_Icon();
		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATALOG__DESCRIPTION = eINSTANCE.getCatalog_Description();
		/**
		 * The meta object literal for the '<em><b>Dependencies Repository</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATALOG__DEPENDENCIES_REPOSITORY = eINSTANCE.getCatalog_DependenciesRepository();
		/**
		 * The meta object literal for the '<em><b>Wizard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATALOG__WIZARD = eINSTANCE.getCatalog_Wizard();
		/**
		 * The meta object literal for the '{@link org.dawnsci.marketplace.impl.WizardImpl <em>Wizard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dawnsci.marketplace.impl.WizardImpl
		 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getWizard()
		 * @generated
		 */
		EClass WIZARD = eINSTANCE.getWizard();
		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIZARD__TITLE = eINSTANCE.getWizard_Title();
		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIZARD__ICON = eINSTANCE.getWizard_Icon();
		/**
		 * The meta object literal for the '<em><b>Searchtab</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIZARD__SEARCHTAB = eINSTANCE.getWizard_Searchtab();
		/**
		 * The meta object literal for the '<em><b>Populartab</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIZARD__POPULARTAB = eINSTANCE.getWizard_Populartab();
		/**
		 * The meta object literal for the '<em><b>Recenttab</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIZARD__RECENTTAB = eINSTANCE.getWizard_Recenttab();
		/**
		 * The meta object literal for the '<em><b>News</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIZARD__NEWS = eINSTANCE.getWizard_News();
		/**
		 * The meta object literal for the '{@link org.dawnsci.marketplace.impl.SearchTabImpl <em>Search Tab</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dawnsci.marketplace.impl.SearchTabImpl
		 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getSearchTab()
		 * @generated
		 */
		EClass SEARCH_TAB = eINSTANCE.getSearchTab();
		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH_TAB__ENABLED = eINSTANCE.getSearchTab_Enabled();
		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH_TAB__MIXED = eINSTANCE.getSearchTab_Mixed();
		/**
		 * The meta object literal for the '{@link org.dawnsci.marketplace.impl.PopularTabImpl <em>Popular Tab</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dawnsci.marketplace.impl.PopularTabImpl
		 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getPopularTab()
		 * @generated
		 */
		EClass POPULAR_TAB = eINSTANCE.getPopularTab();
		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POPULAR_TAB__ENABLED = eINSTANCE.getPopularTab_Enabled();
		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POPULAR_TAB__MIXED = eINSTANCE.getPopularTab_Mixed();
		/**
		 * The meta object literal for the '{@link org.dawnsci.marketplace.impl.RecentTabImpl <em>Recent Tab</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dawnsci.marketplace.impl.RecentTabImpl
		 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getRecentTab()
		 * @generated
		 */
		EClass RECENT_TAB = eINSTANCE.getRecentTab();
		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECENT_TAB__ENABLED = eINSTANCE.getRecentTab_Enabled();
		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECENT_TAB__MIXED = eINSTANCE.getRecentTab_Mixed();
		/**
		 * The meta object literal for the '{@link org.dawnsci.marketplace.impl.NewsImpl <em>News</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dawnsci.marketplace.impl.NewsImpl
		 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getNews()
		 * @generated
		 */
		EClass NEWS = eINSTANCE.getNews();
		/**
		 * The meta object literal for the '<em><b>Shorttitle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEWS__SHORTTITLE = eINSTANCE.getNews_Shorttitle();
		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEWS__MIXED = eINSTANCE.getNews_Mixed();
		/**
		 * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEWS__TIMESTAMP = eINSTANCE.getNews_Timestamp();
		/**
		 * The meta object literal for the '{@link org.dawnsci.marketplace.impl.MarketImpl <em>Market</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dawnsci.marketplace.impl.MarketImpl
		 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getMarket()
		 * @generated
		 */
		EClass MARKET = eINSTANCE.getMarket();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MARKET__NAME = eINSTANCE.getMarket_Name();
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MARKET__ID = eINSTANCE.getMarket_Id();
		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MARKET__URL = eINSTANCE.getMarket_Url();
		/**
		 * The meta object literal for the '<em><b>Category</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKET__CATEGORY = eINSTANCE.getMarket_Category();
		/**
		 * The meta object literal for the '{@link org.dawnsci.marketplace.impl.FeaturedImpl <em>Featured</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dawnsci.marketplace.impl.FeaturedImpl
		 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getFeatured()
		 * @generated
		 */
		EClass FEATURED = eINSTANCE.getFeatured();
		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURED__COUNT = eINSTANCE.getFeatured_Count();
		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURED__NODES = eINSTANCE.getFeatured_Nodes();
		/**
		 * The meta object literal for the '{@link org.dawnsci.marketplace.impl.SearchImpl <em>Search</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dawnsci.marketplace.impl.SearchImpl
		 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getSearch()
		 * @generated
		 */
		EClass SEARCH = eINSTANCE.getSearch();
		/**
		 * The meta object literal for the '<em><b>Term</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH__TERM = eINSTANCE.getSearch_Term();
		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH__URL = eINSTANCE.getSearch_Url();
		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH__COUNT = eINSTANCE.getSearch_Count();
		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEARCH__NODES = eINSTANCE.getSearch_Nodes();
		/**
		 * The meta object literal for the '{@link org.dawnsci.marketplace.impl.RecentImpl <em>Recent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dawnsci.marketplace.impl.RecentImpl
		 * @see org.dawnsci.marketplace.impl.MarketplacePackageImpl#getRecent()
		 * @generated
		 */
		EClass RECENT = eINSTANCE.getRecent();
		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECENT__COUNT = eINSTANCE.getRecent_Count();
		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECENT__NODES = eINSTANCE.getRecent_Nodes();
		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__TYPE = eINSTANCE.getNode_Type();
		/**
		 * The meta object literal for the '<em><b>Categories</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__CATEGORIES = eINSTANCE.getNode_Categories();
		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__TAGS = eINSTANCE.getNode_Tags();
		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__OWNER = eINSTANCE.getNode_Owner();

	}

} //MarketplacePackage
