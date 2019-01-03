package com.spring.preetnew;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("DbServices")
public class DbServiceImpl implements DbServices {

	JdbcTemplate jdbcTemplate;

	@Autowired
	public DbServiceImpl(DataSource dataSource) {
		// TODO Auto-generated constructor stub
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		List<User> users = jdbcTemplate.query("select * from users", new UserMapper());
		if (users.size() > 0)
			return users;
		else
			return null;
	}

	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		List<User> users = jdbcTemplate.query("select * from users where device_id=?", new Object[] { id },new UserMapper());
		if (users.size() > 0)
			return users.get(0);
		else
			return null;
	}

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		// INSERT INTO users(device_id, token) VALUES ('hgcyc','gvfgyvfg');
		String sql = "INSERT INTO users(device_id, token) VALUES ('"+user.getDeviceId()+"','"+user.getToken()+"')";
		int rs = jdbcTemplate.update(sql);
		return rs;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		String sql = "UPDATE `users` SET `token`=? WHERE `device_id`=?";
		int res=jdbcTemplate.update(sql,user.getToken(),user.getDeviceId());
		return res;
	}
	
	@Override
	public void createTable() {
		
	}

}
