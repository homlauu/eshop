package com.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class SuperDAO extends HibernateDaoSupport{
	
//	@Resource(name="hibernateTemplate")
//	public void setSuperHibernateTemplate(HibernateTemplate hibernateTemplate) {
//		super.setHibernateTemplate(hibernateTemplate);
//	}

	@Resource(name="sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
}
