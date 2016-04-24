/**
 * 
 */
package com.programmunity.webapplication.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.programmunity.webapplication.models.Feed;
import com.programmunity.webapplication.models.User;

/**
 * @author Basheer
 *
 */
@Component
public class FeedRepositoryImpl implements FeedRepository
{

	/**
	 * @see com.programmunity.webapplication.database.FeedRepository#getFeeds(long,
	 *      int)
	 */
	@Override
	public List<Feed> getFeeds(long feedId, int count)
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

	/**
	 * @see com.programmunity.webapplication.database.FeedRepository#getFeeds(java.util.List)
	 */
	@Override
	public List<Feed> getFeeds(List<Long> feedIds)
	{
		return getFeeds(-1, feedIds.size());
	}

	/**
	 * @see com.programmunity.webapplication.database.FeedRepository#getFeed(long)
	 */
	@Override
	public Feed getFeed(long feedId)
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
	 * @see com.programmunity.webapplication.database.FeedRepository#getFeeds(int,
	 *      String, int)
	 */
	@Override
	public List<Feed> getFeeds(int page, String sort, int count)
	{
		return getFeeds(Long.MAX_VALUE, count);
	}

}
