/**
 */
package org.dawnsci.marketplace.impl;

import org.dawnsci.marketplace.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MarketplaceFactoryImpl extends EFactoryImpl implements MarketplaceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MarketplaceFactory init() {
		try {
			MarketplaceFactory theMarketplaceFactory = (MarketplaceFactory)EPackage.Registry.INSTANCE.getEFactory(MarketplacePackage.eNS_URI);
			if (theMarketplaceFactory != null) {
				return theMarketplaceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MarketplaceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarketplaceFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MarketplacePackage.NODE: return createNode();
			case MarketplacePackage.CATEGORY: return createCategory();
			case MarketplacePackage.TAG: return createTag();
			case MarketplacePackage.IU: return createIu();
			case MarketplacePackage.PLATFORM: return createPlatform();
			case MarketplacePackage.PLATFORMS: return createPlatforms();
			case MarketplacePackage.IUS: return createIus();
			case MarketplacePackage.MARKETPLACE: return createMarketplace();
			case MarketplacePackage.CATEGORIES: return createCategories();
			case MarketplacePackage.TAGS: return createTags();
			case MarketplacePackage.CATALOGS: return createCatalogs();
			case MarketplacePackage.CATALOG: return createCatalog();
			case MarketplacePackage.WIZARD: return createWizard();
			case MarketplacePackage.SEARCH_TAB: return createSearchTab();
			case MarketplacePackage.POPULAR_TAB: return createPopularTab();
			case MarketplacePackage.RECENT_TAB: return createRecentTab();
			case MarketplacePackage.NEWS: return createNews();
			case MarketplacePackage.MARKET: return createMarket();
			case MarketplacePackage.FEATURED: return createFeatured();
			case MarketplacePackage.SEARCH: return createSearch();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node createNode() {
		NodeImpl node = new NodeImpl();
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Category createCategory() {
		CategoryImpl category = new CategoryImpl();
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tag createTag() {
		TagImpl tag = new TagImpl();
		return tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iu createIu() {
		IuImpl iu = new IuImpl();
		return iu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Platform createPlatform() {
		PlatformImpl platform = new PlatformImpl();
		return platform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Platforms createPlatforms() {
		PlatformsImpl platforms = new PlatformsImpl();
		return platforms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ius createIus() {
		IusImpl ius = new IusImpl();
		return ius;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Marketplace createMarketplace() {
		MarketplaceImpl marketplace = new MarketplaceImpl();
		return marketplace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Categories createCategories() {
		CategoriesImpl categories = new CategoriesImpl();
		return categories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tags createTags() {
		TagsImpl tags = new TagsImpl();
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Catalogs createCatalogs() {
		CatalogsImpl catalogs = new CatalogsImpl();
		return catalogs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Catalog createCatalog() {
		CatalogImpl catalog = new CatalogImpl();
		return catalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Wizard createWizard() {
		WizardImpl wizard = new WizardImpl();
		return wizard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchTab createSearchTab() {
		SearchTabImpl searchTab = new SearchTabImpl();
		return searchTab;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PopularTab createPopularTab() {
		PopularTabImpl popularTab = new PopularTabImpl();
		return popularTab;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecentTab createRecentTab() {
		RecentTabImpl recentTab = new RecentTabImpl();
		return recentTab;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public News createNews() {
		NewsImpl news = new NewsImpl();
		return news;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Market createMarket() {
		MarketImpl market = new MarketImpl();
		return market;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Featured createFeatured() {
		FeaturedImpl featured = new FeaturedImpl();
		return featured;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Search createSearch() {
		SearchImpl search = new SearchImpl();
		return search;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarketplacePackage getMarketplacePackage() {
		return (MarketplacePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MarketplacePackage getPackage() {
		return MarketplacePackage.eINSTANCE;
	}

} //MarketplaceFactoryImpl
