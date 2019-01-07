package com.spring.preetnew;

import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import interfaces.DbServices;
import mappers.InfoMapper;
import mappers.UserMapper;
import models.UpdateVerification;
import models.User;
import models.UserInfo;

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
	public UserInfo getUserInfo(String email) {
		// TODO Auto-generated method stub
		List<UserInfo> users = jdbcTemplate.query("select id,token from signup where email=?", new Object[] { email },
				new InfoMapper());
		if (users.size() > 0)
			return users.get(0);
		else
			return null;
	}

	public int insertUser(User user) {
		// TODO Auto-generated method stub
		// String sql = "INSERT INTO
		// signup(first_name,last_name,email,password,latitude,longitude,address,device_token,device_type)
		// VALUES ('aaa','bbb','aaa@gmail.com','123456','0','0','mohali 8
		// phase','qwerty_123456','ios')";
		// int rs = jdbcTemplate.update(sql);

		String token = UUID.randomUUID().toString();
		String sql = "INSERT INTO signup(first_name,last_name,email,latitude,longitude,address,device_token,device_type,"
				+ "social_id,company_name,token,image,job_title) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int rs = jdbcTemplate.update(sql,
				new Object[] { user.getFirst_name(), user.getLast_name(), user.getEmail(), user.getLatitude(),
						user.getLongitude(), user.getAddress(), user.getDevice_token(), user.getDevice_type(),
						user.getSocial_id(), user.getCompany_name(), token, user.getImage(), user.getJob_title() });

		return rs;
	}

	@Override
	public List<User> checkEmail(String email) {
		String sql = "select * from signup where email='" + email + "' ";
		List<User> user = jdbcTemplate.query(sql, new UserMapper());
		return user;
	}

	public int updateVerification(UpdateVerification updateVeri, String id) {

		String sql = "INSERT INTO update_verification(user_id,verified,quota_attainment,tracked,average_deal_size,average_sales_cycle,"
				+ "target_market,years_of_experiance,team_manager,team_manager_company_email,your_company_email,total_sales)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		int rs = jdbcTemplate.update(sql,
				new Object[] { id, "false", updateVeri.getQuota_attainment(), updateVeri.getTracked(),
						updateVeri.getAverage_deal_size(), updateVeri.getAverage_sales_cycle(),
						updateVeri.getTarget_market(), updateVeri.getYears_of_experiance(),
						updateVeri.getTeam_manager(), updateVeri.getTeam_manager_company_email(),
						updateVeri.getYour_company_email(), updateVeri.getTotal_sales() });

		return rs;
	}

	public boolean isHeaderValid(String authorization, String id) {

		String qry = "select * from signup where id='" + id + "' and token='" + authorization + "' ";
		List<User> user = jdbcTemplate.query(qry, new UserMapper());
		if (user.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public String updateToken(String user_id) {
		String token = UUID.randomUUID().toString();
		String sql = "UPDATE signup set token='" + token + "' where id='" + user_id + "' ";
		int res = jdbcTemplate.update(sql);
		if (res > 0) {
			return token;
		} else {
			return "";
		}

	}

}
