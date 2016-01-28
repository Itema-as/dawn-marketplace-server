/**
 */
package org.dawnsci.marketplace.impl;

import org.dawnsci.marketplace.Catalog;
import org.dawnsci.marketplace.Catalogs;
import org.dawnsci.marketplace.Categories;
import org.dawnsci.marketplace.Category;
import org.dawnsci.marketplace.Featured;
import org.dawnsci.marketplace.Iu;
import org.dawnsci.marketplace.Ius;
import org.dawnsci.marketplace.Market;
import org.dawnsci.marketplace.Marketplace;
import org.dawnsci.marketplace.MarketplaceFactory;
import org.dawnsci.marketplace.MarketplacePackage;
import org.dawnsci.marketplace.News;
import org.dawnsci.marketplace.Node;
import org.dawnsci.marketplace.Platform;
import org.dawnsci.marketplace.Platforms;
import org.dawnsci.marketplace.PopularTab;
import org.dawnsci.marketplace.RecentTab;
import org.dawnsci.marketplace.SearchTab;
import org.dawnsci.marketplace.Tag;
import org.dawnsci.marketplace.Tags;
import org.dawnsci.marketplace.Wizard;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MarketplacePackageImpl extends EPackageImpl implements MarketplacePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoryEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tagEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iuEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass platformEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass platformsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass marketplaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoriesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tagsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass catalogsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass catalogEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wizardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass searchTabEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass popularTabEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recentTabEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass marketEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featuredEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.dawnsci.marketplace.MarketplacePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MarketplacePackageImpl() {
		super(eNS_URI, MarketplaceFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link MarketplacePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MarketplacePackage init() {
		if (isInited) return (MarketplacePackage)EPackage.Registry.INSTANCE.getEPackage(MarketplacePackage.eNS_URI);

		// Obtain or create and register package
		MarketplacePackageImpl theMarketplacePackage = (MarketplacePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MarketplacePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MarketplacePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theMarketplacePackage.createPackageContents();

		// Initialize created meta-data
		theMarketplacePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMarketplacePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MarketplacePackage.eNS_URI, theMarketplacePackage);
		return theMarketplacePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Id() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Name() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Favorited() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Installstotal() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Installsrecent() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Shortdescription() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Body() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Created() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Changed() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Foundationmember() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Homepageurl() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Image() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_License() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Companyname() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Status() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Supporturl() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Version() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Eclipseversion() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Updateurl() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_Ius() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_Platforms() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Url() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Screenshot() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCategory() {
		return categoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCategory_Id() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCategory_Name() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCategory_Url() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCategory_Count() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTag() {
		return tagEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTag_Id() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTag_Name() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTag_Url() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIu() {
		return iuEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIu_Selected() {
		return (EAttribute)iuEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIu_Mixed() {
		return (EAttribute)iuEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlatform() {
		return platformEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlatform_Mixed() {
		return (EAttribute)platformEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlatforms() {
		return platformsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlatforms_Items() {
		return (EReference)platformsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIus() {
		return iusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIus_Items() {
		return (EReference)iusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMarketplace() {
		return marketplaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMarketplace_Node() {
		return (EReference)marketplaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMarketplace_Catalogs() {
		return (EReference)marketplaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMarketplace_Market() {
		return (EReference)marketplaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMarketplace_Featured() {
		return (EReference)marketplaceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCategories() {
		return categoriesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCategories_Items() {
		return (EReference)categoriesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTags() {
		return tagsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTags_Items() {
		return (EReference)tagsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCatalogs() {
		return catalogsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCatalogs_Items() {
		return (EReference)catalogsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCatalog() {
		return catalogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCatalog_Id() {
		return (EAttribute)catalogEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCatalog_Title() {
		return (EAttribute)catalogEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCatalog_Url() {
		return (EAttribute)catalogEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCatalog_SelfContained() {
		return (EAttribute)catalogEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCatalog_Icon() {
		return (EAttribute)catalogEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCatalog_Description() {
		return (EAttribute)catalogEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCatalog_DependenciesRepository() {
		return (EAttribute)catalogEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCatalog_Wizard() {
		return (EReference)catalogEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWizard() {
		return wizardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWizard_Title() {
		return (EAttribute)wizardEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWizard_Icon() {
		return (EAttribute)wizardEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWizard_Searchtab() {
		return (EReference)wizardEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWizard_Populartab() {
		return (EReference)wizardEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWizard_Recenttab() {
		return (EReference)wizardEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWizard_News() {
		return (EReference)wizardEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSearchTab() {
		return searchTabEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchTab_Enabled() {
		return (EAttribute)searchTabEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchTab_Mixed() {
		return (EAttribute)searchTabEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPopularTab() {
		return popularTabEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPopularTab_Enabled() {
		return (EAttribute)popularTabEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPopularTab_Mixed() {
		return (EAttribute)popularTabEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecentTab() {
		return recentTabEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecentTab_Enabled() {
		return (EAttribute)recentTabEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecentTab_Mixed() {
		return (EAttribute)recentTabEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNews() {
		return newsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNews_Shorttitle() {
		return (EAttribute)newsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNews_Mixed() {
		return (EAttribute)newsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNews_Timestamp() {
		return (EAttribute)newsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMarket() {
		return marketEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMarket_Name() {
		return (EAttribute)marketEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMarket_Id() {
		return (EAttribute)marketEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMarket_Url() {
		return (EAttribute)marketEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMarket_Category() {
		return (EReference)marketEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatured() {
		return featuredEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatured_Count() {
		return (EAttribute)featuredEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatured_Nodes() {
		return (EReference)featuredEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Type() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_Categories() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_Tags() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Owner() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarketplaceFactory getMarketplaceFactory() {
		return (MarketplaceFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		nodeEClass = createEClass(NODE);
		createEAttribute(nodeEClass, NODE__ID);
		createEAttribute(nodeEClass, NODE__NAME);
		createEAttribute(nodeEClass, NODE__TYPE);
		createEReference(nodeEClass, NODE__CATEGORIES);
		createEReference(nodeEClass, NODE__TAGS);
		createEAttribute(nodeEClass, NODE__OWNER);
		createEAttribute(nodeEClass, NODE__FAVORITED);
		createEAttribute(nodeEClass, NODE__INSTALLSTOTAL);
		createEAttribute(nodeEClass, NODE__INSTALLSRECENT);
		createEAttribute(nodeEClass, NODE__SHORTDESCRIPTION);
		createEAttribute(nodeEClass, NODE__BODY);
		createEAttribute(nodeEClass, NODE__CREATED);
		createEAttribute(nodeEClass, NODE__CHANGED);
		createEAttribute(nodeEClass, NODE__FOUNDATIONMEMBER);
		createEAttribute(nodeEClass, NODE__HOMEPAGEURL);
		createEAttribute(nodeEClass, NODE__IMAGE);
		createEAttribute(nodeEClass, NODE__LICENSE);
		createEAttribute(nodeEClass, NODE__COMPANYNAME);
		createEAttribute(nodeEClass, NODE__STATUS);
		createEAttribute(nodeEClass, NODE__SUPPORTURL);
		createEAttribute(nodeEClass, NODE__VERSION);
		createEAttribute(nodeEClass, NODE__ECLIPSEVERSION);
		createEAttribute(nodeEClass, NODE__UPDATEURL);
		createEReference(nodeEClass, NODE__IUS);
		createEReference(nodeEClass, NODE__PLATFORMS);
		createEAttribute(nodeEClass, NODE__URL);
		createEAttribute(nodeEClass, NODE__SCREENSHOT);

		categoryEClass = createEClass(CATEGORY);
		createEAttribute(categoryEClass, CATEGORY__ID);
		createEAttribute(categoryEClass, CATEGORY__NAME);
		createEAttribute(categoryEClass, CATEGORY__URL);
		createEAttribute(categoryEClass, CATEGORY__COUNT);

		tagEClass = createEClass(TAG);
		createEAttribute(tagEClass, TAG__ID);
		createEAttribute(tagEClass, TAG__NAME);
		createEAttribute(tagEClass, TAG__URL);

		iuEClass = createEClass(IU);
		createEAttribute(iuEClass, IU__SELECTED);
		createEAttribute(iuEClass, IU__MIXED);

		platformEClass = createEClass(PLATFORM);
		createEAttribute(platformEClass, PLATFORM__MIXED);

		platformsEClass = createEClass(PLATFORMS);
		createEReference(platformsEClass, PLATFORMS__ITEMS);

		iusEClass = createEClass(IUS);
		createEReference(iusEClass, IUS__ITEMS);

		marketplaceEClass = createEClass(MARKETPLACE);
		createEReference(marketplaceEClass, MARKETPLACE__NODE);
		createEReference(marketplaceEClass, MARKETPLACE__CATALOGS);
		createEReference(marketplaceEClass, MARKETPLACE__MARKET);
		createEReference(marketplaceEClass, MARKETPLACE__FEATURED);

		categoriesEClass = createEClass(CATEGORIES);
		createEReference(categoriesEClass, CATEGORIES__ITEMS);

		tagsEClass = createEClass(TAGS);
		createEReference(tagsEClass, TAGS__ITEMS);

		catalogsEClass = createEClass(CATALOGS);
		createEReference(catalogsEClass, CATALOGS__ITEMS);

		catalogEClass = createEClass(CATALOG);
		createEAttribute(catalogEClass, CATALOG__ID);
		createEAttribute(catalogEClass, CATALOG__TITLE);
		createEAttribute(catalogEClass, CATALOG__URL);
		createEAttribute(catalogEClass, CATALOG__SELF_CONTAINED);
		createEAttribute(catalogEClass, CATALOG__ICON);
		createEAttribute(catalogEClass, CATALOG__DESCRIPTION);
		createEAttribute(catalogEClass, CATALOG__DEPENDENCIES_REPOSITORY);
		createEReference(catalogEClass, CATALOG__WIZARD);

		wizardEClass = createEClass(WIZARD);
		createEAttribute(wizardEClass, WIZARD__TITLE);
		createEAttribute(wizardEClass, WIZARD__ICON);
		createEReference(wizardEClass, WIZARD__SEARCHTAB);
		createEReference(wizardEClass, WIZARD__POPULARTAB);
		createEReference(wizardEClass, WIZARD__RECENTTAB);
		createEReference(wizardEClass, WIZARD__NEWS);

		searchTabEClass = createEClass(SEARCH_TAB);
		createEAttribute(searchTabEClass, SEARCH_TAB__ENABLED);
		createEAttribute(searchTabEClass, SEARCH_TAB__MIXED);

		popularTabEClass = createEClass(POPULAR_TAB);
		createEAttribute(popularTabEClass, POPULAR_TAB__ENABLED);
		createEAttribute(popularTabEClass, POPULAR_TAB__MIXED);

		recentTabEClass = createEClass(RECENT_TAB);
		createEAttribute(recentTabEClass, RECENT_TAB__ENABLED);
		createEAttribute(recentTabEClass, RECENT_TAB__MIXED);

		newsEClass = createEClass(NEWS);
		createEAttribute(newsEClass, NEWS__SHORTTITLE);
		createEAttribute(newsEClass, NEWS__MIXED);
		createEAttribute(newsEClass, NEWS__TIMESTAMP);

		marketEClass = createEClass(MARKET);
		createEAttribute(marketEClass, MARKET__NAME);
		createEAttribute(marketEClass, MARKET__ID);
		createEAttribute(marketEClass, MARKET__URL);
		createEReference(marketEClass, MARKET__CATEGORY);

		featuredEClass = createEClass(FEATURED);
		createEAttribute(featuredEClass, FEATURED__COUNT);
		createEReference(featuredEClass, FEATURED__NODES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNode_Id(), ecorePackage.getEString(), "id", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Name(), ecorePackage.getEString(), "name", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Type(), ecorePackage.getEString(), "type", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_Categories(), this.getCategories(), null, "categories", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_Tags(), this.getTags(), null, "tags", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Owner(), ecorePackage.getEString(), "owner", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Favorited(), ecorePackage.getEIntegerObject(), "favorited", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Installstotal(), ecorePackage.getEIntegerObject(), "installstotal", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Installsrecent(), ecorePackage.getEIntegerObject(), "installsrecent", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Shortdescription(), ecorePackage.getEString(), "shortdescription", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Body(), ecorePackage.getEString(), "body", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Created(), ecorePackage.getELongObject(), "created", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Changed(), ecorePackage.getELongObject(), "changed", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Foundationmember(), ecorePackage.getEIntegerObject(), "foundationmember", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Homepageurl(), ecorePackage.getEString(), "homepageurl", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Image(), ecorePackage.getEString(), "image", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_License(), ecorePackage.getEString(), "license", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Companyname(), ecorePackage.getEString(), "companyname", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Status(), ecorePackage.getEString(), "status", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Supporturl(), ecorePackage.getEString(), "supporturl", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Version(), ecorePackage.getEString(), "version", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Eclipseversion(), ecorePackage.getEString(), "eclipseversion", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Updateurl(), ecorePackage.getEString(), "updateurl", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_Ius(), this.getIus(), null, "ius", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_Platforms(), this.getPlatforms(), null, "platforms", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Url(), ecorePackage.getEString(), "url", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Screenshot(), ecorePackage.getEString(), "screenshot", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(categoryEClass, Category.class, "Category", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCategory_Id(), ecorePackage.getEString(), "id", null, 1, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategory_Name(), ecorePackage.getEString(), "name", null, 1, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategory_Url(), ecorePackage.getEString(), "url", null, 1, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategory_Count(), ecorePackage.getEIntegerObject(), "count", null, 0, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tagEClass, Tag.class, "Tag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTag_Id(), ecorePackage.getEString(), "id", null, 0, 1, Tag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_Name(), ecorePackage.getEString(), "name", null, 0, 1, Tag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_Url(), ecorePackage.getEString(), "url", null, 0, 1, Tag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iuEClass, Iu.class, "Iu", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIu_Selected(), ecorePackage.getEBooleanObject(), "selected", null, 0, 1, Iu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIu_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 1, -1, Iu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(platformEClass, Platform.class, "Platform", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlatform_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 1, -1, Platform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(platformsEClass, Platforms.class, "Platforms", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlatforms_Items(), this.getPlatform(), null, "items", null, 0, -1, Platforms.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iusEClass, Ius.class, "Ius", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIus_Items(), this.getIu(), null, "items", null, 0, -1, Ius.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(marketplaceEClass, Marketplace.class, "Marketplace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMarketplace_Node(), this.getNode(), null, "node", null, 0, 1, Marketplace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMarketplace_Catalogs(), this.getCatalogs(), null, "catalogs", null, 0, 1, Marketplace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMarketplace_Market(), this.getMarket(), null, "market", null, 0, -1, Marketplace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMarketplace_Featured(), this.getFeatured(), null, "featured", null, 0, 1, Marketplace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(categoriesEClass, Categories.class, "Categories", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCategories_Items(), this.getCategory(), null, "items", null, 0, -1, Categories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tagsEClass, Tags.class, "Tags", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTags_Items(), this.getTag(), null, "items", null, 0, -1, Tags.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(catalogsEClass, Catalogs.class, "Catalogs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCatalogs_Items(), this.getCatalog(), null, "items", null, 0, -1, Catalogs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(catalogEClass, Catalog.class, "Catalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCatalog_Id(), ecorePackage.getEString(), "id", null, 0, 1, Catalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCatalog_Title(), ecorePackage.getEString(), "title", null, 0, 1, Catalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCatalog_Url(), ecorePackage.getEString(), "url", null, 0, 1, Catalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCatalog_SelfContained(), ecorePackage.getEString(), "selfContained", null, 0, 1, Catalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCatalog_Icon(), ecorePackage.getEString(), "icon", null, 0, 1, Catalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCatalog_Description(), ecorePackage.getEString(), "description", null, 0, 1, Catalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCatalog_DependenciesRepository(), ecorePackage.getEString(), "dependenciesRepository", null, 0, 1, Catalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCatalog_Wizard(), this.getWizard(), null, "wizard", null, 1, 1, Catalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wizardEClass, Wizard.class, "Wizard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWizard_Title(), ecorePackage.getEString(), "title", null, 0, 1, Wizard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWizard_Icon(), ecorePackage.getEString(), "icon", null, 0, 1, Wizard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWizard_Searchtab(), this.getSearchTab(), null, "searchtab", null, 1, 1, Wizard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWizard_Populartab(), this.getPopularTab(), null, "populartab", null, 1, 1, Wizard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWizard_Recenttab(), this.getRecentTab(), null, "recenttab", null, 1, 1, Wizard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWizard_News(), this.getNews(), null, "news", null, 1, 1, Wizard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(searchTabEClass, SearchTab.class, "SearchTab", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSearchTab_Enabled(), ecorePackage.getEIntegerObject(), "enabled", null, 1, 1, SearchTab.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSearchTab_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 1, -1, SearchTab.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(popularTabEClass, PopularTab.class, "PopularTab", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPopularTab_Enabled(), ecorePackage.getEIntegerObject(), "enabled", null, 1, 1, PopularTab.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPopularTab_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 1, -1, PopularTab.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recentTabEClass, RecentTab.class, "RecentTab", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRecentTab_Enabled(), ecorePackage.getEIntegerObject(), "enabled", null, 1, 1, RecentTab.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRecentTab_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 1, -1, RecentTab.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newsEClass, News.class, "News", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNews_Shorttitle(), ecorePackage.getEString(), "shorttitle", null, 1, 1, News.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNews_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 1, -1, News.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNews_Timestamp(), ecorePackage.getELongObject(), "timestamp", null, 0, 1, News.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(marketEClass, Market.class, "Market", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMarket_Name(), ecorePackage.getEString(), "name", null, 0, 1, Market.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMarket_Id(), ecorePackage.getELong(), "id", null, 0, 1, Market.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMarket_Url(), ecorePackage.getEString(), "url", null, 0, 1, Market.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMarket_Category(), this.getCategory(), null, "category", null, 1, -1, Market.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featuredEClass, Featured.class, "Featured", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeatured_Count(), ecorePackage.getEIntegerObject(), "count", "0", 0, 1, Featured.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeatured_Nodes(), this.getNode(), null, "nodes", null, 0, -1, Featured.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";	
		addAnnotation
		  (nodeEClass, 
		   source, 
		   new String[] {
			 "name", "node"
		   });	
		addAnnotation
		  (getNode_Type(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });	
		addAnnotation
		  (getNode_Owner(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });	
		addAnnotation
		  (getNode_Favorited(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });	
		addAnnotation
		  (getNode_Installstotal(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });	
		addAnnotation
		  (getNode_Installsrecent(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });	
		addAnnotation
		  (getNode_Shortdescription(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });	
		addAnnotation
		  (getNode_Body(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });	
		addAnnotation
		  (getNode_Created(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });	
		addAnnotation
		  (getNode_Changed(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });	
		addAnnotation
		  (getNode_Foundationmember(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });	
		addAnnotation
		  (getNode_Homepageurl(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });	
		addAnnotation
		  (getNode_Image(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });	
		addAnnotation
		  (getNode_License(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });	
		addAnnotation
		  (getNode_Companyname(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });	
		addAnnotation
		  (getNode_Status(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });	
		addAnnotation
		  (getNode_Supporturl(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });	
		addAnnotation
		  (getNode_Version(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });	
		addAnnotation
		  (getNode_Eclipseversion(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });	
		addAnnotation
		  (getNode_Updateurl(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });	
		addAnnotation
		  (getNode_Ius(), 
		   source, 
		   new String[] {
			 "name", "ius"
		   });	
		addAnnotation
		  (getNode_Platforms(), 
		   source, 
		   new String[] {
			 "name", "platforms"
		   });	
		addAnnotation
		  (getNode_Screenshot(), 
		   source, 
		   new String[] {
			 "name", "platforms"
		   });	
		addAnnotation
		  (categoryEClass, 
		   source, 
		   new String[] {
			 "name", "category"
		   });	
		addAnnotation
		  (tagEClass, 
		   source, 
		   new String[] {
			 "name", "tag"
		   });	
		addAnnotation
		  (iuEClass, 
		   source, 
		   new String[] {
			 "kind", "mixed"
		   });	
		addAnnotation
		  (getIu_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });	
		addAnnotation
		  (platformEClass, 
		   source, 
		   new String[] {
			 "kind", "mixed",
			 "name", "platform"
		   });	
		addAnnotation
		  (getPlatform_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });	
		addAnnotation
		  (getPlatforms_Items(), 
		   source, 
		   new String[] {
			 "name", "platform"
		   });	
		addAnnotation
		  (getIus_Items(), 
		   source, 
		   new String[] {
			 "name", "iu"
		   });	
		addAnnotation
		  (marketplaceEClass, 
		   source, 
		   new String[] {
			 "name", "marketplace"
		   });	
		addAnnotation
		  (getMarketplace_Market(), 
		   source, 
		   new String[] {
			 "name", "market"
		   });	
		addAnnotation
		  (getCategories_Items(), 
		   source, 
		   new String[] {
			 "name", "category"
		   });	
		addAnnotation
		  (getTags_Items(), 
		   source, 
		   new String[] {
			 "name", "tag"
		   });	
		addAnnotation
		  (getCatalogs_Items(), 
		   source, 
		   new String[] {
			 "name", "catalog"
		   });	
		addAnnotation
		  (getCatalog_Description(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });	
		addAnnotation
		  (getCatalog_DependenciesRepository(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });	
		addAnnotation
		  (getWizard_Icon(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });	
		addAnnotation
		  (searchTabEClass, 
		   source, 
		   new String[] {
			 "kind", "mixed"
		   });	
		addAnnotation
		  (getSearchTab_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });	
		addAnnotation
		  (popularTabEClass, 
		   source, 
		   new String[] {
			 "kind", "mixed"
		   });	
		addAnnotation
		  (getPopularTab_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });	
		addAnnotation
		  (recentTabEClass, 
		   source, 
		   new String[] {
			 "kind", "mixed"
		   });	
		addAnnotation
		  (getRecentTab_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });	
		addAnnotation
		  (newsEClass, 
		   source, 
		   new String[] {
			 "kind", "mixed"
		   });	
		addAnnotation
		  (getNews_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });	
		addAnnotation
		  (getMarket_Category(), 
		   source, 
		   new String[] {
			 "name", "category"
		   });	
		addAnnotation
		  (getFeatured_Nodes(), 
		   source, 
		   new String[] {
			 "name", "node"
		   });
	}

} //MarketplacePackageImpl
