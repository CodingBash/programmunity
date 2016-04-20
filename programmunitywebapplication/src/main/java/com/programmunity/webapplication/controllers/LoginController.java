package com.programmunity.webapplication.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView submitLogin(@Valid Coder coder, Errors errors)
	{
		if (errors.hasErrors())
		{
			return new ModelAndView("login");
		}
		ModelAndView mav = new ModelAndView("redirect: /dashboard");
		userRepository.saveUser(coder);
		bindContentToModel(mav);
		return mav;
	}

	// TODO: Implement Coder model
	public class Coder
	{
	}

	// TODO: Implement UserRepository service
	public class UserRepository
	{
		public void saveUser(Coder coder)
		{
		}

		// TODO: Implement exception
		public Object getMembers(long idStart, int count) throws Exception
		{
			// TODO Auto-generated method stub
			return null;
		}

		public Object getMember(long userId)
		{
			// TODO Auto-generated method stub
			return null;
		}
	}
}
