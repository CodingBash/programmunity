package com.programmunity.webapplication.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Ignore;
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

/**
 * Tests the {@link EventController} class
 * 
 * @author Basheer
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class EventControllerTest extends ControllerTest
{

	@Mock
	private EventRepository eventRepository;

	@InjectMocks
	private EventsController eventsController;

	private MockMvc mockMvc;

	private List<Event> expectedEvents;

	private Event expectedEvent;

	private static final int count = 20;

	private static final long eventId = 12345L;

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

		expectedEvent = createEvent();

		/*
		 * Set return of event repository to the mock event list
		 * 
		 * !IMPORTANT: The arguments are from the default values of the
		 * controller method
		 */
		Mockito.when(eventRepository.getEvents(1, "newest", count)).thenReturn(expectedEvents);

		/*
		 * Set return of event repository to the mock event
		 * 
		 */
		Mockito.when(eventRepository.getEvent(eventId)).thenReturn(expectedEvent);
		/*
		 * Build the mock mvc
		 */
		mockMvc = MockMvcBuilders.standaloneSetup(eventsController).build();

	}

	/**
	 * Tests method mapping and view name
	 * 
	 * @method {@link EventsController#eventList(int, String, int)}
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
	 * Tests method mapping and view name
	 * 
	 * @method {@link EventsController#eventDetails(long)}
	 * @perform Send a mock GET "/events/event/{eventId}/"
	 * 
	 * @expectedResults Receives correct view name "event"
	 * @expectedResults HTTP OK
	 * @expectedResults Correct forward url "event"
	 * @expectedResults Has an "event" attribute
	 * @expectedResults "event" attribute is same as mock
	 * 
	 * @throws Exception
	 */
	@Test
	public void testEventDetails() throws Exception
	{
		Map<String, Object> requestParameters = null;

		/*
		 */
		mockMvc.perform(MockMvcRequestBuilders.get(constructRequest("/events/event/" + eventId, requestParameters)))
				.andExpect(MockMvcResultMatchers.view().name("event")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.forwardedUrl("event"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("event"))
				.andExpect(MockMvcResultMatchers.model().attribute("event", Matchers.equalTo(expectedEvent)));

	}

	// TODO: Complete the eventRegister test
	/**
	 * Tests method mapping and view name
	 * 
	 * @method {@link EventsController#eventDetails(long)}
	 * @perform Send a mock GET "/events/event/{eventId}/register"
	 * 
	 * @expectedResults Receives correct view name "event"
	 * @expectedResults HTTP OK
	 * @expectedResults Correct forward url "event"
	 * @expectedResults Has an "event" attribute
	 * @expectedResults "event" attribute is same as mock
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void testEventRegister() throws Exception
	{
		Map<String, Object> requestParameters = null;

		/*
		 */
		mockMvc.perform(MockMvcRequestBuilders.get(constructRequest("/events/event/" + eventId, requestParameters)))
				.andExpect(MockMvcResultMatchers.view().name("event")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.forwardedUrl("event"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("event"))
				.andExpect(MockMvcResultMatchers.model().attribute("event", Matchers.equalTo(expectedEvent)));

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
	 * Creates a mock event
	 * @return
	 */
	private Event createEvent()
	{
		Event event = new Event();
		event.setTitle("Title: ");
		event.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		List<Residable> attendees = new ArrayList<Residable>();

		Group group = new Group();
		Directory directory = group.new Directory();
		Map<User, GroupRole> members = new HashMap<User, GroupRole>();

		User user1 = new User();
		user1.setUserName("user1_");
		User user2 = new User();
		user2.setUserName("user2_");
		User user3 = new User();
		user3.setUserName("user3_");
		User user4 = new User();
		user4.setUserName("user4_");
		User user5 = new User();
		user5.setUserName("user5_");

		directory.setOwner(user1);
		members.put(user2, GroupRole.ADMINISTRATOR);
		members.put(user3, GroupRole.MODERATOR);
		members.put(user4, GroupRole.REGULAR);
		members.put(user5, GroupRole.REGULAR);
		directory.setMembers(members);
		group.setDirectory(directory);
		attendees.add(group);

		event.setAttendees(attendees);
		return event;
	}
}
