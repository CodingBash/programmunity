package com.programmunity.webapplication.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.programmunity.webapplication.models.TestUser;

@Repository
public class UserDaoImpl implements UserDao
{

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
	{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public TestUser findByName(String username)
	{

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", username);

		String sql = "SELECT * FROM users WHERE username=:username";

		TestUser result = namedParameterJdbcTemplate.queryForObject(sql, params, new UserMapper());

		// new BeanPropertyRowMapper(Customer.class));

		return result;

	}

	@Override
	public List<TestUser> findAll()
	{

		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM users";

		List<TestUser> result = namedParameterJdbcTemplate.query(sql, params, new UserMapper());

		return result;

	}

	private static final class UserMapper implements RowMapper<TestUser>
	{

		public TestUser mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			TestUser user = new TestUser();
			user.setId(rs.getInt("id"));
			user.setUserName(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			return user;
		}
	}

}