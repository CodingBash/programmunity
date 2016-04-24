package com.programmunity.webapplication.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.request.MockMvcRequestBuilders;
import org.springframework.test.web.server.result.MockMvcResultMatchers;
import org.springframework.test.web.server.setup.MockMvcBuilders;

/**
 * Test examines methods within the {@link HomeController} class
 * 
 * @author Basheer
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class HomeControllerTest
{

	@InjectMocks
	private HomeController homeController;

	private MockMvc mockMvc;

	/**
	 * Initiate the mocks
	 * 
	 * @throws Exception
	 */
	@Before
	public void setup() throws Exception
	{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();

	}

	/**
	 * Tests method mapping and view name
	 * 
	 * @method {@link HomeController#onHome()}
	 * @objective Send a mock GET "/"
	 * @expectedResults Receives correct view name
	 * 
	 * @throws Exception
	 */
	@Test
	public void testOnHome() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("home"));
	}

}
