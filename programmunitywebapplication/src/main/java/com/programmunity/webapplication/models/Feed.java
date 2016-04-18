package com.programmunity.webapplication.models;

import java.util.Date;

public class Feed
{
	private final Long id;
	private final String message;
	private final Date time;
	private Double latitude;
	private Double longitude;
	
	public Feed(String message, Date time){
		this(message, time, null, null);
	}
	
	public Feed(String message, Date time, Double longitude, Double latitude){
		this.id = null;
		this.message = message;
		this.time = time;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	
	
	public Double getLatitude()
	{
		return latitude;
	}
	public void setLatitude(Double latitude)
	{
		this.latitude = latitude;
	}
	public Double getLongitude()
	{
		return longitude;
	}
	public void setLongitude(Double longitude)
	{
		this.longitude = longitude;
	}
	public long getId()
	{
		return id;
	}
	public String getMessage()
	{
		return message;
	}
	public Date getTime()
	{
		return time;
	}
	
	// TODO: Add equals and hashcode from Apache Commons Lang dependency
	
}
