package com.hjc.double11.service;

import com.hjc.double11.model.User;

public interface UserService extends BaseService<User> {

	public User login(User user);
	
	public boolean register(User user);
	
}
