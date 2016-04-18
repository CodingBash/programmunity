package com.programmunity.webapplication.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.programmunity.webapplication.database.UserRepository;
import com.programmunity.webapplication.models.User;

@Controller
@RequestMapping(value = "/programmunity")
public class FeedingController
{

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public ModelAndView showRegistrationForm()
	{
		return new ModelAndView("registrationForm");
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ModelAndView processRegister(@Valid User user, Errors errors)
	{
		if (errors.hasErrors())
		{
			return new ModelAndView("registrationForm");
		}

		ModelAndView mav = new ModelAndView("redirect:" + user.getUserName());
		userRepository.save(user);

		return mav;
	}

	@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
	public ModelAndView showProfile(@PathVariable("userName") String userName)
	{
		ModelAndView mav = new ModelAndView("profile");
		mav.addObject("user", userRepository.retrieve(userName));
		return mav;
	}

}
