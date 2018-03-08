package com.registration.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.registration.model.User;
import com.registration.service.UserManager;
import com.registration.vo.UserRegisterInfo;

/**
 * 传值 方式:
 * 属性
 * DomainModel
 * ModelDriven
 */
@Component("user")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven{
	
	/*
	private String username;
	private String password;
	private String password2;
	*/
	
	private UserRegisterInfo info = new UserRegisterInfo();
	private UserManager um;
	
	
	public UserManager getUm() {
		return um;
	}
	
	@Resource(name="userManager")
	public void setUm(UserManager um) {
		this.um = um;
	}

	@Override
	public String execute() throws Exception {
		User u = new User();
		u.setUsername(info.getUsername());
		u.setPassword(info.getPassword());
		if (um.exists(u)) {
			return "fail";
		}
		um.add(u);
		return "success";
		
	}
	
	
//    public UserRegisterInfo getModel() {  
//        if (UserRegisterInfo == null) {  
//        	info = new UserRegisterInfo();  
//        }  
//        return info;  
//    }  
    
	@Override
	public Object getModel() {
		return info;
	}
	
	
}
