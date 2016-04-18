package com.programmunity.webapplication.controllers;

import org.springframework.web.servlet.ModelAndView;

public abstract class BaseController
{
	protected void bindContentToView(ModelAndView mav){
		mav.addObject("message", "Hello World");
	}
}
