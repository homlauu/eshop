package com.registration.action;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.registration.vo.UserRegisterInfo;

public class UserActionTest {

	@Test
	public void testExecute() throws Exception {
		
		UserAction ua = new UserAction();
		UserRegisterInfo info = new UserRegisterInfo();
		info.setUsername("x");
		info.setPassword("x");
		info.setPassword2("x");
//		ua.setInfo(info);
		String ret = ua.execute();
		Assert.assertEquals("success", ret);
		
	}

	@Test
	public void testList() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserAction ua = (UserAction) ctx.getBean("user");
		
//		String l = ua.list();
//		Assert.assertTrue(l.length() > 0);
		ua.list();
		Assert.assertTrue(ua.getUsers().size() > 0);
		
		//http://localhost:8080/Spring_3100_Registration_9/user!list.action
		
	}
	
}
