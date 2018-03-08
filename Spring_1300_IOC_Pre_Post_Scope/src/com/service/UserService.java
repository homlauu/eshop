package com.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dao.UserDAO;
import com.model.User;

@Component("userService") //不写() 默认为 类名首字母小写 UserService --> userService
public class UserService {
	
	private UserDAO userDAO;
	
	@PostConstruct
	public void init() {
		System.out.println("init");
	}
	
	public void add(User user) {
		userDAO.save(user);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	@Resource(name = "u")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@PreDestroy
	public void destory() {
		System.out.println("destory");
	}
	
}
