package com.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.LogDAO;
import com.dao.UserDAO;
import com.model.Log;
import com.model.User;

@Component("userService") //不写() 默认为 类名首字母小写 UserService --> userService
public class UserService {
	
	private UserDAO userDAO;
	private LogDAO logDAO;
	
	public void init() {
		System.out.println("init");
	}
	
	@Transactional(readOnly = true)
	public User getUser(int id) {
		return null;
	}
	
/*
Enum Constant and Description

MANDATORY 
Support a current transaction, throw an exception if none exists.
 
NESTED 
Execute within a nested transaction if a current transaction exists, behave like PROPAGATION_REQUIRED else.
 
NEVER 
Execute non-transactionally, throw an exception if a transaction exists.
 
NOT_SUPPORTED 
Execute non-transactionally, suspend the current transaction if one exists.
 
REQUIRED 
Support a current transaction, create a new one if none exists.
 
REQUIRES_NEW 
Create a new transaction, suspend the current transaction if one exists.
 
SUPPORTS 
Support a current transaction, execute non-transactionally if none exists. 
*/
	//@Transactional(propagation=Propagation.REQUIRED) //默认REQUIRED ，如果已经有了transaction就用存在的那个，如果没有就创建一个连接
	//@Transactional(readOnly = true)
	public void add(User user) {
		
		userDAO.save(user);
		
		Log log = new Log();
		log.setMsg("a user saved!");
		logDAO.save(log);
		//runtime异常自动回滚
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	@Resource(name = "u")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public LogDAO getLogDAO() {
		return logDAO;
	}
	
	@Resource
	public void setLogDAO(LogDAO logDAO) {
		this.logDAO = logDAO;
	}
	
	public void destory() {
		System.out.println("destory");
	}
	
}
