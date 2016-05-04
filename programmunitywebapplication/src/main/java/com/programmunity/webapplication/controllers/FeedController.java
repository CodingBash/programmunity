package com.programmunity.webapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.programmunity.webapplication.database.FeedRepository;
import com.programmunity.webapplication.models.Feed;

/**
 * Handles feed mappings
 * 
 * @author Basheer
 *
 */
@RequestMapping("/feeds")
@Controller
public class FeedController extends BaseController
{

	@Autowired
	private FeedRepository feedRepository;

	/**
	 * For GET "/feeds", return list of feeds to feeds.html
	 * 
	 * @param page
	 * @param sort
	 * @param count
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getFeeds(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "sort", defaultValue = "newest") String sort,
			@RequestParam(value = "count", defaultValue = "20") int count)
	{
		
		// Create ModelAndView and set view to "feeds"
		ModelAndView mav = new ModelAndView("feeds");
		
		// Insert consistent content to model
		bindContentToModel(mav);
		
		// Retrieve list from repository using request parameters
		List<Feed> retrievedFeedList = feedRepository.getFeeds(page, sort, count);
		
		// Insert list to model
		mav.addObject("feeds", retrievedFeedList);
		
		return mav;
	}

	/**
	 * For GET "/feeds/feed/{feed}", return feed to feed.html
	 * 
	 * @param feedId
	 * @return
	 */
	@RequestMapping(value = "/feed/{feedId}", method = RequestMethod.GET)
	public ModelAndView getFeed(@PathVariable("feedId") long feedId)
	{
		
		// Create ModelAndView and set view to "feed"
		ModelAndView mav = new ModelAndView("feed");
		
		// Insert consistent content to model
		bindContentToModel(mav);
		
		// Retrieve feed from repository using request parameter
		Feed retrievedFeed = feedRepository.getFeed(feedId);
		
		// Insert feed to model
		mav.addObject("feed", retrievedFeed );
		
		return mav;
	}
}
