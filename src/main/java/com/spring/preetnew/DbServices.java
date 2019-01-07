package com.spring.preetnew;

import java.util.List;

public interface DbServices {

	public List<User> getUserList();
	
	public UserInfo getUserinfo(String email);
	
	public int insertUser(User user);

	int updateUser(User user);
	
	public List<User> checkEmail(String email);
	
}
