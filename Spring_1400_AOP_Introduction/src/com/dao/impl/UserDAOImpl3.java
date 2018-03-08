package com.dao.impl;

import com.aop.LogInterceptor;
import com.dao.UserDAO;
import com.model.User;

public class UserDAOImpl3 implements UserDAO {
	
	private UserDAO userDAO = new UserDAOImpl();
	
	@Override
	public void save(User user) {
		new LogInterceptor().beforeMethod( null);
		userDAO.save(user);
	}

	@Override
	public void delete() {
		System.out.println("user deleted!");
		
	}

}
