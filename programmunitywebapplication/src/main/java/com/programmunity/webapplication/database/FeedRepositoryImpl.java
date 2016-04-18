package com.programmunity.webapplication.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.programmunity.webapplication.models.Feed;

@Component
public class FeedRepositoryImpl implements FeedRepository
{

	@Override
	public List<Feed> findFeed(long max, int count)
	{
		List<Feed> feedList = new ArrayList<Feed>(count);
		for (int i = 0; i < count; i++)
		{
			Feed feed = new Feed("This is feed" + i, null, 123.0, 321.0);
			feedList.add(feed);
		}
		return feedList;
	}

	@Override
	public Feed findFeed(long id)
	{
		Feed feed = new Feed("This is feed " + id, null, null, null);

		return feed;
	}

}
