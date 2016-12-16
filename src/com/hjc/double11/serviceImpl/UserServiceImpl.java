package com.hjc.double11.serviceImpl;

import org.springframework.stereotype.Service;

import com.hjc.double11.model.User;
import com.hjc.double11.service.UserService;

/*
 * 模块自身的业务逻辑
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Override
	public User login(User user) {
		return userDao.login(user);
	}

	@Override
	public boolean register(User user) {
		return userDao.register(user);
	}

}
