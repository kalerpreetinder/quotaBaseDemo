package com.spring.preetnew;

import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

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
	public UserInfo getUserinfo(String email) {
		// TODO Auto-generated method stub
		List<UserInfo> users = jdbcTemplate.query("select id,token from signup where email=?", new Object[] { email },
				new InfoMapper());
		if (users.size() > 0)
			return users.get(0);
		else
			return null;
	}

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		// String sql = "INSERT INTO
		// signup(first_name,last_name,email,password,latitude,longitude,address,device_token,device_type)
		// VALUES ('aaa','bbb','aaa@gmail.com','123456','0','0','mohali 8
		// phase','qwerty_123456','ios')";
		// int rs = jdbcTemplate.update(sql);
		String token = "";
		token = UUID.randomUUID().toString();
		String sql = "INSERT INTO signup(first_name,last_name,email,latitude,longitude,address,device_token,device_type,social_id,company_name,token,image) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		int rs = jdbcTemplate.update(sql,
				new Object[] { user.getFirst_name(), user.getLast_name(), user.getEmail(), user.getLatitude(),
						user.getLongitude(), user.getAddress(), user.getDevice_token(), user.getDevice_type(),
						user.getSocial_id(), user.getCompany_name(), token, user.getImage() });

		return rs;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		// String sql = "UPDATE `users` SET `token`=? WHERE `device_id`=?";
		// int res=jdbcTemplate.update(sql,new Object[]
		// {user.getToken(),user.getDeviceId()});
		return 1;
	}

	@Override
	public List<User> checkEmail(String email) {
		String sql = "select * from signup where email='" + email + "' ";
		List<User> user = jdbcTemplate.query(sql, new UserMapper());
		return user;
	}

}
