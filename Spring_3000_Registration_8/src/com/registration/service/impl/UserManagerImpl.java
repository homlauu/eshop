package com.registration.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.registration.dao.UserDao;
import com.registration.model.User;
import com.registration.service.UserManager;
@Component("userManager")
public class UserManagerImpl implements UserManager {
	
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	@Resource
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
