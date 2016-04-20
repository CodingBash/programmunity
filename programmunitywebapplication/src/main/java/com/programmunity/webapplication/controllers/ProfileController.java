package com.programmunity.webapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.programmunity.webapplication.controllers.LoginController.UserRepository;

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
		ModelAndView mav = new ModelAndView("profile");
		bindContentToModel(mav);
		mav.addObject("coder", userRepository.getMember(userId));
		return mav;
	}
}
