package com.programmunity.webapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.programmunity.webapplication.database.EventRepository;

/**
 * Controls event mappings
 * 
 * @author Bash
 *
 */
@RequestMapping("/events")
@Controller
public class EventsController extends BaseController
{
	/**
	 * Repository to get event data
	 */
	@Autowired
	private EventRepository eventRepository;

	/**
	 * Sets up page to display a {@link List} of {@link Event}
	 * 
	 * @param eventId of first {@link Event}
	 * @param count of amount of {@link Event}s
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView eventList(@RequestParam(value = "eventId", required = false) Long eventId,
			@RequestParam(value = "count", defaultValue = "20") int count)
	{
		ModelAndView mav = new ModelAndView("events");
		bindContentToModel(mav);

		if (eventId != null)
		{
			mav.addObject("events", eventRepository.getEvents(eventId, count));
		} else
		{
			mav.addObject("events", eventRepository.getEvents(count));
		}
		return mav;
	}

	/**
	 * Sets up page to display details of an event
	 * @param eventId of event
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ModelAndView eventDetails(@RequestParam(value = "eventId") long eventId)
	{
		ModelAndView mav = new ModelAndView("event");
		bindContentToModel(mav);
		mav.addObject("event", eventRepository.getEvent(eventId));
		return mav;
	}

	// Need validation and CSRF
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@RequestParam(value = "eventId") long eventId,
			@RequestParam(value = "userId") long userId)
	{
		ModelAndView mav = new ModelAndView("redirect: /events?eventId=" + eventId);
		bindContentToModel(mav);
		eventRepository.register(eventId, userId);
		return mav;
		// TODO: Add flashattribute to determine confirmation. Then have
		// notify.js confirmation
	}

}
