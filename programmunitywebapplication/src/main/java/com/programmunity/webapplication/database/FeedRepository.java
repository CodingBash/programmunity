/**
 * 
 */
package com.programmunity.webapplication.database;

import java.util.List;

import com.programmunity.webapplication.models.Feed;

/**
 * @author Basheer
 *
 */
public interface FeedRepository
{

	/**
	 * Get feeds with a starting ID and a count of the amount of feeds to
	 * retrieve
	 * 
	 * @param feedId
	 *            starting feed ID
	 * @param count
	 *            amount of feeds
	 * @return list of feeds
	 */
	public List<Feed> getFeeds(long feedId, int count);

	/**
	 * Get feeds with a list of feed IDs
	 * 
	 * @param feedIds
	 *            list of feed IDs
	 * @return List of feeds
	 */
	public List<Feed> getFeeds(List<Long> feedIds);

	/**
	 * Get a feed from a feed ID
	 * 
	 * @param feedId
	 *            feed ID
	 * @return feed
	 */
	public Feed getFeed(long feedId);

}
