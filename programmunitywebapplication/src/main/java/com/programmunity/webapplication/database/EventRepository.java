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

	public void register(Long eventId, Long userId);

	public Object getEvents(Long eventId);

	public Object getEvents(int count);

}
