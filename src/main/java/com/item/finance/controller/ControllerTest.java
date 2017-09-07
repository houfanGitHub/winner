package com.item.finance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest {
	
	@RequestMapping("/test")
	public String test(){
		return "test";
	}
}
