package com.programmunity.webapplication.controllers;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 * Root of all controllers. Contains common methods for all controllers
 * 
 * @author Basheer
 *
 */
public abstract class BaseController
{

	/**
	 * Binds common content to {@link ModelAndView}
	 * 
	 * @param mav
	 */
	protected void bindContentToModel(ModelAndView mav)
	{

	}

	/**
	 * Binds common content to {@link Model}
	 * 
	 * @param model
	 */
	protected void bindContentToMode(Model model)
	{

	}
}
