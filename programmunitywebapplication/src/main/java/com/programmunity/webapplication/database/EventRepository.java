package com.programmunity.webapplication.database;

public interface EventRepository
{

	/**
	 * Gets a list of events
	 * 
	 * @param eventId
	 * @param count
	 * @return
	 */
	public Object getEvents(long eventId, int count);

	public Object getEvents(int count);
	
	public void register(Long eventId, Long userId);

	public Object getEvent(Long eventId);



}
