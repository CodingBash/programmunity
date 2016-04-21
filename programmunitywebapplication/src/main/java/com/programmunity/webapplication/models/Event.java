package com.programmunity.webapplication.models;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Model containing information for an event
 * 
 * @author Basheer
 *
 */
public class Event
{

	@NotNull
	@Size(min = 5, max = 50)
	private String title;

	@Size(min = 1, max = 1000)
	private String description;

	@NotNull
	private User host;

	@Size(max = 50)
	private List<User> attendees;

	@Future
	@NotNull
	private Date date;

}
