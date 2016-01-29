/**
 */
package org.dawnsci.marketplace.util;

import org.dawnsci.marketplace.*;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.dawnsci.marketplace.MarketplacePackage
 * @generated
 */
public class MarketplaceAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MarketplacePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarketplaceAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MarketplacePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MarketplaceSwitch<Adapter> modelSwitch =
		new MarketplaceSwitch<Adapter>() {
			@Override
			public Adapter caseNode(Node object) {
				return createNodeAdapter();
			}
			@Override
			public Adapter caseCategory(Category object) {
				return createCategoryAdapter();
			}
			@Override
			public Adapter caseTag(Tag object) {
				return createTagAdapter();
			}
			@Override
			public Adapter caseIu(Iu object) {
				return createIuAdapter();
			}
			@Override
			public Adapter casePlatform(Platform object) {
				return createPlatformAdapter();
			}
			@Override
			public Adapter casePlatforms(Platforms object) {
				return createPlatformsAdapter();
			}
			@Override
			public Adapter caseIus(Ius object) {
				return createIusAdapter();
			}
			@Override
			public Adapter caseMarketplace(Marketplace object) {
				return createMarketplaceAdapter();
			}
			@Override
			public Adapter caseCategories(Categories object) {
				return createCategoriesAdapter();
			}
			@Override
			public Adapter caseTags(Tags object) {
				return createTagsAdapter();
			}
			@Override
			public Adapter caseCatalogs(Catalogs object) {
				return createCatalogsAdapter();
			}
			@Override
			public Adapter caseCatalog(Catalog object) {
				return createCatalogAdapter();
			}
			@Override
			public Adapter caseWizard(Wizard object) {
				return createWizardAdapter();
			}
			@Override
			public Adapter caseSearchTab(SearchTab object) {
				return createSearchTabAdapter();
			}
			@Override
			public Adapter casePopularTab(PopularTab object) {
				return createPopularTabAdapter();
			}
			@Override
			public Adapter caseRecentTab(RecentTab object) {
				return createRecentTabAdapter();
			}
			@Override
			public Adapter caseNews(News object) {
				return createNewsAdapter();
			}
			@Override
			public Adapter caseMarket(Market object) {
				return createMarketAdapter();
			}
			@Override
			public Adapter caseFeatured(Featured object) {
				return createFeaturedAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.dawnsci.marketplace.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dawnsci.marketplace.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dawnsci.marketplace.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dawnsci.marketplace.Category
	 * @generated
	 */
	public Adapter createCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dawnsci.marketplace.Tag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dawnsci.marketplace.Tag
	 * @generated
	 */
	public Adapter createTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dawnsci.marketplace.Iu <em>Iu</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dawnsci.marketplace.Iu
	 * @generated
	 */
	public Adapter createIuAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dawnsci.marketplace.Platform <em>Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dawnsci.marketplace.Platform
	 * @generated
	 */
	public Adapter createPlatformAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dawnsci.marketplace.Platforms <em>Platforms</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dawnsci.marketplace.Platforms
	 * @generated
	 */
	public Adapter createPlatformsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dawnsci.marketplace.Ius <em>Ius</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dawnsci.marketplace.Ius
	 * @generated
	 */
	public Adapter createIusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dawnsci.marketplace.Marketplace <em>Marketplace</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dawnsci.marketplace.Marketplace
	 * @generated
	 */
	public Adapter createMarketplaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dawnsci.marketplace.Categories <em>Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dawnsci.marketplace.Categories
	 * @generated
	 */
	public Adapter createCategoriesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dawnsci.marketplace.Tags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dawnsci.marketplace.Tags
	 * @generated
	 */
	public Adapter createTagsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dawnsci.marketplace.Catalogs <em>Catalogs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dawnsci.marketplace.Catalogs
	 * @generated
	 */
	public Adapter createCatalogsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dawnsci.marketplace.Catalog <em>Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dawnsci.marketplace.Catalog
	 * @generated
	 */
	public Adapter createCatalogAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dawnsci.marketplace.Wizard <em>Wizard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dawnsci.marketplace.Wizard
	 * @generated
	 */
	public Adapter createWizardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dawnsci.marketplace.SearchTab <em>Search Tab</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dawnsci.marketplace.SearchTab
	 * @generated
	 */
	public Adapter createSearchTabAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dawnsci.marketplace.PopularTab <em>Popular Tab</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dawnsci.marketplace.PopularTab
	 * @generated
	 */
	public Adapter createPopularTabAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dawnsci.marketplace.RecentTab <em>Recent Tab</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dawnsci.marketplace.RecentTab
	 * @generated
	 */
	public Adapter createRecentTabAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dawnsci.marketplace.News <em>News</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dawnsci.marketplace.News
	 * @generated
	 */
	public Adapter createNewsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dawnsci.marketplace.Market <em>Market</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dawnsci.marketplace.Market
	 * @generated
	 */
	public Adapter createMarketAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dawnsci.marketplace.Featured <em>Featured</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dawnsci.marketplace.Featured
	 * @generated
	 */
	public Adapter createFeaturedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //MarketplaceAdapterFactory
