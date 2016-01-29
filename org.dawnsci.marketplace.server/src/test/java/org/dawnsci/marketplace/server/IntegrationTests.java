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
 * Basic tests exercising the REST API as described in
 * https://wiki.eclipse.org/Marketplace/REST. The actual implementation at
 * http://marketplace.eclipse.org is a little bit different so data obtained
 * from that instance is used to form basis for the test data.
 * <p>
 * In practice data from API calls to the reference implementation is
 * deserialized, passed trough the marketplace server and serialized into a form
 * expected by the marketplace client. Ideally the marketplace client code
 * should be used to do the actual validation.
 * </p>
 * 
 * @author Torkild U. Resheim
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfiguration.class)
@WebIntegrationTest({ "server.port=0", "management.port=0" })
@ActiveProfiles("test")
public class IntegrationTests {

	@Value("${local.server.port}")
	private int port;

	private RestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void testGetCatalogs() {
		try {
			ResponseEntity<String> entity = this.restTemplate
					.getForEntity("http://localhost:" + this.port + "/mpc/catalogs/api/p", String.class);
			assertEquals(HttpStatus.OK, entity.getStatusCode());
			System.out.println(entity.getBody());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetFeatured() {
		try {
			ResponseEntity<String> entity = this.restTemplate
					.getForEntity("http://localhost:" + this.port + "/mpc/featured/api/p", String.class);
			assertEquals(HttpStatus.OK, entity.getStatusCode());
			System.out.println(entity.getBody());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetMarkets() {
		try {
			ResponseEntity<String> entity = this.restTemplate
					.getForEntity("http://localhost:" + this.port + "/mpc/api/p", String.class);
			assertEquals(HttpStatus.OK, entity.getStatusCode());
			System.out.println(entity.getBody());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetNode() {
		try {
			ResponseEntity<String> entity = this.restTemplate
					.getForEntity("http://localhost:" + this.port + "/mpc/node/364668/api/p", String.class);
			assertEquals(HttpStatus.OK, entity.getStatusCode());
			System.out.println(entity.getBody());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetContent() {
		try {
			ResponseEntity<String> entity = this.restTemplate
					.getForEntity("http://localhost:" + this.port + "/mpc/content/364668/api/p", String.class);
			assertEquals(HttpStatus.OK, entity.getStatusCode());
			System.out.println(entity.getBody());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
