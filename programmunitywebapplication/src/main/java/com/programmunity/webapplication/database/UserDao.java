package com.programmunity.webapplication.database;

import java.util.List;

import com.programmunity.webapplication.models.TestUser;

public interface UserDao
{

	TestUser findByName(String name);

	List<TestUser> findAll();

}
