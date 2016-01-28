# eclipse-marketplace-server

An open source Eclipse marketplace server based on the [marketplace client REST API](https://wiki.eclipse.org/Marketplace/REST).

## Supported API calls
This provisional API will be identified by /api/p at the end of most urls.
- [x]	`/api/p` - Returns Markets + Categories
- [x] `/catalogs/api/p` - Returns a listing of all catalogs that are browsable with the MPC.
- [x]	`/node/%/api/p` OR `/content/%/api/p` - Returns a single listing's detail
- [ ]	`/taxonomy/term/%/api/p` - Returns a category listing of results
- [ ]	`/featured/api/p` - Returns a server-defined number of featured results.
- [ ] `/recent/api/p` - Returns a server-defined number of recent updates
- [ ]	`/favorites/top/api/p` - Returns a server-defined number of top favorites
- [ ]	`/popular/top/api/p` - Returns a server-defined number of most active results
- [ ]	`/related/api/p` - Returns a server-defined number of recommendations based on a list of nodes provided as query parameter
- [ ]	`/news/api/p` - Returns the news configuration details (news location/title...).

There is one exception to adding /api/p at the end and that is for search results.
- [ ]	`/api/p/search/apachesolr_search/[query]?page=[]&filters=[]` - Returns search result from the Solr Search DB.

## Usage

In order to test a development version of the marketplace server, one can do the following (with Spring tools installed):

1. Launch the org.dawnsci.marketplace.server as a _Spring Boot App_
2. Start Eclipse with required parameters. E.g. `/Eclipse.app/Contents/MacOS/eclipse -vmargs -Dorg.eclipse.epp.internal.mpc.core.service.DefaultMarketplaceService.url=http://localhost:8080/mpc -Dorg.eclipse.epp.internal.mpc.core.service.DefaultCatalogService.url=http://localhost:8080/mpc`

