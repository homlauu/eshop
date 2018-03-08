package com.service;

import javax.annotation.Resource;

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
	
	//@Resource(name="u")
	@Resource  //默认按名字   userDAO ；如果beans.xml 里面没有userDAO 且 UserDAO 有两个映射 则报错
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void destory() {
		System.out.println("destory");
	}
	
}
