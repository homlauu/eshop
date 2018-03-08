package com.registration.service;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.registration.model.User;
import com.registration.service.impl.UserManagerImpl;

public class UserManagerTest {

	@Test
	public void testExists() throws Exception {
		UserManager um = new UserManagerImpl();
		User u = new User();
		u.setUsername("a");
		boolean exists = um.exists(u);
		Assert.assertEquals(true, exists);
		// System.out.println(exists);
	}

	@Test
	public void testAdd() throws Exception {
		UserManager um = new UserManagerImpl();
		User u = new User();
		u.setUsername("c");
		u.setPassword("c");
		boolean exists = um.exists(u);

		if (!exists) {
			um.add(u);
			u.setUsername("b");
			Assert.assertEquals(true, um.exists(u));
		} else {
			Assert.fail("not added");
		}

	}

}
