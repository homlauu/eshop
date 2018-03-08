package com.dao.impl;


import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.dao.UserDAO;
import com.model.User;

@Component("u")
public class UserDAOImpl extends SuperDAO implements UserDAO{
	
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}
	
}
