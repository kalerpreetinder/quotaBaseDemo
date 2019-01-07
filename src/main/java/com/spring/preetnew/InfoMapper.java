package com.spring.preetnew;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class InfoMapper implements RowMapper<UserInfo>{

	public class UserMapper implements RowMapper<UserInfo> {
		public UserInfo mapRow(ResultSet rs, int arg1) throws SQLException {
			
			UserInfo info = new UserInfo();
			info.setToken(rs.getString("token"));
			info.setUser_id(rs.getString("id"));
			
			return info;
		}
	}

	@Override
	public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		UserInfo info = new UserInfo();
		info.setToken(rs.getString("token"));
		info.setUser_id(rs.getString("id"));
		
		return info;
	
	}

	
}
