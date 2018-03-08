package com.registration.dao;

import com.registration.model.User;

public interface UserDao {
	
	public void save(User u);

	public boolean checkUserExistsWithName(String name);
	
}
