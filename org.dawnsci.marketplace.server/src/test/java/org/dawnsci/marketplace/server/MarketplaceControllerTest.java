package org.dawnsci.marketplace.server;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfiguration.class)
@WebIntegrationTest({ "server.port=0", "management.port=0" })
@ActiveProfiles("test")
public class MarketplaceControllerTest {
	
	@Inject
	private WebApplicationContext wac;
	
	private MockMvc mocMvc;
	
	@Before
	public void setup(){
		this.mocMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void getMain() throws Exception{
		this.mocMvc.perform(get("/").accept(MediaType.APPLICATION_XHTML_XML))
		.andExpect(status().isOk());
	}

	@Test
	public void getSearch() throws Exception{
		this.mocMvc.perform(get("/search?term=pellentesque").accept(MediaType.APPLICATION_XHTML_XML))
		.andExpect(status().isOk());
	}

	@Test
	public void getSolution() throws Exception{
		this.mocMvc.perform(get("/content/1").accept(MediaType.APPLICATION_XHTML_XML))
		.andExpect(status().isOk());
	}
}
