package com.dao.impl;


import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Component;

import com.dao.UserDAO;
import com.model.User;

@Component("u")
public class UserDAOImpl implements UserDAO{
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(User user) {

		System.out.println("session factory class:" + sessionFactory.getClass());
		
//		Session s = sessionFactory.getCurrentSession();
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.save(user);
		s.getTransaction().commit();
		System.out.println("user saved!");

	}
	
	
	
	
//	private DataSource dataSource;
//	
//	public DataSource getDataSource() {
//		return dataSource;
//	}
//	
//	@Resource //默认按名称查找  <bean id="dataSource"  // 找不到按类型
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
//
//	public void save(User user) {
//		try {
//			Connection conn = dataSource.getConnection();
//			conn.createStatement().execute("insert into user values(null,'zs')");
//			conn.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//		}
//		
//		System.out.println("user saved!");
//		
//		//throw new RuntimeException("exception!"); //@AfterThrowing("myMethod()")
//		
//	}
	
	
}
