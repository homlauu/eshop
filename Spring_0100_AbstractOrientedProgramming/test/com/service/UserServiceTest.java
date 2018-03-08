package com.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.model.User;
import com.spring.BeanFactory;
import com.spring.ClassPathXmlApplicationContext;

public class UserServiceTest {

	@Test
	public void test() throws Exception {
		BeanFactory applicationContext = new ClassPathXmlApplicationContext();
		
		UserService service = (UserService) applicationContext.getBean("userService");
		
		User u = new User();
		u.setUsername("zhangsan");
		u.setPassword("zhangsan");
		service.add(u);
	}

}
