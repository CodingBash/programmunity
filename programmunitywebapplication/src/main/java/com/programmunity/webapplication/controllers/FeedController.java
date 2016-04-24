package com.programmunity.webapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.programmunity.webapplication.database.FeedRepository;

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
		ModelAndView mav = new ModelAndView("feeds");
		bindContentToModel(mav);
		mav.addObject("feeds", feedRepository.getFeeds(page, sort, count));
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
		ModelAndView mav = new ModelAndView("feed");
		bindContentToModel(mav);
		mav.addObject("feed", feedRepository.getFeed(feedId));
		return mav;
	}
}
