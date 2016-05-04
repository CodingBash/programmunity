package com.programmunity.webapplication.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.programmunity.webapplication.database.UserRepository;
import com.programmunity.webapplication.exceptions.UserSaveException;
import com.programmunity.webapplication.models.User;

/**
 * Controller that hands login page
 * 
 * @author Basheer
 *
 */
@RequestMapping("/login")
@Controller
public class LoginController extends BaseController
{

	/**
	 * Repository for reading and writing users
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * Maps GET "/login" to login.html
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getLoginPage()
	{

		// Create ModelAndView and set view to "login"
		ModelAndView mav = new ModelAndView("login");

		// Insert consistent content to model
		bindContentToModel(mav);
		return mav;
	}

	// TODO: This seems like the code for registration. . .
	/**
	 * Login form submit. Redirect to /dashboard
	 * 
	 * @param user
	 * @param errors
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submitLogin(@Valid User user, Errors errors)
	{
		// Check if validation has errors
		if (errors.hasErrors())
		{
			// TODO: Add login model variables for error?
			// If it does, go back to login page
			return new ModelAndView("login");
		}

		// Create ModelAndView and set view to redirect link
		ModelAndView mav = new ModelAndView("redirect: /dashboard");

		try
		{
			// Save user in repository
			userRepository.saveUser(user);
		} catch (UserSaveException e)
		{
			// If error saving, add error
			mav.addObject("error", e.getMessage());
			e.printStackTrace();
		}

		// Insert consistent content to model
		bindContentToModel(mav);

		return mav;
	}

}
