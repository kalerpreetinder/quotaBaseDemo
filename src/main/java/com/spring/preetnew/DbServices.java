package com.spring.preetnew;

import java.util.List;

public interface DbServices {

public List<User> getUserList();
	
	public User getUser(String id);
	
	public int insertUser(User user);

	int updateUser(User user);
	
	public void createTable();
	
}
