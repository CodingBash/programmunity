package com.programmunity.webapplication.database;

import java.util.List;

import com.programmunity.webapplication.exceptions.UserRetrievalException;
import com.programmunity.webapplication.exceptions.UserSaveException;
import com.programmunity.webapplication.models.User;

/**
 * Repository for accessing services for user information
 * 
 * @author Basheer
 *
 */
public interface UserRepository
{
	/**
	 * Saves a user to the database
	 * 
	 * @param coder
	 * @throws UserSaveException
	 */
	public void saveUser(User user) throws UserSaveException;

	// TODO: Define start ID
	/**
	 * Get a amount of users from the start Id
	 * 
	 * @param idStart
	 *            id to start
	 * 
	 * @param count
	 *            amount of users to retrieve
	 * @return
	 * @throws UserRetrievalException
	 */
	public List<User> getUsers(long idStart, int count) throws UserRetrievalException;

	/**
	 * Retrieves a user
	 * 
	 * @param userId
	 * @return
	 * @throws UserRetrievalException
	 */
	public User getUser(long userId) throws UserRetrievalException;
}
