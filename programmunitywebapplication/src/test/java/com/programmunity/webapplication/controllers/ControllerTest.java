/**
 * 
 */
package com.programmunity.webapplication.controllers;

import java.util.Map;

/**
 * Controller test utilities
 * 
 * 
 * @author Basheer
 *
 */
public abstract class ControllerTest
{
	/**
	 * Construct a request string from a mapping and requestParameter
	 * 
	 * Expecting: "/mapping?key1=value1&key2=value2&key3=value3"
	 * 
	 * @deprecated
	 * 
	 * @param mapping
	 *            initial mapping
	 * @param requestParameters
	 *            request parameters
	 * @return request string
	 */
	protected String constructRequest(String mapping, Map<String, Object> requestParameters)
	{
		// Create StringBuilder to append entities
		StringBuilder requestBuilder = new StringBuilder();

		// Append mapping
		requestBuilder.append(mapping);

		// Boolean to determine first entry to prevent adding "&" to first
		boolean firstEntry = true;

		if (requestParameters != null)
		{
			// Iterate through all request parameters
			for (Map.Entry<String, Object> entry : requestParameters.entrySet())
			{
				/*
				 * Get data from map
				 */
				String key = entry.getKey();
				Object value = entry.getValue();

				// Add correct symbol depending on entry
				if (!firstEntry)
				{
					requestBuilder.append("&");
				} else
				{
					requestBuilder.append("?");
					firstEntry = false;
				}

				// Append the data
				requestBuilder.append(key).append("=").append(value);
			}
		}
		requestBuilder.append("/");

		return requestBuilder.toString();
	}
}
