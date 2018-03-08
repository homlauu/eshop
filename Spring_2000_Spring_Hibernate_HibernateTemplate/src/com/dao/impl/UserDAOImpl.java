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
public class UserDAOImpl implements UserDAO{
	
	private HibernateTemplate hibernateTemplate;
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void save(User user) {
		hibernateTemplate.save(user);
	}
	
	
//	public void save(User user) {
//		
//		Session s = null;
//		try {
//			s = sessionFactory.openSession();
//			s.getTransaction().begin();
//			System.out.println(s.hashCode());
//			s.save(user);
//		} catch (HibernateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			s.getTransaction().rollback();
//		} finally {
//			if (s != null)
//				s.close();
//			s = null;
//		}
//	}
	
	
}
