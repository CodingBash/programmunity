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
		ModelAndView mav = new ModelAndView("login");
		bindContentToModel(mav);
		return mav;
	}

	/**
	 * Login form submit. Redirect to /dashboard
	 * 
	 * @param coder
	 * @param errors
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submitLogin(@Valid User coder, Errors errors)
	{
		if (errors.hasErrors())
		{
			return new ModelAndView("login");
		}
		ModelAndView mav = new ModelAndView("redirect: /dashboard");
		try
		{
			userRepository.saveUser(coder);
		} catch (UserSaveException e)
		{
			mav.addObject("error", e.getMessage());
			e.printStackTrace();
		}
		bindContentToModel(mav);
		return mav;
	}

}
