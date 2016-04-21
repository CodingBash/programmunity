package com.programmunity.webapplication.database;

import java.util.List;

import com.programmunity.webapplication.models.User;

public interface UserRepository
{
	public void saveUser(User coder);

	public List<User> getUsers(long idStart, int count) throws Exception;

	public User getUser(long userId);
}
