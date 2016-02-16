Everything the server requires to start is contained within the `*.war`-file. In addition data is held in three different folders that all will be created when the server first starts.

* `database` - The server's two databases. One for "solution" data with is serialized using Eclipse Teneo. The other is the system database for user accounts and such.
* `pages` - Static content in the form of Markdown formatted files and images.
* `solutions` - Solution data. Subfolders are created for each solution using it's identifier. Within these images and screenshots are stored and an additional folder for the Equinox p2-repository.

## Serving Static content

Static content, such as the welcome text and user guide can be placed in the "pages" folder. These files must be written Markdown format. There is one predefined file named "welcome.md". This holds the text that is shown at the top on the front page. It will be automatically created if the server has been instructed to create an initial data set. See below for details.

Links can be written as for example `[user guide](/pages/user_guide.md)`, which will link to a Markdown file that will be rendered as HTML. It is also possible to link to other resources:

* `/pages/eclipse.png` an image file.
* `/content/123` the solution with the identifier "123"
* `/files/123/screenshot.png` a file belonging to the solution.

## Usage

### Starting the server

When doing development on this code, you should start the server from within Eclipse. That will allow you to do normal debugging. Make sure the [Spring tool suite](https://marketplace.eclipse.org/content/spring-ide) is installed and launch the __org.dawnsci.marketplace.server__ project as a _Spring Boot App_

When running the standalone server you need to start it from the command line. E.g. `java -jar org.dawnsci.marketplace.server-1.0-SNAPSHOT.war`

### Creating an initial data set

If the server is started with the `--init` argument it will create a number of items for testing. A folder named _solutions_ will be created next to the *.jar file, or in the project root when running from the IDE. This contains all file resources for the sample solutions, including one plug-in that can be installed. Another folder called _pages_ will be created with some sample static documents.

### Twitter integration

It is possible to sign in using a Twitter account. However an application must first be created. One exists already for testing. In order to use it, the server must be started with some additional parameters.

	-Dtwitter.consumerKey=XHYkM7qaRCEpgAcS7OesQfSuC 
	-Dtwitter.consumerSecret=WiWkeFOCbhPkCqvGEMVdY01yMTZ12tZys3RuJQYmOGSkuUPSeE
	
Since the Twitter application registration requires a fully qualified DNS you must in addition add an entry to `/etc/hosts`:

	127.0.0.1       localhost.com

## The REST API

The REST API is an important part for communicating with the _marketplace client_ that comes as a part of Eclipse. Not all of it is currently implemented, but it can be exercised from within Eclipse in a way that is useful.

Note that this implementation of the server currently prefix all REST calls with "mpc". So for instance getting details of a particular product will look like this: `http://localhost:8080/mpc/node/123/api/p`.

### From the Eclipse Marketplace API documentation

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
- [x]	`/api/p/search/apachesolr_search/[query]?page=[]&filters=[]` - Returns search result from the Solr Search DB.

