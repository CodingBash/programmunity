package com.programmunity.webapplication.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("qaEnvironment")
@Configuration
public class DataConfigurationQA
{
	@Bean
	public BasicDataSource dataSource3()
	{
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:tcp://localhost/");
		ds.setUsername("username");
		ds.setPassword("password");
		ds.setInitialSize(5);
		ds.setMaxActive(10);
		return ds;
	}
}
