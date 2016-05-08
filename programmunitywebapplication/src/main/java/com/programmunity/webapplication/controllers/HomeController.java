package com.programmunity.webapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.programmunity.webapplication.database.GroupRepository;
import com.programmunity.webapplication.models.Group;

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
	
	@Autowired
	private GroupRepository groupRepository;

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
		
		List<Group> retrievedTopGroups = groupRepository.retrieveTopGroups(3);
		
		mav.addObject("unities", retrievedTopGroups);
		
		return mav;
	}
}
