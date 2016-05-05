# The DAWN Marketplace Server

Everything the server requires to start is contained within the `*.war`-file. In addition data is held in three different folders that all will be created when the server first starts.

* `database` - Holds the server's two databases. One for "solution" data with is serialized using Eclipse Teneo. The other is the system database for user accounts and such.
* `pages` - Static content in the form of Markdown formatted files and images.
* `solutions` - Solution data. Subfolders are created for each solution using it's identifier. Within these; images and screenshots are stored and an additional folder for the Equinox p2-repository.

## Usage

### Starting the server

When doing development on this code, you should start the server from within Eclipse. That will allow you to do normal debugging. Make sure the [Spring tool suite](https://marketplace.eclipse.org/content/spring-ide) is installed and launch the __org.dawnsci.marketplace.server__ project as a _Spring Boot App_

When running the standalone server you need to start it from the command line. E.g. `java -jar org.dawnsci.marketplace.server-1.0-SNAPSHOT.war`

If the following files are not in place, they will be created. The folder named _pages_ must contain:

* `welcome.md` - The welcome text.
* `marketplace-icon` - The marketplace icon
* `catalog.icon` - The catalog icon  

### Creating an initial data set

When starting the server a folder named _solutions_ will be created next to the *.jar file, or in the project root when running from the IDE. This contains all file resources for a sample solution, including one plug-in that can be installed.

The data that is loaded can be found in [src/main/resources/data](src/main/resources/data). A similar set is found in [src/test/resources/data](src/test/resources/data).

### Configuring the server

The server configuration is mainly done in a file named _application.yml_. If the [default values](src/main/resources/application.yml) must be overridden, this can be done by adding it as a sibling to the _*.war_ file and specify properties in the YAML format. Typical values include:

```YAML
marketplace:
	base-url: http://localhost:8080
	title: DAWN Plug-in Marketplace
	icon: http://localhost:8080/pages/marketplace-icon.png
	description: The DAWN Plug-in Marketplace
	wizard-title: DAWN Plug-in Catalog
	wizard-icon: http://localhost:8080/pages/catalog-icon.png
	featured:
		maximum: 3
		solutions: 1, 2, 3	
```

All configuration parameters can be controlled from the command line, for example `--marketplace.featured.solutions=1,10,12` will specify the list of featured solutions.

	  
There is a [separate set of properties used when testing](src/test/resources/application.yml).	  

#### Social integration

It is possible to sign in using a Twitter, Google or Github account. For testing purposes one application of each type has been created and configured on the server.
	
Since the Twitter application registration requires a fully qualified DNS you must in addition add an entry to `/etc/hosts` when testing:

	127.0.0.1       localhost.com
	
See [the server configuration](src/main/resources/application.yml) for OAuth secrets and identifiers.	

## The REST API

The REST API is an important part for communicating with the _marketplace client_ that comes as a part of Eclipse. Not all of it is currently implemented, but it can be exercised from within Eclipse in a way that is useful.

Note that this implementation of the server currently prefix all REST calls with "mpc". So for instance getting details of a particular product will look like this: `http://localhost:8080/mpc/node/123/api/p`.

### Supported REST calls

The Eclipse reference implementation provisional API will be identified by /api/p at the end of most urls. Those that are checked have been fully implemented.

- [x]	`/api/p` - Returns Markets + Categories
- [x] `/catalogs/api/p` - Returns a listing of all catalogs that are browsable with the MPC.
- [x]	`/node/%/api/p` OR `/content/%/api/p` - Returns a single listing's detail
- [ ]	`/taxonomy/term/%/api/p` - Returns a category listing of results
- [x]	`/featured/api/p` - Returns a server-defined number of featured results.
- [x]   `/recent/api/p` - Returns a server-defined number of recent updates
- [ ]	`/favorites/top/api/p` - Returns a server-defined number of top favorites
- [ ]	`/popular/top/api/p` - Returns a server-defined number of most active results
- [ ]	`/related/api/p` - Returns a server-defined number of recommendations based on a list of nodes provided as query parameter
- [ ]	`/news/api/p` - Returns the news configuration details (news location/title...).

There is one exception to adding /api/p at the end and that is for search results.
- [x]	`/api/p/search/apachesolr_search/[query]?page=[]&filters=[]` - Returns search result from the Solr Search DB.


## Serving Static content

Static content, such as the welcome text and user guide should be placed in the _pages_ folder. These files must be written in the Markdown format. Links can be written as for example `[user guide](/pages/user_guide.md)`, which will link to a Markdown file that will be rendered as HTML. It is also possible to link to other resources:

* `/pages/eclipse.png` an image file.
* `/content/123` the solution with the identifier "123"
* `/files/123/screenshot.png` a file belonging to the solution.
