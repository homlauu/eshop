package com.dao.impl;

import com.dao.UserDAO;
import com.model.User;

public class UserDAOImpl2 extends UserDAOImpl {
	
	@Override
	public void save(User user) {
		System.out.println("save start...");
		super.save(user);
	}

}
