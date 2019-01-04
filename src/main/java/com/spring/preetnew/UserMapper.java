package com.spring.preetnew;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setFirst_name("first_name");
		user.setLast_name("last_name");
		user.setEmail("email");
		user.setPassword("password");
		user.setLatitude("latitude");
		user.setLongitude("longitude");
		user.setAddress("address");
		user.setDevice_token("device_token");
		user.setDevice_type("device_type");
		
		return user;
	}
}
