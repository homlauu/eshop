package com.registration.service;

import java.util.List;

import com.registration.model.User;

public interface UserManager {

	public abstract boolean exists(User u) throws Exception;

	public abstract void add(User u) throws Exception;
	
	public abstract List<User> getUsers() throws Exception;

	
}