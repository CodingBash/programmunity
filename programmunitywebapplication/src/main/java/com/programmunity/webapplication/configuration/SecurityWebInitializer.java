package com.programmunity.webapplication.configuration;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Configures the servlet filter for spring security. All requests sent to the
 * application will go to the "springSecurityFilterhain" bean.
 * 
 * Refer to @{link SecurityConfig} for specified spring security configuration
 * for the web application.
 * 
 * @author Bash
 *
 */
public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer
{

}
