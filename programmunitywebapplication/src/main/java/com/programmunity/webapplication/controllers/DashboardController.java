package com.programmunity.webapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.programmunity.webapplication.constants.ApplicationConstants;

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
		// Create ModelAndView and set view to "dashboard"
		ModelAndView mav = new ModelAndView(ApplicationConstants.pageFolder + "dashboard"); 
		
		// Insert consistent content to model
		bindContentToModel(mav);

		return mav;
	}
}
