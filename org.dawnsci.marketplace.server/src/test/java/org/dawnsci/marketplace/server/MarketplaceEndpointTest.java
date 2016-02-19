/*****************************************************************************
 * Copyright (c) 2016 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Torkild U. Resheim - initial API and implementation
 ****************************************************************************/
package org.dawnsci.marketplace.server;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.dawnsci.marketplace.Catalog;
import org.dawnsci.marketplace.Featured;
import org.dawnsci.marketplace.Marketplace;
import org.dawnsci.marketplace.MarketplacePackage;
import org.dawnsci.marketplace.Recent;
import org.dawnsci.marketplace.Search;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Basic tests exercising the REST API.
 * 
 * @author Torkild U. Resheim
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfiguration.class)
@WebIntegrationTest({ "server.port=0", "management.port=0" })
@ActiveProfiles("test")
public class MarketplaceEndpointTest {

	@Value("${local.server.port}")
	private int port;

	private RestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void testGetCatalogs() throws Exception {
		ResponseEntity<String> entity = this.restTemplate
				.getForEntity("http://localhost:" + this.port + "/mpc/catalogs/api/p", String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		Marketplace m = loadSerialized(entity.getBody());
		// see that we have the catalog in place
		assertEquals(1, m.getCatalogs().getItems().size());
		Catalog catalog = m.getCatalogs().getItems().get(0);
		assertEquals("http://localhost:8080/mpc", catalog.getUrl());
	}

	@Test
	public void testGetFeatured() throws Exception {
		ResponseEntity<String> entity = this.restTemplate
				.getForEntity("http://localhost:" + this.port + "/mpc/featured/api/p", String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		Marketplace m = loadSerialized(entity.getBody());
		Featured featured = m.getFeatured();
		assertEquals(1,featured.getCount());
	}

	@Test
	public void testGetMarkets() {
		ResponseEntity<String> entity = this.restTemplate.getForEntity("http://localhost:" + this.port + "/mpc/api/p",
				String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

	@Test
	public void testGetNode() throws Exception {
		ResponseEntity<String> entity = this.restTemplate
				.getForEntity("http://localhost:" + this.port + "/mpc/node/364668/api/p", String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		// TODO: Test image, url and other depending on baseURL.
	}

	@Test
	public void testGetSolution() throws Exception {
		ResponseEntity<String> entity = this.restTemplate
				.getForEntity("http://localhost:" + this.port + "/mpc/content/1/api/p", String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		Marketplace m = loadSerialized(entity.getBody());
		assertEquals(1,m.getNode().getId());
	}

	@Test
	public void testGetSolution_NotFound() throws Exception {
		ResponseEntity<String> entity = this.restTemplate
				.getForEntity("http://localhost:" + this.port + "/mpc/content/1000/api/p", String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		Marketplace m = loadSerialized(entity.getBody());
		assertEquals(null,m.getNode());
		// TODO: encoding 
	}

	@Test
	public void testSearch() throws Exception {
		ResponseEntity<String> entity = this.restTemplate
				.getForEntity("http://localhost:" + this.port + "/mpc/api/p/search/apachesolr_search/Pellentesque", String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		Marketplace m = loadSerialized(entity.getBody());
		Search search = m.getSearch();
		assertEquals("pellentesque",search.getTerm());
		assertEquals("http://localhost:8080/search?term=pellentesque",search.getUrl());
		assertEquals(1,search.getCount());
		assertEquals(1,search.getNodes().get(0).getId());
	}

	@Test
	public void testRecent() throws Exception {
		ResponseEntity<String> entity = this.restTemplate
				.getForEntity("http://localhost:" + this.port + "/mpc/recent/api/p", String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		Marketplace m = loadSerialized(entity.getBody());
		Recent recent = m.getRecent();
		assertEquals(1,recent.getCount());
		assertEquals(2,recent.getNodes().get(0).getId());
	}

	private Marketplace loadSerialized(String xml) throws IOException {
		ResourceSet rs = new ResourceSetImpl();
		rs.getPackageRegistry().put(null, MarketplacePackage.eINSTANCE);
		Resource resource = rs.createResource(URI.createFileURI("data.xml"));
		InputStream is = new ByteArrayInputStream(xml.getBytes());
		resource.load(is, rs.getLoadOptions());
		return (Marketplace) resource.getContents().get(0);
	}

}
