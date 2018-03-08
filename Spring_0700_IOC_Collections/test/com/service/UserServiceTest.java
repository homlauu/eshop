package com.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.UserDAO;
import com.model.User;

public class UserServiceTest {

	@Test
	public void test() {
		//BeanFactory applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		
		UserDAO u1 = (UserDAO) applicationContext.getBean("userDAO");
		
		System.out.println(u1);
		
		
	}

}
