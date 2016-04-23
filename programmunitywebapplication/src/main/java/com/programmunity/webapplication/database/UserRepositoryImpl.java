package com.programmunity.webapplication.database;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Component;

import com.programmunity.webapplication.constants.SkillLevel;
import com.programmunity.webapplication.exceptions.UserRetrievalException;
import com.programmunity.webapplication.exceptions.UserSaveException;
import com.programmunity.webapplication.models.Skill;
import com.programmunity.webapplication.models.User;

@Component
public class UserRepositoryImpl implements UserRepository
{

	/**
	 * @see UserRepository#saveUser(User)
	 */
	@Override
	public void saveUser(User user) throws UserSaveException
	{

	}

	/**
	 * @see UserRepository#getUsers(long, int)
	 */
	@Override
	public List<User> getUsers(long idStart, int count) throws UserRetrievalException
	{
		List<User> userList = new ArrayList<User>(count);
		for (int i = 0; i <= count; i++)
		{
			User user = new User();

			user.setFirstName("firstName" + i);
			user.setLastName("lastName" + i);
			user.setUserName("username" + i);
			user.setPassword("password" + i);
			user.setEmail("email@email.com");
			user.setDescription(
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae ante pulvinar, fermentum magna luctus, accumsan urna. Donec purus neque, vestibulum quis ultricies non, euismod nec tellus. Sed cursus erat vitae interdum imperdiet. Mauris in posuere libero. In quis nisl sit amet nunc pulvinar semper non vitae ligula. Donec libero felis, elementum a ante a, auctor tempus arcu. Vestibulum non ante at lorem eleifend imperdiet nec at felis. Nulla vitae efficitur urna. Nullam mauris lacus, tincidunt a purus non, aliquam laoreet ex. Duis viverra risus ipsum, eu aliquet nunc sollicitudin vitae. Nam ligula odio, gravida laoreet blandit vel, tincidunt quis ligula. Vestibulum feugiat velit vel mauris consequat euismod. Donec tincidunt sagittis ultricies");
			Calendar cal = Calendar.getInstance();
			cal.set(1990, Calendar.JANUARY, i);
			user.setBirthdate(cal.getTime());

			List<Skill> skills = new ArrayList<Skill>();

			Skill javaSkill = new Skill();
			javaSkill.setSkill("Java");
			javaSkill.setLevel(SkillLevel.INTERMEDIATE);
			skills.add(javaSkill);

			Skill cppSkill = new Skill();
			cppSkill.setSkill("C++");
			cppSkill.setLevel(SkillLevel.BEGINNER);
			skills.add(cppSkill);

			Skill swiftSkill = new Skill();
			swiftSkill.setSkill("Swift");
			swiftSkill.setLevel(SkillLevel.BEGINNER);
			skills.add(swiftSkill);

			user.setSkills(skills);

			userList.add(user);
		}
		return userList;
	}

	/**
	 * @see UserRepository#getUser(long)
	 */
	@Override
	public User getUser(long userId) throws UserRetrievalException
	{
		// TODO Auto-generated method stub
		return null;
	}

}
