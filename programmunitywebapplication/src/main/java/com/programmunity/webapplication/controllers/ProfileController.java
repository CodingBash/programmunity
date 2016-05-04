package com.programmunity.webapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.programmunity.webapplication.database.UserRepository;
import com.programmunity.webapplication.exceptions.UserRetrievalException;
import com.programmunity.webapplication.models.User;

/**
 * Controller for profile page
 * 
 * @author Basheer
 *
 */
@RequestMapping("/profile")
@Controller
public class ProfileController extends BaseController
{

	@Autowired
	private UserRepository userRepository;

	/**
	 * Maps GET "/profile/{userId}" to profile.html
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ModelAndView getUserProfile(@PathVariable("userId") long userId)
	{
		// Create ModelAndView and set view to "profile"
		ModelAndView mav = new ModelAndView("profile");

		// Insert consistent content to model
		bindContentToModel(mav);
		try
		{
			// Retrieve user from repository using request parameter
			User retrievedUser = userRepository.getUser(userId);

			// Insert user to model
			mav.addObject("user", retrievedUser);
		} catch (UserRetrievalException e)
		{
			// Add error to model
			mav.addObject("error", e.getMessage());
			e.printStackTrace();
		}

		return mav;
	}
}
