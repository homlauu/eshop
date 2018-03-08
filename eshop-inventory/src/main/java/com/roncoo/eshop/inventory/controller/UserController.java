package com.roncoo.eshop.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roncoo.eshop.inventory.model.User;
import com.roncoo.eshop.inventory.service.UserService;

/**
 * 用户controller控制器
 * @author homlau
 *
 */
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * http://localhost:8080/getUserInfo
	 */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public User getUserInfo() {
        User user = userService.findUserInfo();
        return user;
    }

	/**
	 * http://localhost:8080/getCachedUserInfo
	 */
	@RequestMapping("/getCachedUserInfo")
	@ResponseBody
	public User getCachedUserInfo() {
		User user = userService.getCachedUserInfo();
		return user;
	}
	
}
