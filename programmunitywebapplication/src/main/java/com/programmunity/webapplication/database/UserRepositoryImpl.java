package com.programmunity.webapplication.database;

import org.springframework.stereotype.Component;

import com.programmunity.webapplication.models.User;

@Component
public class UserRepositoryImpl implements UserRepository
{

	@Override
	public void save(User user)
	{
		// TODO Dao
	}

	@Override
	public User retrieve(String userName)
	{
		User user = new User();
		user.setFirstName("Bash");
		user.setLastName("B");
		user.setPassword("myPass");
		user.setUserName(userName);
		return user;
	}

}
