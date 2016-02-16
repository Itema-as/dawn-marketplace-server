When the marketplace server is first started it will initialize with some data. All of which can be found in the sibling folders of the *org.dawnsci-marketplace-server* archive file.

## Serving Static content

Static content, such as the welcome text and user guide can be placed in the "pages" folder. These files must be written Markdown format. There is one predefined file named "welcome.md". This holds the text that is shown at the top on the front page.

Links can be written as for example `[user guide](/pages/user_guide.md)`, which will link to Markdown file that will be rendered as HTML. It is also possible to link to other resources:

* `/pages/eclipse.png` an image file.
* `/content/123` the solution with the identifier "123"
* `/files/123/screenshot.png` a file belonging to the solution.

## Usage

### Starting the server

When doing development on this code, you should start the server from within Eclipse. That will allow you to do normal debugging. Make sure the [Spring tool suite](https://marketplace.eclipse.org/content/spring-ide) is installed and launch the __org.dawnsci.marketplace.server__ project as a _Spring Boot App_

When running the standalone server you need to start it from the command line. E.g. `java -jar org.dawnsci.marketplace.server-1.0-SNAPSHOT.war`

### Creating initial data set

If the server is started with the `--init` argument it will create a number of items for testing. A folder named _solutions_ will be created next to the *.jar file, or in the project root when running from the IDE. This contains all file resources for the sample solutions. These can be accessed from a browser using the syntax `http://localhost:8080/files/{solution-id}/{file-name}`. Another folder called _pages_ will be created with some sample static documents.
