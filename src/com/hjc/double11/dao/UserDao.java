package com.hjc.double11.dao;

import com.hjc.double11.model.User;

public interface UserDao extends BaseDao<User> {

	public User login(User user);
	
	public boolean register(User user);
}
