package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.dao.UserDAO;
import com.model.User;

public class UserService {
	
	private UserDAO userDAO;
	
	public void init() {
		System.out.println("init");
	}
	
	public void add(User user) {
		userDAO.save(user);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	@Autowired
	public void setUserDAO(@Qualifier("u") UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void destory() {
		System.out.println("destory");
	}
	
}
