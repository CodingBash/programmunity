package com.programmunity.webapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for dashboard page
 * 
 * @author Basheer
 *
 */
@RequestMapping("/dashboard")
@Controller
public class DashboardController extends BaseController
{

	/**
	 * Maps GET "/dashboard" to dashboard.html
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView dashboard()
	{
		ModelAndView mav = new ModelAndView("/dashboard");
		bindContentToModel(mav);
		return mav;
	}
}
