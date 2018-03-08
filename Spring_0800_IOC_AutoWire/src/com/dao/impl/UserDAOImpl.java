package com.dao.impl;

import com.dao.UserDAO;
import com.model.User;

public class UserDAOImpl implements UserDAO{

	private int daoId;
	
	public int getDaoId() {
		return daoId;
	}

	public void setDaoId(int daoId) {
		this.daoId = daoId;
	}
	
	public void save(User user) {
		System.out.println("user saved!");
		
	}
	
	@Override
	public String toString() {
		return "daoId=" + this.daoId;
	}
	
}
