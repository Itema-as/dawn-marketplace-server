# DAWN Eclipse Marketplace Server

An open source Eclipse marketplace server based on the [marketplace client REST API](https://wiki.eclipse.org/Marketplace/REST).

This server is built on [Spring Boot](http://projects.spring.io/spring-boot/), Eclipse EMF, HyperSQL DB, Hibernate and Teneo. It is self-contained, so there is no need to install anything for deployment except for Java 8. While it is created for serving [DAWN](http://www.dawnsci.org) plug-ins, it can be used for distributing any Eclipse plug-ins as it is compatible with the Eclipse Marketplace client.

Note that the server is not yet complete and can not be used in production.

## Supported API calls
This provisional API will be identified by /api/p at the end of most urls.
- [x]	`/api/p` - Returns Markets + Categories
- [x] `/catalogs/api/p` - Returns a listing of all catalogs that are browsable with the MPC.
- [x]	`/node/%/api/p` OR `/content/%/api/p` - Returns a single listing's detail
- [ ]	`/taxonomy/term/%/api/p` - Returns a category listing of results
- [x]	`/featured/api/p` - Returns a server-defined number of featured results.
- [ ] `/recent/api/p` - Returns a server-defined number of recent updates
- [ ]	`/favorites/top/api/p` - Returns a server-defined number of top favorites
- [ ]	`/popular/top/api/p` - Returns a server-defined number of most active results
- [ ]	`/related/api/p` - Returns a server-defined number of recommendations based on a list of nodes provided as query parameter
- [ ]	`/news/api/p` - Returns the news configuration details (news location/title...).

There is one exception to adding /api/p at the end and that is for search results.
- [ ]	`/api/p/search/apachesolr_search/[query]?page=[]&filters=[]` - Returns search result from the Solr Search DB.

## Usage

### Starting the server

When doing development on this code, you should start the server from within Eclipse. That will allow you to do normal debugging. Make sure the [Spring tool suite](https://marketplace.eclipse.org/content/spring-ide) is installed and launch the __org.dawnsci.marketplace.server__ project as a _Spring Boot App_

When running the standalone server you need to start it from the command line. E.g. `java -jar org.dawnsci.marketplace.server-1.0-SNAPSHOT.war`

### Using the marketplace client

Start Eclipse with required parameters. E.g. `/Eclipse.app/Contents/MacOS/eclipse -vmargs -Dorg.eclipse.epp.internal.mpc.core.service.DefaultMarketplaceService.url=http://localhost:8080/mpc -Dorg.eclipse.epp.internal.mpc.core.service.DefaultCatalogService.url=http://localhost:8080/mpc`
