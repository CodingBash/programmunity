package com.programmunity.webapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.programmunity.webapplication.database.EventRepository;

@RequestMapping("/events")
@Controller
public class EventsController extends BaseController
{
	@Autowired
	private EventRepository eventRepository;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView eventList(@RequestParam(value = "eventId", required = false) Long eventId,
			@RequestParam(value = "count", defaultValue = "20") int count)
	{
		ModelAndView mav = new ModelAndView("events");
		bindContentToModel(mav);

		// TODO: Determine which condition is most likely to occur then reorder
		// conditional
		if (eventId != null)
		{
			mav.addObject("events", eventRepository.getEvents(eventId, count));
		} else
		{
			mav.addObject("events", eventRepository.getEvents(count));
		}
		return mav;
	}

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
