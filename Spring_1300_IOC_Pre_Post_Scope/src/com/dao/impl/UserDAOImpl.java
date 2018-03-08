package com.dao.impl;

import org.springframework.stereotype.Component;

import com.dao.UserDAO;
import com.model.User;

@Component("u")
public class UserDAOImpl implements UserDAO{
	
	public void save(User user) {
		System.out.println("user saved!");
		
	}

}
