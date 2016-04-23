package com.programmunity.webapplication.database;

import java.util.List;

import com.programmunity.webapplication.exceptions.UserRetrievalException;
import com.programmunity.webapplication.exceptions.UserSaveException;
import com.programmunity.webapplication.models.User;

public interface UserRepository
{
	public void saveUser(User coder) throws UserSaveException;

	public List<User> getUsers(long idStart, int count) throws UserRetrievalException;

	public User getUser(long userId) throws UserRetrievalException;
}
