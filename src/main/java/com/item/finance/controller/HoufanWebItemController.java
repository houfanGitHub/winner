package com.item.finance.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.item.finance.bean.User;

@Controller
@RequestMapping("/itemweb")
public class HoufanWebItemController {
	
	//进入用户登录界面
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "WEB-INF/login/login";
	}
	
	//进入用户注册界面
	@RequestMapping("/toRegistration")
	public String toRegistration(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException {
		
		return "WEB-INF/registration/registration";
	}
	
	//用户注册
	@RequestMapping("/userRegistration")
	public String userRegistration(User user){
		System.out.println("userRegistration");
		System.out.println(user.toString());
		return "redirect:/itemweb/index";
	}
	
	//返回首页
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	//后台显示页面
	@RequestMapping("/backstage")
	public String backstage(){
		return "WEB-INF/backstage/show";
	}
	
	//后台登陆页面
	@RequestMapping("/backstageLogin")
	public String backstageLogin(){
		return "WEB-INF/backstage/login";
	}
}
