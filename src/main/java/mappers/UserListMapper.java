package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import models.UserList;

public class UserListMapper implements RowMapper<UserList>{

	public UserList mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		UserList userList = new UserList();
		userList.setUser_id(rs.getString("id"));
		userList.setName(rs.getString("first_name") +" "+ rs.getString("last_name"));
		userList.setCompany_name(rs.getString("company_name"));
		userList.setImage(rs.getString("image"));
		userList.setVerified(rs.getString("verified"));
		
		return userList;
	}

}
