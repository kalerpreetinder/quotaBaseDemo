package com.spring.preetnew;

import java.util.List;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("DbServices")
public class DbServiceImpl implements DbServices {

	JdbcTemplate jdbcTemplate;

	@Autowired
	public DbServiceImpl(BasicDataSource dataSource) {
		// TODO Auto-generated constructor stub
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		List<User> users = jdbcTemplate.query("select * from user", new UserMapper());
		if (users.size() > 0)
			return users;
		else
			return null;
	}

	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		List<User> users = jdbcTemplate.query("select * from user where device_id=?", new Object[] { id },new UserMapper());
		if (users.size() > 0)
			return users.get(0);
		else
			return null;
	}

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `user`(`device_id`, `token`) VALUES (?,?)";
		int rs = jdbcTemplate.update(sql, user.getDeviceId(), user.getToken());
		return rs;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		String sql = "UPDATE `user` SET `token`=? WHERE `device_id`=?";
		int res=jdbcTemplate.update(sql,user.getToken(),user.getDeviceId());
		return res;
	}

}
