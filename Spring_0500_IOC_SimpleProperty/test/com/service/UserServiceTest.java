package com.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.User;

public class UserServiceTest {

	@Test
	public void test() {
		//BeanFactory applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		
		UserService service = (UserService) applicationContext.getBean("userService");
		
		User u = new User();
		u.setUsername("zhangsan");
		u.setPassword("zhangsan");
		service.add(u);
		
	}

}
