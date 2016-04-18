package com.programmunity.webapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.programmunity.webapplication.database.FeedRepository;

@Controller
@RequestMapping(value = "/feed")
public class FeedController
{
	@Autowired
	private FeedRepository feedRepository;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView feed()
	{
		ModelAndView mav = new ModelAndView("feeds");
		mav.addObject("feedList", feedRepository.findFeed(Long.MAX_VALUE, 20));
		return mav;

	}

	@RequestMapping(value = "/{feed_id}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable("feed_id") long feedId)
	{
		ModelAndView mav = new ModelAndView("feed");
		
		mav.addObject("feed", feedRepository.findFeed(feedId));
		return mav;
	}
}
