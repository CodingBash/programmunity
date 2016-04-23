package com.programmunity.webapplication.database;

import java.util.List;

import com.programmunity.webapplication.models.Event;

//TODO: Exception handling
public interface EventRepository
{

	/**
	 * Gets a list of events starting from the eventId
	 * 
	 * @param eventId
	 *            starting event
	 * @param count
	 *            amount of events to return
	 * @return list of events
	 */
	public List<Event> getEvents(long eventId, int count);

	// TODO: Define "first event". Recent, Latest, Etc?
	/**
	 * Gets a list of events starting from the first event
	 * 
	 * @param count
	 *            amount of events to return
	 * @return list of events
	 */
	public List<Event> getEvents(int count);

	/**
	 * Gets a list of events from a list of event IDs
	 * 
	 * @param eventIds
	 *            of events to retrieve
	 * @return list of events
	 */
	public List<Event> getEvents(List<Long> eventIds) throws RuntimeException;

	/**
	 * Register for an event given the parameters
	 * 
	 * @param eventId
	 *            event to register
	 * @param userId
	 *            registree
	 */
	public void register(long eventId, long userId);

	/**
	 * Get a single event
	 * 
	 * @param eventId
	 *            event to retrieve
	 * @return event
	 */
	public Event getEvent(long eventId);

}
