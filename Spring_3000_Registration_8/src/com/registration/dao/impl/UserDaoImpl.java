package com.registration.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.registration.dao.UserDao;
import com.registration.model.User;
@Component("userDao")
public class UserDaoImpl implements UserDao {
	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void save(User u) {
		hibernateTemplate.save(u);
	}
	
	public boolean checkUserExistsWithName(String username) {
		List<User> users = hibernateTemplate.find("from User u where u.username = '" + username + "'");
		
		if (users != null && users.size() > 0)
			return true;
		
		return false;
		
	}

}
