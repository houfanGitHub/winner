package com.item.finance.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.finance.bean.User;

@Controller
@RequestMapping("/itemweb")
public class HoufanWebItemController {

	@RequestMapping("/toLogin")
	public String toLogin(){
		return "WEB-INF/login/login";
	}
	
	@RequestMapping("/toRegistration")
	public String toRegistration(Map<String,Object> map){
		map.put("user", new User());
		return "WEB-INF/registration/registration";
	}
	
	@RequestMapping("/userRegistration")
	public String userRegistration(User user){
		System.out.println(user.toString());
		return "index";
	}
	
	@RequestMapping("/backstage")
	public String backstage(){
		return "WEB-INF/backstage/show";
	}
}
