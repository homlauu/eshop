package com.registration.action;

import org.junit.Assert;
import org.junit.Test;

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

}
