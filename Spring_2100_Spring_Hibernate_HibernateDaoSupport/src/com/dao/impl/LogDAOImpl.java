package com.dao.impl;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.dao.LogDAO;
import com.model.Log;

@Component("logDAO")
public class LogDAOImpl extends AbstractDAO implements LogDAO {
	
	public void save(Log log) {
		this.getHibernateTemplate().save(log);
		//this.save(log);
		//throw new RuntimeException("error!");
	}

}
