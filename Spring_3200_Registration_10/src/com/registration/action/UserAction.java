package com.registration.action;

import java.util.List;

import javax.annotation.Resource;

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
//@Component("user") 与 setUser 冲突  可不写
//@Component("u")  可不写
//@Scope("prototype") //可不写 默认  prototype
public class UserAction extends ActionSupport implements ModelDriven{
	
	/*
	private String username;
	private String password;
	private String password2;
	*/

	private UserRegisterInfo info = new UserRegisterInfo();
	private UserManager um;
	private List<User> users;
	private User user;
	

	public UserAction() {
		System.out.println("useraction created!");
	}
	
	public User getUser() {
		return user;
	}
	
	//把 user UserAction注入进来了 报错
	//自动注入
	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String list() throws Exception{
		this.users = this.um.getUsers();
		return "list";
	}
	
	public UserRegisterInfo getInfo() {
		return info;
	}
	
	public void setInfo(UserRegisterInfo info) {
		this.info = info;
	}
	

	public UserManager getUm() {
		return um;
	}
	
	@Resource(name = "userManager") //注入 com.registration.service.impl.UserManagerImpl; 属性名定义为  userManager 可不写 @Resource  (当前属性名为um)
	public void setUm(UserManager um) {
		this.um = um;
	}
	
	@Override
	public String execute() throws Exception {
		
		System.out.println(info.getUsername());
		
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
	
	public String load() throws Exception{
		this.user = this.um.loadById(info.getId());
		
		return "load";
	}
	
}
