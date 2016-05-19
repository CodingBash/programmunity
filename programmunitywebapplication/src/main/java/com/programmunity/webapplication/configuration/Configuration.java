package com.programmunity.webapplication.configuration;

import java.sql.SQLException;

import org.hibernate.validator.internal.metadata.raw.BeanConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@EnableWebMvc
@ComponentScan(basePackages = "com.programmunity.webapplication.controllers")
public class Configuration extends WebMvcConfigurerAdapter 
{
	
	
	@Bean(name = "h2WebServer", initMethod = "start", destroyMethod = "stop")
	public org.h2.tools.Server h2WebServer() throws SQLException
	{
		return org.h2.tools.Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082");
	}

	@Bean(initMethod = "start", destroyMethod = "stop")
	@DependsOn(value = "h2WebServer")
	public org.h2.tools.Server h2Server() throws SQLException
	{
		return org.h2.tools.Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
	}
	
	/**
	 * Configure the Thymeleaf template resolver
	 * 
	 * @return
	 */
	@Bean
	public TemplateResolver templateResolver() {
		TemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("/WEB-INF/views/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		return templateResolver;
	}

	/**
	 * Configure the Thymeleaf template engine using the Thymeleaf view resolver
	 * from {@link BeanConfiguration#templateResolver()}
	 * 
	 * @param templateResolver
	 * @return
	 */
	@Bean
	public TemplateEngine templateEngine(TemplateResolver templateResolver) {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		return templateEngine;
	}

	/**
	 * Configure the Thymeleaf view resolver using the Thymeleaf template engine
	 * from {@link BeanConfiguration#templateEngine(TemplateResolver)}
	 * 
	 * @param templateEngine
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine);
		return viewResolver;
	}

}
