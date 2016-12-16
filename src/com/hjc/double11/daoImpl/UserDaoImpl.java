package com.hjc.double11.daoImpl;

import org.springframework.stereotype.Repository;

import com.hjc.double11.dao.UserDao;
import com.hjc.double11.model.User;

/*
 * 模块自身的业务逻辑
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User login(User user) {
		String hql = "FROM User u WHERE u.name=:name AND u.pass=:pass";
		return (User)getSession().createQuery(hql)
				.setString("name", user.getName())
				.setString("pass", user.getPass())
				.uniqueResult();
	}

	@Override
	public boolean register(User user) {
		save(user);
		return true;
	}

}
