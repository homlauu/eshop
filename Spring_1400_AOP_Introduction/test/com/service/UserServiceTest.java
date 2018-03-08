package com.service;

import static org.junit.Assert.*;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.aop.LogInterceptor;
import com.dao.UserDAO;
import com.dao.impl.UserDAOImpl;
import com.model.User;
import com.spring.BeanFactory;
import com.spring.ClassPathXmlApplicationContext;

public class UserServiceTest {

//	@Test
//	public void test() throws Exception {
//		BeanFactory applicationContext = new ClassPathXmlApplicationContext();
//		
//		UserService service = (UserService) applicationContext.getBean("userService");
//		
//		User u = new User();
//		u.setUsername("zhangsan");
//		u.setPassword("zhangsan");
//		service.add(u);
//	}

	@Test
	public void testProxy() {
		
		UserDAO userDAO = new UserDAOImpl();
		LogInterceptor li = new LogInterceptor();
		li.setTarget(userDAO);
		
		UserDAO userDAOProxy = (UserDAO) Proxy.newProxyInstance(userDAO.getClass().getClassLoader(), new Class[]{UserDAO.class}, li );
		
		System.out.println(userDAOProxy.getClass());
		System.out.println(userDAOProxy.getClass().getInterfaces());
		System.out.println(userDAOProxy.getClass().getMethods());
		
		userDAOProxy.delete();
		userDAOProxy.save(new User());
		
	}
}
