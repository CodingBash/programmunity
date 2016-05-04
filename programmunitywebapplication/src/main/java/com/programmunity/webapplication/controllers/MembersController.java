package com.programmunity.webapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.programmunity.webapplication.database.UserRepository;
import com.programmunity.webapplication.exceptions.UserRetrievalException;
import com.programmunity.webapplication.models.User;

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
		// Create ModelAndView and set view to "members"
		ModelAndView mav = new ModelAndView("members");

		// Insert consistent content to model
		bindContentToModel(mav);
		try
		{
			List<User> retrievedUserList = userRepository.getUsers(idStart, count);
			mav.addObject("members", retrievedUserList);
		} catch (UserRetrievalException e)
		{

			// Add error message to model
			mav.addObject("error", e.getMessage());
			e.printStackTrace();
		}

		return mav;
	}
}
