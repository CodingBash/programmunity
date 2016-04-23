package com.programmunity.webapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.programmunity.webapplication.database.UserRepository;
import com.programmunity.webapplication.exceptions.UserRetrievalException;

/**
 * Controller for members page
 * 
 * @author Basheer
 *
 */
@RequestMapping("/members")
@Controller
public class MembersController extends BaseController
{

	@Autowired
	private UserRepository userRepository;

	/**
	 * Maps GET "/members" to members.html
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView members(@RequestParam(value = "idStart", defaultValue = "0") long idStart,
			@RequestParam(value = "count", defaultValue = "20") int count)
	{
		ModelAndView mav = new ModelAndView("members");
		bindContentToModel(mav);
		try
		{
			mav.addObject("members", userRepository.getUsers(idStart, count));
		} catch (UserRetrievalException e)
		{
			mav.addObject("error", e.getMessage());
			e.printStackTrace();
		}
		return mav;
	}
}
