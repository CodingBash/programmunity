package com.programmunity.webapplication.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Profile("developmentEnvironment")
@Configuration
public class DataConfigurationDevelopment
{
	@Bean
	public DataSource dataSource()
	{
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("db/sql/create-db.sql")
				.addScript("db/sql/userRoles.sql").addScript("db/sql/users.sql").addScript("db/sql/skills.sql")
				.addScript("db/sql/userSkillRelationship.sql").addScript("db/sql/feeds.sql")
				.addScript("db/sql/groups.sql").addScript("db/sql/groupRoles.sql").addScript("db/sql/directory.sql")
				.build();
	}
}
