package com.spring.preetnew;

import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.spring.preetnew")
@EnableWebMvc

public class MvcConfigration extends WebMvcConfigurerAdapter {

	public final static String JDBC_URL = "jdbc:mysql://localhost:3306/pusher_app";
	public final static String JDBC_USER = "root";
	public final static String JDBC_PASSWORD = "redhat";
	// public final static String JDBC_PASSWORD = "p@@p!";
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public BasicDataSource getDataSource() throws URISyntaxException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// String username = "", password = "", dbUrl = "";
	
			// dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			 URI dbUri = new URI(System.getenv("DATABASE_URL"));

			
			  String username = dbUri.getUserInfo().split(":")[0];
			  String password = dbUri.getUserInfo().split(":")[1]; 
			  String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
			 
//			String dbUrl = System.getenv("JDBC_DATABASE_URL");
//			String username = System.getenv("JDBC_DATABASE_USERNAME");
//			String password = System.getenv("JDBC_DATABASE_PASSWORD");

			BasicDataSource basicDataSource = new BasicDataSource();

			basicDataSource.setUrl(dbUrl);
			basicDataSource.setUsername(username);
			basicDataSource.setPassword(password);

	

		return basicDataSource;
	}

	@Bean
	public DbServices getDbServices() throws URISyntaxException {
		return new DbServiceImpl(getDataSource());
	}

}
