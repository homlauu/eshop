package com.dao;

import com.model.User;

public interface UserDAO {
	
	public void save(User user);
	public void delete();
}
