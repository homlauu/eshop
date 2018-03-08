package com.dao.impl;

import com.dao.UserDAO;
import com.model.User;

public class UserDAOImpl implements UserDAO{
	
	public void save(User user) {
		// Hibernate
		// JDBC
		// XML
		// NetWork
		System.out.println("user saved!");
		
	}

	@Override
	public void delete() {
		System.out.println("user deleted!");
		
	}

}
