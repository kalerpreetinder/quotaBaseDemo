package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import models.User;

public class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setFirst_name(rs.getString("first_name"));
		user.setLast_name(rs.getString("last_name"));
		user.setEmail(rs.getString("email"));
		user.setLatitude(rs.getString("latitude"));
		user.setLongitude(rs.getString("longitude"));
		user.setAddress(rs.getString("address"));
		user.setDevice_token(rs.getString("device_token"));
		user.setDevice_type(rs.getString("device_type"));
		user.setSocial_id(rs.getString("social_id"));
		user.setCompany_name(rs.getString("company_name"));
		
		return user;
	}
}
