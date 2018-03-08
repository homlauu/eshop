package com.registration.action;

import org.junit.Assert;
import org.junit.Test;

public class UserActionTest {

	@Test
	public void testExecute() throws Exception {
		UserAction ua = new UserAction();
		ua.setUsername("g");
		ua.setPassword("g");
		String ret = ua.execute();
		Assert.assertEquals("success", ret);
		
	}

}
