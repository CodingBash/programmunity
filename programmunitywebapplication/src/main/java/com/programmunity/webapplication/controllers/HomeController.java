package com.programmunity.webapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller to implement mapping for home page "/"
 * 
 * @author Basheer
 *
 */
@RequestMapping("/")
@Controller
public class HomeController extends BaseController
{

	/**
	 * Maps GET "/" to home.html
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView onHome()
	{
		// Create ModelAndView and set view to "home"
		ModelAndView mav = new ModelAndView("home");
		
		// Insert consistent content to model
		bindContentToModel(mav);
		return mav;
	}
}
