package com.item.finance.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.finance.bean.User;
import com.item.finance.services.UserService;

@Controller
@RequestMapping("/system")
public class HoufanItemSystemController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public String systemUsers(Map<String,Object> map){
		//查询所有用户信息
		List<User> list = userService.list();
		map.put("userList", list);
		return "/WEB-INF/backstage/system/users";
	}
	
	@RequestMapping("/roles")
	public String roles(Map<String,Object> map){
		//查询所有角色信息
		List<User> list = userService.list();
		map.put("userList", list);
		return "/WEB-INF/backstage/system/users";
	}
	
	@RequestMapping("/passwords")
	public String passwords(Map<String,Object> map){
		//修改密码
		List<User> list = userService.list();
		map.put("userList", list);
		return "/WEB-INF/backstage/system/users";
	}
}
