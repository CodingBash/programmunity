package com.programmunity.webapplication.database;

import java.util.List;

import com.programmunity.webapplication.models.Feed;

public interface FeedRepository
{

	/**
	 * 
	 * @param max
	 *            maximum ID of any Feed that should be returned
	 * @param count
	 *            how many Feed to return
	 * @return List of Feeds
	 */
	public List<Feed> findFeed(long max, int count);

	/**
	 * 
	 * @param id
	 *            of the feed to return
	 * 
	 * @return the feed
	 */
	public Feed findFeed(long id);

}
