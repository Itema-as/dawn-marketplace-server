# DAWN Marketplace Server [![Build Status](https://travis-ci.org/Itema-as/eclipse-marketplace-server.svg?branch=master)](https://travis-ci.org/Itema-as/eclipse-marketplace-server)

An open source Eclipse marketplace server based on the [marketplace client REST API](https://wiki.eclipse.org/Marketplace/REST).

This server is built on [Spring Boot](http://projects.spring.io/spring-boot/), [Eclipse EMF](https://eclipse.org/modeling/emf/), [HyperSQL DB](http://hsqldb.org), [Hibernate](http://hibernate.org) and [Eclipse Teneo](https://wiki.eclipse.org/Teneo). It is self-contained, so there is no need to install anything for deployment except for Java 8. While it is created for serving [DAWN](http://www.dawnsci.org) plug-ins, it can be used for distributing any Eclipse plug-ins as it is compatible with the [Eclipse Marketplace client](https://www.eclipse.org/mpc/).

## Usage

### Starting the server

When doing development on this code, you should start the server from within Eclipse. That will allow you to do normal debugging. Make sure the [Spring tool suite](https://marketplace.eclipse.org/content/spring-ide) is installed and launch the __org.dawnsci.marketplace.server__ project as a _Spring Boot App_. Add `--init` to create an initial data set for testing.

When running the standalone server you need to start it from the command line. E.g. `java -jar org.dawnsci.marketplace.server-1.0-SNAPSHOT.war --init`.

See the [notes for the server](eclipse-marketplace-server/org.dawnsci.marketplace.server/README.md) for more details.

### Using the marketplace client

Start Eclipse with required parameters for connecting to the server, e.g. `/Eclipse.app/Contents/MacOS/eclipse -vmargs -Dorg.eclipse.epp.internal.mpc.core.service.DefaultMarketplaceService.url=http://localhost:8080/mpc -Dorg.eclipse.epp.internal.mpc.core.service.DefaultCatalogService.url=http://localhost:8080/mpc`

Replace http://localhost:8080 with whatever you have the server running on.

## Building

The server is built using Maven so it is sufficient to execute `mvn clean package` from the project root.
