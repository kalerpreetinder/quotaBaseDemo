package com.spring.preetnew;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setId(rs.getString("id"));
		user.setToken(rs.getString("token"));
		user.setDeviceId(rs.getString("device_id"));
		return user;
	}
}
