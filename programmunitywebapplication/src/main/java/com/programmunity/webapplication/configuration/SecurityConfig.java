/**
 * 
 */
package com.programmunity.webapplication.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Security configuration for application.
 * 
 * "EnableWebSecurity" configures Spring MVC argument resolver so handler
 * methods and receive authenticate user's username. Also adds CSRF fields to
 * forms.
 * 
 * @author Bash
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

	/**
	 * Configures user-details services
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		/*
		 * inMemoryAuthentication() enables an in-memory user store withUser()
		 * adds user password() sets password roles() sets roles
		 */
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and().withUser("admin")
				.password("password").roles("USER", "ADMIN");
	}

	/**
	 * Configures how requests are secured by interceptors
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.formLogin().and().authorizeRequests().antMatchers(HttpMethod.POST, "/dashboard").hasRole("USER")
				.anyRequest().permitAll().and().requiresChannel().antMatchers("/login").requiresSecure()
				.antMatchers("/").requiresInsecure();
	}
}
