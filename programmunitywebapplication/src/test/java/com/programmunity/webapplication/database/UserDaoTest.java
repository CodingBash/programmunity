package com.programmunity.webapplication.database;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;

import com.programmunity.webapplication.configuration.DataConfigurationDevelopment;
import com.programmunity.webapplication.models.TestUser;

import junit.framework.Assert;

public class UserDaoTest
{

	private EmbeddedDatabase db;
	private UserDaoImpl userDao;

	@Before
	public void setup()
	{
		db = (EmbeddedDatabase) new DataConfigurationDevelopment().dataSource();
	}

	@Test
	public void testFindByName()
	{
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
		userDao = new UserDaoImpl();
		userDao.setNamedParameterJdbcTemplate(template);
		TestUser user = userDao.findByName("bash");

		Assert.assertNotNull(user);
		Assert.assertEquals(1, user.getId().intValue());
		Assert.assertEquals("bash", user.getUserName());
		Assert.assertEquals("bashpass", user.getPassword());
	}

	@After
	public void tearDown()
	{
		db.shutdown();
	}
}
