package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import models.UserInfo;

public class InfoMapper implements RowMapper<UserInfo> {

	public UserInfo mapRow(ResultSet rs, int arg1) throws SQLException {

		UserInfo info = new UserInfo();
		info.setToken(rs.getString("token"));
		info.setUser_id(rs.getString("id"));

		return info;
	}

}
