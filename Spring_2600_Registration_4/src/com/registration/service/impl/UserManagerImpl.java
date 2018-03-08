package com.registration.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.registration.dao.UserDao;
import com.registration.dao.impl.UserDaoImpl;
import com.registration.model.User;
import com.registration.service.UserManager;
import com.registration.util.HibernateUtil;

public class UserManagerImpl implements UserManager {
	
	private UserDao userDao = new UserDaoImpl();
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/* (non-Javadoc)
	 * @see com.registration.service.impl.UserManager#exists(com.registration.model.User)
	 */
	@Override
	public boolean exists(User u) throws Exception {
		return userDao.checkUserExistsWithName(u.getUsername());
	}
	
	
	/* (non-Javadoc)
	 * @see com.registration.service.impl.UserManager#add(com.registration.model.User)
	 */
	@Override
	public void add(User u) throws Exception {
		userDao.save(u);
	}
	
}
