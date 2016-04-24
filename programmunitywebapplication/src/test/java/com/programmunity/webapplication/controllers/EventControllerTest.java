package com.programmunity.webapplication.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.request.MockMvcRequestBuilders;
import org.springframework.test.web.server.result.MockMvcResultMatchers;
import org.springframework.test.web.server.setup.MockMvcBuilders;

import com.programmunity.webapplication.database.EventRepository;
import com.programmunity.webapplication.models.Event;
import com.programmunity.webapplication.models.Group;
import com.programmunity.webapplication.models.Group.Directory;
import com.programmunity.webapplication.models.GroupRole;
import com.programmunity.webapplication.models.Residable;
import com.programmunity.webapplication.models.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class EventControllerTest
{

	@Mock
	private EventRepository eventRepository;

	@InjectMocks
	private EventsController eventsController;

	private MockMvc mockMvc;

	private List<Event> expectedEvents;
	int count = 20;

	/**
	 * Initiate the mocks
	 * 
	 * @throws Exception
	 */
	@Before
	public void setup() throws Exception
	{
		/*
		 * Init the mocks
		 */
		MockitoAnnotations.initMocks(this);

		/*
		 * Create mock event list
		 */

		expectedEvents = createEventList(count);

		/*
		 * Set return of event repository to the mock event list
		 * 
		 * !IMPORTANT: The arguments are from the default values of the
		 * controller method
		 */
		Mockito.when(eventRepository.getEvents(1, "newest", 20)).thenReturn(expectedEvents);

		/*
		 * Build the mock mvc
		 */
		mockMvc = MockMvcBuilders.standaloneSetup(eventsController).build();

	}

	/**
	 * Tests method mapping and view name
	 * 
	 * @method {@link EventsController#eventList()}
	 * @perform Send a mock GET "/events/"
	 * 
	 * @expectedResults Receives correct view name "events"
	 * @expectedResults HTTP OK
	 * @expectedResults Correct forward url "events"
	 * @expectedResults Has an "events" attribute
	 * @expectedResults "events" attribute is same as mock
	 * 
	 * @throws Exception
	 */
	@Test
	public void testEventList() throws Exception
	{
		Map<String, Object> requestParameters = null;

		/*
		 */
		mockMvc.perform(MockMvcRequestBuilders.get(constructRequest("/events", requestParameters)))
				.andExpect(MockMvcResultMatchers.view().name("events")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.forwardedUrl("events"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("events")).andExpect(
						MockMvcResultMatchers.model().attribute("events", Matchers.hasItems(expectedEvents.toArray())));

	}

	/**
	 * Create the mock event list
	 * 
	 * @param count
	 *            amount of events to add to list
	 * @return mock event list
	 */
	private List<Event> createEventList(int count)
	{
		List<Event> eventList = new ArrayList<Event>(count);

		for (int i = 0; i <= count; i++)
		{
			Event event = new Event();
			event.setTitle("Title: " + i);
			event.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
			List<Residable> attendees = new ArrayList<Residable>();

			Group group = new Group();
			Directory directory = group.new Directory();
			Map<User, GroupRole> members = new HashMap<User, GroupRole>();

			User user1 = new User();
			user1.setUserName("user1_" + i);
			User user2 = new User();
			user2.setUserName("user2_" + i);
			User user3 = new User();
			user3.setUserName("user3_" + i);
			User user4 = new User();
			user4.setUserName("user4_" + i);
			User user5 = new User();
			user5.setUserName("user5_" + i);

			directory.setOwner(user1);
			members.put(user2, GroupRole.ADMINISTRATOR);
			members.put(user3, GroupRole.MODERATOR);
			members.put(user4, GroupRole.REGULAR);
			members.put(user5, GroupRole.REGULAR);
			directory.setMembers(members);
			group.setDirectory(directory);
			attendees.add(group);

			event.setAttendees(attendees);
			eventList.add(event);
		}
		return eventList;
	}

	/**
	 * Construct a request string from a mapping and requestParameter
	 * 
	 * Expecting: "/mapping?key1=value1&key2=value2&key3=value3"
	 * 
	 * @param mapping
	 *            initial mapping
	 * @param requestParameters
	 *            request parameters
	 * @return request string
	 */
	private String constructRequest(String mapping, Map<String, Object> requestParameters)
	{
		// Create StringBuilder to append entities
		StringBuilder requestBuilder = new StringBuilder();

		// Append mapping
		requestBuilder.append(mapping);

		// Boolean to determine first entry to prevent adding "&" to first
		boolean firstEntry = true;

		if (requestParameters != null)
		{
			// Iterate through all request parameters
			for (Map.Entry<String, Object> entry : requestParameters.entrySet())
			{
				/*
				 * Get data from map
				 */
				String key = entry.getKey();
				Object value = entry.getValue();

				// Add correct symbol depending on entry
				if (!firstEntry)
				{
					requestBuilder.append("&");
				} else
				{
					requestBuilder.append("?");
					firstEntry = false;
				}

				// Append the data
				requestBuilder.append(key).append("=").append(value);
			}
		}
		requestBuilder.append("/");
		
		return requestBuilder.toString();
	}

}
