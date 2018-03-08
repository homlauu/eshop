package com.registration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.registration.service.impl.UserManagerImpl;

//ƶѪģ�ͣ��߼��٣�  ��Ѫģ�ͣ��߼��ࣩ
@Entity
public class User {
	
	private int id;
	private String username;
	private String password;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
//	public boolean exists() throws Exception {
//		return new UserManager().exists(this);
//	}
	
}
