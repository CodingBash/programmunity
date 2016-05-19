/**
 * 
 */
package com.programmunity.webapplication.controllers;

import java.util.ArrayList;
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

import com.programmunity.webapplication.database.FeedRepository;
import com.programmunity.webapplication.models.Feed;
import com.programmunity.webapplication.models.User;

/**
 * Tests the {@link FeedController} class
 * 
 * @author Basheer
 *
 */
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
@Ignore
public class FeedControllerTest extends ControllerTest
{
	@Mock
	private FeedRepository feedRepository;

	@InjectMocks
	private FeedController feedController;

	private MockMvc mockMvc;

	private List<Feed> expectedFeeds;

	private Feed expectedFeed;

	private static final long feedId = 12345L;

	private static final int count = 20;

	private static final String sort = "newest";

	private static final int page = 1;

	/**
	 * Setups tests
	 */
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		expectedFeeds = createdExpectedFeeds();
		expectedFeed = createExpectedFeed();
		Mockito.when(feedRepository.getFeeds(page, sort, count)).thenReturn(expectedFeeds);
		Mockito.when(feedRepository.getFeed(feedId)).thenReturn(expectedFeed);
		mockMvc = MockMvcBuilders.standaloneSetup(feedController).build();

	}

	/**
	 * Tests method mapping and view name
	 * 
	 * @method {@link FeedController#getFeeds(int, String, int)}
	 * @perform Send a mock GET "/feeds/"
	 * 
	 * @expectedResults Receives correct view name "feeds"
	 * @expectedResults HTTP OK
	 * @expectedResults Correct forward url "feeds"
	 * @expectedResults Has an "feeds" attribute
	 * @expectedResults "feeds" attribute is same as mock
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetFeeds() throws Exception
	{
		Map<String, Object> requestParameters = null;

		mockMvc.perform(MockMvcRequestBuilders.get(constructRequest("/feeds", requestParameters)))
				.andExpect(MockMvcResultMatchers.view().name("feeds")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.forwardedUrl("feeds"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("feeds")).andExpect(
						MockMvcResultMatchers.model().attribute("feeds", Matchers.hasItems(expectedFeeds.toArray())));

	}

	/**
	 * Tests method mapping and view name
	 * 
	 * @method {@link FeedController#getFeed(long)}
	 * @perform Send a mock GET "/feeds/feed/{feedId}/"
	 * 
	 * @expectedResults Receives correct view name "feed"
	 * @expectedResults HTTP OK
	 * @expectedResults Correct forward url "feed"
	 * @expectedResults Has an "feed" attribute
	 * @expectedResults "feed" attribute is same as mock
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetFeed() throws Exception
	{
		Map<String, Object> requestParameters = null;

		mockMvc.perform(MockMvcRequestBuilders.get(constructRequest("/feeds/feed/" + feedId, requestParameters)))
				.andExpect(MockMvcResultMatchers.view().name("feed")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.forwardedUrl("feed"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("feed"))
				.andExpect(MockMvcResultMatchers.model().attribute("feed", Matchers.equalTo(expectedFeed)));
	}

	/**
	 * Create mock {@link Feed}
	 * 
	 * @return mock {@link Feed}
	 */
	private Feed createExpectedFeed()
	{
		Feed feed = new Feed();
		User user = new User();
		user.setUserName("user");
		feed.setPoster(user);
		feed.setPost("Hello, this is post:");
		feed.setLikes(123);
		return feed;
	}

	/**
	 * Create mock {@link List} of {@link Feed}s
	 * 
	 * @return mock {@link List} of {@link Feed}s
	 */
	private List<Feed> createdExpectedFeeds()
	{
		List<Feed> feeds = new ArrayList<Feed>();
		for (int i = 0; i <= count; i++)
		{
			Feed feed = new Feed();
			User user = new User();
			user.setUserName("user" + i);
			feed.setPoster(user);
			feed.setPost("Hello, this is post:" + i);
			feed.setLikes(i);
			feeds.add(feed);
		}
		return feeds;
	}

}
