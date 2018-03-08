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
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		UserService service = (UserService) ctx.getBean("userService");
		UserService service2 = (UserService) ctx.getBean("userService");
		
		
		ctx.destroy();
		
	}

}
