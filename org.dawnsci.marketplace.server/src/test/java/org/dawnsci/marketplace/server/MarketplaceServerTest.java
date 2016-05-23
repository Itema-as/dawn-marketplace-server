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
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.dawnsci.marketplace.Catalog;
import org.dawnsci.marketplace.Featured;
import org.dawnsci.marketplace.Marketplace;
import org.dawnsci.marketplace.MarketplaceFactory;
import org.dawnsci.marketplace.MarketplacePackage;
import org.dawnsci.marketplace.Node;
import org.dawnsci.marketplace.Search;
import org.dawnsci.marketplace.Tag;
import org.dawnsci.marketplace.core.MarketplaceSerializer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

// Some error codes that can be expected:
// 400 Bad Request
// 401 Unauthorized
// 403 Forbidden
// 404 Not Found
// 405 Method Not Allowed
// 302 Found, redirected

/**
 * Basic tests exercising the REST API along with the Web UI.
 *
 * @author Torkild U. Resheim
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { TestConfiguration.class })
@WebIntegrationTest({ "server.port=0", "management.port=0" })
@Transactional
@ActiveProfiles("test")
public class MarketplaceServerTest {

	@Value("${local.server.port}")
	private int port;

	private RestTemplate restTemplate = new TestRestTemplate();

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mocMvc;

	private class SolutionUploadSession {
		private HttpSession http;
		private Node node;
	}

    @Before
	public void setup(){
		this.mocMvc = MockMvcBuilders
				.webAppContextSetup(this.wac)
				.apply(springSecurity())
				.build();
	}

	private Marketplace loadSerializedMarketplace(String xml) throws IOException {
		ResourceSet rs = new ResourceSetImpl();
		rs.getPackageRegistry().put(null, MarketplacePackage.eINSTANCE);
		Resource resource = rs.createResource(URI.createFileURI("data.xml"));
		InputStream is = new ByteArrayInputStream(xml.getBytes());
		resource.load(is, rs.getLoadOptions());
		return (Marketplace) resource.getContents().get(0);
	}

	private Node loadSerializedNode(String xml) throws IOException {
		ResourceSet rs = new ResourceSetImpl();
		rs.getPackageRegistry().put(null, MarketplacePackage.eINSTANCE);
		Resource resource = rs.createResource(URI.createFileURI("data.xml"));
		InputStream is = new ByteArrayInputStream(xml.getBytes());
		resource.load(is, rs.getLoadOptions());
		return (Node) resource.getContents().get(0);
	}
	//================================================================================================================
	// REST tests
	//================================================================================================================
	@Test
	public void testRestGetCatalogs() throws Exception {
		ResponseEntity<String> entity = this.restTemplate
				.getForEntity("http://localhost:" + this.port + "/mpc/catalogs/api/p", String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		Marketplace m = loadSerializedMarketplace(entity.getBody());
		// see that we have the catalog in place
		Catalog catalog = m.getCatalogs().getItems().get(0);
		assertEquals("http://localhost:8080/mpc", catalog.getUrl());
	}

	@Test
	public void testRestGetFeatured() throws Exception {
		ResponseEntity<String> entity = this.restTemplate
				.getForEntity("http://localhost:" + this.port + "/mpc/featured/api/p", String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		Marketplace m = loadSerializedMarketplace(entity.getBody());
		Featured featured = m.getFeatured();
		assertEquals(2,featured.getCount());
	}

	@Test
	public void testRestGetMarkets() {
		ResponseEntity<String> entity = this.restTemplate.getForEntity("http://localhost:" + this.port + "/mpc/api/p",
				String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

	@Test
	public void testRestGetNode() throws Exception {
		ResponseEntity<String> entity = this.restTemplate
				.getForEntity("http://localhost:" + this.port + "/mpc/node/364668/api/p", String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

	@Test
	public void testRestGetSolution() throws Exception {
		ResponseEntity<String> entity = this.restTemplate
				.getForEntity("http://localhost:" + this.port + "/mpc/content/1/api/p", String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		Marketplace m = loadSerializedMarketplace(entity.getBody());
		assertEquals(Long.valueOf(1),m.getNode().getId());
	}

	@Test
	public void testRestGetSolution_NotFound() throws Exception {
		ResponseEntity<String> entity = this.restTemplate
				.getForEntity("http://localhost:" + this.port + "/mpc/content/1000/api/p", String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		Marketplace m = loadSerializedMarketplace(entity.getBody());
		assertEquals(null,m.getNode());
	}

	@Test
	public void testRestSearch() throws Exception {
		ResponseEntity<String> entity = this.restTemplate
				.getForEntity("http://localhost:" + this.port + "/mpc/api/p/search/apachesolr_search/Another", String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		Marketplace m = loadSerializedMarketplace(entity.getBody());
		Search search = m.getSearch();
		assertEquals("another",search.getTerm());
		assertEquals("http://localhost:8080/search?term=another",search.getUrl());
		assertEquals(1,search.getCount());
		assertEquals(Long.valueOf(2),search.getNodes().get(0).getId());
	}

	// XXX: Does not work because of residue data
	//	@Test
	//	public void testRestGetRecent() throws Exception {
	//		ResponseEntity<String> entity = this.restTemplate
	//				.getForEntity("http://localhost:" + this.port + "/mpc/recent/api/p", String.class);
	//		assertEquals(HttpStatus.OK, entity.getStatusCode());
	//		Marketplace m = loadSerializedMarketplace(entity.getBody());
	//		Recent recent = m.getRecent();
	//		assertEquals(2,recent.getCount());
	//		assertEquals(Long.valueOf(2),recent.getNodes().get(0).getId());
	//	}


	private String SOLUTION_XML = "<?xml version=\"1.0\" encoding=\"ASCII\"?>" +
			"<org.dawnsci:node xmlns:org.dawnsci=\"http://org.dawnsci/marketplace\" name=\"testsolution\">" +
			"  <tags>" +
			"    <tag name=\"interesting\"/>" +
			"    <tag name=\"cool\"/>" +
			"    <tag name=\"workspace\"/>" +
			"  </tags>" +
			"  <owner>Balle Clorin</owner>" +
			"  <shortdescription>Short description.</shortdescription>" +
			"  <body>Long description</body>" +
			"  <license>EPL</license>" +
			"  <companyname>Diamond Light Source Ltd.</companyname>" +
			"  <status>Alpha</status>" +
			"  <screenshot>/Users/auser/Desktop/Screenshots/screenshot.png</screenshot>" +
			"</org.dawnsci:node>\n";


	/**
	 * This method should only be used for creating and uploading a solution
	 * through the REST API for further exercising of the same API.
	 */
	public SolutionUploadSession signInAndUploadSolution() throws Exception {
		SolutionUploadSession session = new SolutionUploadSession();
		// log in the user and keep the session, we need it for later
		session.http = this.mocMvc.perform(post("/signin/authenticate")
				.with(csrf())
				.param("username", "upload")
				.param("password", "password"))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/"))
				.andReturn()
				.getRequest()
				.getSession();

		// post the solution XML
		String body = this.mocMvc.perform(post("/upload")
				.with(csrf())
				.session((MockHttpSession)session.http)
				.contentType("text/plain")
				.content(SOLUTION_XML))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		session.node = loadSerializedNode(body);

		return session;
	}
	/**
	 * Tests that a user that is signing in can upload a new solution including
	 * the p2-repository, screenshot and image.
	 */
	@Test
	@Sql("/system-test-data.sql") // creates user entry in the database
	public void testRestPostSolution() throws Exception {
		// sign in and upload a new solution
		SolutionUploadSession session = signInAndUploadSolution();

		InputStream is = MarketplaceServerTest.class
				.getClassLoader().getResource("data/p2-repo.zip").openStream();
		MockMultipartFile file = new MockMultipartFile("file", "p2-repo.zip","multipart/form-data", is);

		// update the newly created solution with files
		// TODO: Move to separate test
		String body2 = this.mocMvc.perform(fileUpload("/upload-p2repo")
				.file(file) // upload the p2-repository
				.param("id", session.node.getId().toString())
				.with(csrf())
				.session((MockHttpSession) session.http))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		Node node2 = loadSerializedNode(body2);

		// verify that we have the correct update site URL
		assertEquals("", node2.getUpdateurl());

		// download the p2-repository index files
		this.mocMvc.perform(get("http://localhost:8080/files/"+node2.getId()+"/artifacts.jar"))
				.andExpect(status().isOk());
		this.mocMvc.perform(get("http://localhost:8080/files/"+node2.getId()+"/content.jar"))
		.andExpect(status().isOk());

		ResponseEntity<String> entity = this.restTemplate
				.getForEntity("http://localhost:" + this.port + "/mpc/content/1/api/p", String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		Marketplace m = loadSerializedMarketplace(entity.getBody());
		assertEquals(Long.valueOf(1),m.getNode().getId());

		// sign out
		this.mocMvc.perform(post("http://localhost:8080/signout")
				.with(csrf()))
				.andExpect(status().is3xxRedirection());
	}

	@Test
	@Sql("/system-test-data.sql") // creates user entry in the database
	public void testRestUploadScreenshot() throws Exception{
		// sign in and upload a new solution
		SolutionUploadSession session = signInAndUploadSolution();

		MockMultipartFile screenshot = new MockMultipartFile(
				"file",
				"screenshot.png",
				"multipart/form-data",
				MarketplaceServerTest.class.getClassLoader().getResource("data/screenshot.png").openStream());

		// upload the screenshot
		String body = this.mocMvc.perform(fileUpload("/upload-screenshot")
				.file(screenshot) // upload the p2-repository
				.param("id", session.node.getId().toString())
				.with(csrf())
				.session((MockHttpSession) session.http))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		Node node = loadSerializedNode(body);

		// verify that we have the correct screenshot file name
		assertEquals("screenshot.png", node.getScreenshot());

		// then try to download the screenshot file
		this.mocMvc.perform(get("http://localhost:8080/files/"+node.getId()+"/"+node.getScreenshot()))
				.andExpect(status().isOk());

		// sign out
		this.mocMvc.perform(post("http://localhost:8080/signout")
				.with(csrf()))
				.andExpect(status().is3xxRedirection());
	}

	/**
	 * Tests that a user that is signing in can first upload then update the
	 * recently updated solution. The p2-repository, screenshot and image will
	 * also be updated.
	 */
	@Test
	@Sql("/system-test-data.sql") // creates user entry in the database
	public void testRestUpdateSolution() throws Exception {
		// sign in and upload a new solution
		SolutionUploadSession session = signInAndUploadSolution();

		session.node.setName("The new solution name");
		session.node.setBody("body");
		session.node.setScreenshot("screenshot");
		session.node.setImage("image");
		Tag t = MarketplaceFactory.eINSTANCE.createTag();
		t.setId((long) 99);
		t.setName("New tag");
		session.node.getTags().getItems().add(t);

		// post the solution XML and obtain the resulting node
		String n2Xml = this.mocMvc.perform(post("/upload")
				.with(csrf())
				.session((MockHttpSession) session.http)
				.contentType("text/plain")
				.content(MarketplaceSerializer.serialize(session.node)))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		// verify that the solution has been updated in the database and has
		// not changed identifier
		Node n2 = loadSerializedNode(n2Xml);
		assertEquals(session.node.getId(), n2.getId());
		assertEquals("Name is not correct, ", n2.getName(), "The new solution name");
		assertEquals("Tag count is not correct, ", 4, n2.getTags().getItems().size());

		// sign out
		this.mocMvc.perform(post("http://localhost:8080/signout")
				.with(csrf()))
				.andExpect(status().is3xxRedirection());
	}
	/**
	 * Tests that the system falls back and creates a node with the specified
	 * identifier if it does not exist.
	 */
	@Test
	@Sql("/system-test-data.sql") // creates user entry in the database
	public void testRestUpdateMissingSolution() throws Exception {
		// log in the user
		HttpSession session = this.mocMvc.perform(post("/signin/authenticate")
				.with(csrf())
				.param("username", "upload")
				.param("password", "password"))
				.andExpect(status().is(302))
				.andExpect(redirectedUrl("/"))
				.andReturn()
				.getRequest()
				.getSession();

		// assign an identifier that should not exist
		Node node = loadSerializedNode(SOLUTION_XML);
		node.setId(Long.valueOf(666));

		// post the solution XML which should create the node since it could
		// not be updated
		String body = this.mocMvc.perform(post("/upload")
				.with(csrf())
				.session((MockHttpSession) session)
				.contentType("text/plain")
				.content(MarketplaceSerializer.serialize(node)))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		loadSerializedNode(body);

		// sign out
		this.mocMvc.perform(post("http://localhost:8080/signout")
				.with(csrf()))
				.andExpect(status().is3xxRedirection());
	}

	/**
	 * Tests that a user that is signing in cannot upload and update a solution
	 * that does not belong to the user. This should result in a 404 error.
	 */
	@Test
	@Ignore // TODO handle switch to user context instead of thread context?
	@Sql("/system-test-data.sql") // creates user entries in the database
	public void testRestUpdateSolutionDifferentUser() throws Exception {
		// log in the user
		HttpSession session1 = this.mocMvc.perform(post("/signin/authenticate")
				.with(csrf())
				.param("username", "user")
				.param("password", "password"))
				.andExpect(status().is(302))
				.andExpect(redirectedUrl("/"))
				.andReturn()
				.getRequest()
				.getSession();

		// post the solution XML and obtain the resulting node
			String n1Xml = this.mocMvc.perform(post("/upload")
				.with(csrf())
				.session((MockHttpSession) session1)
				.contentType("text/plain")
				.content(SOLUTION_XML))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		// sign out
		this.mocMvc.perform(post("http://localhost:8080/signout")
				.with(csrf()))
				.andExpect(status().is3xxRedirection());

		// change a few values in the newly created node
		Node n1 = loadSerializedNode(n1Xml);
		n1.setName("The new solution name");

		// sign in as a different user
		HttpSession session2 = this.mocMvc.perform(post("/signin/authenticate")
				.with(csrf())
				.param("username", "user2")
				.param("password", "password2"))
				.andExpect(status().is(302))
				.andExpect(redirectedUrl("/"))
				.andReturn()
				.getRequest()
				.getSession();

		// post the solution XML and expect forbidden
		this.mocMvc.perform(post("/upload")
				.with(csrf())
				.session((MockHttpSession) session2)
				.contentType("text/plain")
				.content(MarketplaceSerializer.serialize(n1)))
				.andExpect(status().isForbidden()); // not found

		// sign out
		this.mocMvc.perform(post("http://localhost:8080/signout")
				.with(csrf()))
				.andExpect(status().is3xxRedirection());
	}

	//================================================================================================================
	// WebMvc tests
	//================================================================================================================

	@Test
	@Sql("/system-test-data.sql")
	public void testLoginWithGoodCredentials() throws Exception {
		this.mocMvc.perform(post("/signin/authenticate")
				.with(csrf())
				.param("username", "user")
				.param("password", "password"))
				.andExpect(authenticated().withRoles("USER"))
				.andExpect(status().is(302))
				.andExpect(redirectedUrl("/"));
	}

	@Test
	@Sql("/system-test-data.sql")
	public void testLoginWithBadCredentials() throws Exception {
		this.mocMvc.perform(post("/signin/authenticate")
				.with(csrf())
				.param("username", "user")
				.param("password", "bad_password"))
				.andExpect(unauthenticated())
				.andExpect(status().is(302))
				.andExpect(redirectedUrl("/signin?param.error=bad_credentials"));
	}

	@Test
	@Sql("/system-test-data.sql")
	public void testLoginWithAdminCredentials() throws Exception {
		this.mocMvc.perform(
				formLogin("/signin/authenticate")
					.user("admin")
					.password("s3cret!"))
				// this particular account should have all roles
				.andExpect(authenticated().withRoles("USER","ADMIN","UPLOAD"))
				.andExpect(status().is(302))
				.andExpect(redirectedUrl("/"));

		this.mocMvc.perform(logout())
			.andExpect(unauthenticated());
	}

	@Test
	public void testMvcGetRoot() throws Exception{
		this.mocMvc.perform(get("/")
			.accept(MediaType.APPLICATION_XHTML_XML))
			.andExpect(status().isOk())
			.andExpect(xpath("//div[@id='solution-1']").exists())
			.andExpect(xpath("//div[@id='solution-2']").exists());
	}

	@Test
	public void testMvcSearchForTerm() throws Exception{
		this.mocMvc.perform(get("/search?term=sample")
			.accept(MediaType.APPLICATION_XHTML_XML))
			.andExpect(status().isOk())
			.andExpect(xpath("//div[@id='solution-1']").exists());

		this.mocMvc.perform(get("/search?term=does_not_exist")
			.accept(MediaType.APPLICATION_XHTML_XML))
			.andExpect(status().isOk())
			.andExpect(xpath("//div[@id='solution-1']").doesNotExist());
	}

	@Test
	public void testMvcSearchForTag() throws Exception{
		this.mocMvc.perform(get("/search?tag=Common")
			.accept(MediaType.APPLICATION_XHTML_XML))
			.andExpect(status().isOk())
			.andExpect(xpath("//div[@id='solution-1']").exists())
			.andExpect(xpath("//div[@id='solution-2']").exists());

		this.mocMvc.perform(get("/search?tag=Tag for Solution 1")
			.accept(MediaType.APPLICATION_XHTML_XML))
			.andExpect(status().isOk())
			.andExpect(xpath("//div[@id='solution-1']").exists())
			.andExpect(xpath("//div[@id='solution-2']").doesNotExist());
	}

	@Test
	@Sql("/system-test-data.sql")
	public void testMvcCreateSolution() throws Exception{
		// log in as administrator user
		HttpSession session = this.mocMvc.perform(
				formLogin("/signin/authenticate")
					.user("admin")
					.password("s3cret!"))
				.andExpect(status().is(302))
				.andExpect(redirectedUrl("/"))
				.andReturn()
				.getRequest()
				.getSession();

		// bring up the new solution form
		session = this.mocMvc.perform(get("/edit-solution")
				.session((MockHttpSession)session)
				.accept(MediaType.APPLICATION_XHTML_XML))
				.andExpect(status().is(200))
				.andReturn()
				.getRequest()
				.getSession();

		// and post it, being redirected to show the details, most values will
		// be null.
		String url = this.mocMvc.perform(post("/edit-solution")
				.with(csrf())
				.session((MockHttpSession)session)
				.param("name", "test name")
				.accept(MediaType.APPLICATION_XHTML_XML))
				.andExpect(status().is3xxRedirection())
				.andReturn().getResponse().getRedirectedUrl();

		// test some key values in the new product
//		this.mocMvc.perform(get(url)
//				.accept(MediaType.APPLICATION_XHTML_XML))
//				.andExpect(status().isOk())
//				.andDo(print())
//				.andExpect(xpath("//div[@id='solution-1']").exists());
	}

	@Test
	public void testMvcReadSolution() throws Exception{
		this.mocMvc.perform(get("/content/1")
			.accept(MediaType.APPLICATION_XHTML_XML))
			.andExpect(status().isOk())
			.andExpect(xpath("//div[@id='solution-1']").exists());

		this.mocMvc.perform(get("/content/2")
			.accept(MediaType.APPLICATION_XHTML_XML))
			.andExpect(status().isOk())
			.andExpect(xpath("//div[@id='solution-2']").exists());
	}

	public void testMvcUpdateSolution() {
		// TODO: Write the test
	}

	public void testMvcDeleteSolution() {
		// TODO: Write the test
	}

	/**
	 * Use the regular sign up form to create a new user.
	 *
	 * @throws Exception
	 */
	@Test
	public void testMvcCreateUser() throws Exception {
		this.mocMvc.perform(post("/signup")
				.with(csrf())
				.param("firstName", "Nomen")
				.param("lastName", "Nescio")
				.param("username", "signedup")
				.param("password", "password"))
			.andExpect(authenticated())
			.andExpect(status().is3xxRedirection())
			.andExpect(redirectedUrl("/"));
	}

	@Test
	@Ignore
	@Sql("/system-test-data.sql")
	public void testMvcUpdateUser() throws Exception {
		this.mocMvc.perform(
				formLogin("/signin/authenticate")
					.user("admin")
					.password("s3cret!"))
				.andExpect(authenticated().withRoles("USER","ADMIN"))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/"))
				.andReturn()
				.getRequest()
				.getSession();

		this.mocMvc.perform(post("/account/update-user")
				.with(csrf())
				// .with(account) // MocMvc does not support @ModelAttribute - need a different way
				.param("firstName", "Test")
				.param("lastName", "Test"))
				.andExpect(status().is(200))
				.andExpect(redirectedUrl("/accounts"));

		this.mocMvc.perform(logout())
			.andExpect(unauthenticated());
	}

	/**
	 * Verifies that we can open the user details form when logged in as the
	 * administrator user and that no access is granted when logged in as a
	 * regular user.
	 */
	@Test
	@Sql("/system-test-data.sql")
	public void testMvcReadUser() throws Exception {
		// administrator user
		HttpSession session = this.mocMvc.perform(
				formLogin("/signin/authenticate")
					.user("admin")
					.password("s3cret!"))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/"))
				.andReturn()
				.getRequest()
				.getSession();

		this.mocMvc.perform(get("/account/user")
				.session((MockHttpSession)session)
				.accept(MediaType.APPLICATION_XHTML_XML))
				.andExpect(status().isOk())
				.andExpect(xpath("//form[@id='user']").exists());

		// regular user
		HttpSession session2 = this.mocMvc.perform(post("/signin/authenticate")
				.with(csrf())
				.param("username", "user")
				.param("password", "password"))
				.andExpect(authenticated().withRoles("USER"))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/"))
				.andReturn()
				.getRequest()
				.getSession();

		this.mocMvc.perform(get("/account/user")
				.session((MockHttpSession)session2)
				.with(csrf())
				.accept(MediaType.APPLICATION_XHTML_XML))
				.andExpect(status().isForbidden());
	}

	@Test
	@Sql("/system-test-data.sql")
	public void testMvcDeleteUser() throws Exception {
		// administrator user
		HttpSession session = this.mocMvc.perform(post("/signin/authenticate")
				.with(csrf())
				.param("username", "admin")
				.param("password", "s3cret!"))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/"))
				.andReturn()
				.getRequest()
				.getSession();

		this.mocMvc.perform(get("/delete-account/user")
				.session((MockHttpSession)session)
				.with(csrf())
				.accept(MediaType.APPLICATION_XHTML_XML))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/accounts"));

		// this user should no longer be able to log in
		this.mocMvc.perform(post("/signin/authenticate")
				.with(csrf())
				.param("username", "user")
				.param("password", "password"))
				.andExpect(unauthenticated());

	}
}
