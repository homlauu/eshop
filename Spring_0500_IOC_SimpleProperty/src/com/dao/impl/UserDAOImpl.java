package com.dao.impl;

import com.dao.UserDAO;
import com.model.User;

public class UserDAOImpl implements UserDAO{

	private int daoId;
	private String daoStatus;
	
	public int getDaoId() {
		return daoId;
	}

	public void setDaoId(int daoId) {
		this.daoId = daoId;
	}

	public String getDaoStatus() {
		return daoStatus;
	}

	public void setDaoStatus(String daoStatus) {
		this.daoStatus = daoStatus;
	}

	public void save(User user) {
		System.out.println("user saved!");
		
	}
	
	@Override
	public String toString() {
		//return "UserDAOImpl [daoId=" + daoId + ", daoStatus=" + daoStatus + "]";
		return this.daoId + ":" + this.daoStatus;
	}
	
	
}
