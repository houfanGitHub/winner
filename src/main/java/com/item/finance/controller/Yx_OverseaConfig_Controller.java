package com.item.finance.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.finance.bean.OverseaConfig;
import com.item.finance.services.Yx_OverseaConfig_Services;

@Controller
@RequestMapping("/yx3")
public class Yx_OverseaConfig_Controller {
	@Autowired
private Yx_OverseaConfig_Services yx_OverseaConfig_Services;
	
	@RequestMapping("/list3")
	public String list(HttpSession session){
		List<OverseaConfig> list=yx_OverseaConfig_Services.list();
		session.setAttribute("list", list);
		return "WEB-INF/yx_jsp/yx_overseaconfig_show";
	}
	//海外配置预约记录
	@RequestMapping("/list3_3")
	public String list2(HttpSession session){
		List<OverseaConfig> list=yx_OverseaConfig_Services.list2();
		session.setAttribute("list", list);
		return "WEB-INF/yx_jsp/yx_overseaconfig_show2";
	}
}
