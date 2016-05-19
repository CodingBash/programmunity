package com.programmunity.webapplication.controllers;

import org.junit.Before;
import org.junit.Ignore;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
@Ignore
public class DashboardControllerTest
{

	@InjectMocks
	private DashboardController dashboardController;

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
		mockMvc = MockMvcBuilders.standaloneSetup(dashboardController).build();

	}

	/**
	 * Tests method mapping and view name
	 * 
	 * @method {@link DashboardController#dashboard()}
	 * @objective Send a mock GET "/dashboard"
	 * @expectedResults Receives correct view name
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDashboard() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/dashboard/")).andExpect(MockMvcResultMatchers.view().name("dashboard"));
	}

}
