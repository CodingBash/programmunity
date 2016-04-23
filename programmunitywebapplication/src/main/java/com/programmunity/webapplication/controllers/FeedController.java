package com.programmunity.webapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.programmunity.webapplication.database.FeedRepository;

@RequestMapping("/feeds")
@Controller
public class FeedController extends BaseController
{

	@Autowired
	private FeedRepository feedRepository;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getFeeds(@RequestParam(value = "feedId", required = false) Long feedId,
			@RequestParam(value = "count", required = false) Integer count)
	{
		ModelAndView mav = new ModelAndView("feeds");
		bindContentToModel(mav);
		if (count != null && feedId != null)
		{
			mav.addObject("feeds", feedRepository.getFeeds(feedId, count));
		} else {
			mav.addObject("feeds", feedRepository.getFeeds(-1, 20));
		}
		return mav;
	}

	@RequestMapping(value = "{feedId}", method = RequestMethod.GET)
	public ModelAndView getFeed(@PathVariable("feedId") long feedId)
	{
		ModelAndView mav = new ModelAndView("feed");
		bindContentToModel(mav);
		mav.addObject("feeds", feedRepository.getFeed(feedId));
		return mav;
	}
}
