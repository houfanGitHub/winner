package com.item.finance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/itemweb")
public class HoufanWebItemController {

	@RequestMapping("/login")
	public String login(){
		return "WEB-INF/login/login";
	}
	
	@RequestMapping("/registration")
	public String registration(){
		return "WEB-INF/registration/registration";
	}
}
