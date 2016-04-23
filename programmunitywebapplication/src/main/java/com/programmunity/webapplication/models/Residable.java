package com.programmunity.webapplication.models;

import java.util.List;

/**
 * Abstract class to determine what entity contains user(s)
 * 
 * Use case example: An event can be hosted or attended by a user or a group,
 * thus both user and group can be scoped under an interface called residable
 * 
 * @author Basheer
 *
 */
public abstract class Residable
{

	// TODO: Way to only store the eventId to prevent duplicate database data?
	private List<Event> eventsAttended;

}
