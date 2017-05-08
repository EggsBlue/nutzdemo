package com.huage.dao.impl;

import org.nutz.ioc.loader.annotation.IocBean;

import com.huage.dao.UserDao;

@IocBean(name="userDao")
public class UserDaoImpl implements UserDao {

	@Override
	public void findall() {
		System.out.println("findall....");
	}

}
