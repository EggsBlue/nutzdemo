package com.huage.service.impl;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.huage.dao.UserDao;
import com.huage.service.UserService;

@IocBean(name="userService")
public class UserServiceImpl implements UserService {

	@Inject
	private UserDao userDao;
	
	@Override
	public void findall() {
		userDao.findall();
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
