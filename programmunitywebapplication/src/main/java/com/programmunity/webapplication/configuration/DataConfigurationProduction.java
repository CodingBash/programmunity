package com.programmunity.webapplication.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jndi.JndiObjectFactoryBean;

@Profile("productionEnvironment")
@Configuration
public class DataConfigurationProduction
{
	@Bean
	public JndiObjectFactoryBean dataSource2()
	{
		JndiObjectFactoryBean jndiObjectFB = new JndiObjectFactoryBean();
		jndiObjectFB.setJndiName("jdbc/SpitterDS");
		jndiObjectFB.setResourceRef(true);
		jndiObjectFB.setProxyInterface(DataSource.class);
		return jndiObjectFB;
	}
}
