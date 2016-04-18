package com.programmunity.webapplication.database;

import com.programmunity.webapplication.models.User;

public interface UserRepository
{
	
	
	public void save(User user);

	public User retrieve(String userName);
}
