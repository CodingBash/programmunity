package com.programmunity.webapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.programmunity.webapplication.database.EventRepository;
import com.programmunity.webapplication.models.Event;

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

	// TODO: Add validation on all fields
	/**
	 * Sets up page to display a {@link List} of {@link Event}
	 * 
	 * @param eventId
	 *            of first {@link Event}
	 * @param count
	 *            of amount of {@link Event}s
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView eventList(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "sort", defaultValue = "newest") String sort,
			@RequestParam(value = "count", defaultValue = "20") int count)
	{
		ModelAndView mav = new ModelAndView("events");
		bindContentToModel(mav);
		mav.addObject("events", eventRepository.getEvents(page, sort, count));
		return mav;
	}

	/**
	 * Sets up page to display details of an event
	 * 
	 * @param eventId
	 *            of event
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value = "/event/{eventId}", method = RequestMethod.GET)
	public ModelAndView eventDetails(@PathVariable(value = "eventId") long eventId)
	{
		ModelAndView mav = new ModelAndView("event");
		bindContentToModel(mav);
		mav.addObject("event", eventRepository.getEvent(eventId));
		return mav;
	}

	// TODO: Correct the mapping of this
	// TODO: Need validation and CSRF
	@RequestMapping(value = "/event/{eventId}/register", method = RequestMethod.POST)
	public ModelAndView eventRegister(@PathVariable(value = "eventId") long eventId,
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
