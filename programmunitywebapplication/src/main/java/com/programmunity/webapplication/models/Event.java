package com.programmunity.webapplication.models;

import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

/**
 * Model containing information for an event
 * 
 * @author Basheer
 *
 */
public class Event
{

	// TODO: Verify hibernate
	@GenericGenerator(name = "generator", strategy = "identity")
	@GeneratedValue(generator = "generator")
	private long eventId;

	/**
	 * Title of event
	 */
	@NotNull
	@Size(min = 5, max = 50)
	private String title;

	/**
	 * Description of event
	 */
	@Size(min = 1, max = 1000)
	private String description;

	/**
	 * Host(s) of event
	 */
	@NotNull
	@Size(min = 1, max = 25)
	private List<Residable> hosts;

	/**
	 * 
	 */
	@Size(max = 200)
	private List<Residable> attendees;

	@Future
	@NotNull
	private Date date;

	// TODO: Needs work inside location class
	@NotNull
	private Location location;

	@NotNull
	private boolean cancelled;

	public long getEventId()
	{
		return eventId;
	}

	public void setEventId(long eventId)
	{
		this.eventId = eventId;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public List<Residable> getHosts()
	{
		return hosts;
	}

	public void setHosts(List<Residable> hosts)
	{
		this.hosts = hosts;
	}

	public List<Residable> getAttendees()
	{
		return attendees;
	}

	public void setAttendees(List<Residable> attendees)
	{
		this.attendees = attendees;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public Location getLocation()
	{
		return location;
	}

	public void setLocation(Location location)
	{
		this.location = location;
	}

	public boolean isCancelled()
	{
		return cancelled;
	}

	public void setCancelled(boolean cancelled)
	{
		this.cancelled = cancelled;
	}

	// TODO: Test (What if Date is null?)
	public boolean isClosed()
	{
		/*
		 * TODO: Turn this into javadoc
		 * 
		 * Returns true if: isCancelled() is true (or -cancelled:boolean is
		 * true)
		 * 
		 * Returns true if: current date is before event date
		 * 
		 * Returns false if: current date is after event date
		 */
		return isCancelled() ? true : new Date().after(date);
	}

	// TODO: Write validator to check if one is not null, refer to
	// http://stackoverflow.com/questions/12211734/hibernate-validation-annotation-validate-that-at-least-one-field-is-not-null
	/**
	 * Defines a location for an {@link Event}
	 * 
	 * @author Basheer
	 * 
	 */
	public class Location
	{

		/**
		 * If the location is in a physical address
		 */
		@Size(max = 300)
		private String physicalLocation;

		// TODO: SECURITY FLAW
		// TODO: Add validation since this is a URL
		/**
		 * If the location is in a online address
		 */
		@Size(max = 300)
		private String onlineLocation;

		public String getPhysicalLocation()
		{
			return physicalLocation;
		}

		public void setPhysicalLocation(String physicalLocation)
		{
			this.physicalLocation = physicalLocation;
		}

		public String getOnlineLocation()
		{
			return onlineLocation;
		}

		public void setOnlineLocation(String onlineLocation)
		{
			this.onlineLocation = onlineLocation;
		}

	}

}
