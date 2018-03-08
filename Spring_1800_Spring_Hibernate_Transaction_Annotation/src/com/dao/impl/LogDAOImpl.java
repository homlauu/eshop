package com.dao.impl;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Component;

import com.dao.LogDAO;
import com.model.Log;

@Component("LogDAO")
public class LogDAOImpl implements LogDAO {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void save(Log log) {
		Session s = sessionFactory.getCurrentSession();
		System.out.println(s.hashCode());
		s.save(log);
		//throw new RuntimeException("error!");
	}

}
