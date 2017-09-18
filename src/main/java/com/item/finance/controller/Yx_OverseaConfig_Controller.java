package com.item.finance.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String list3_3(HttpSession session){
		List<OverseaConfig> list=yx_OverseaConfig_Services.list2();
		for (OverseaConfig overseaConfig : list) {
			System.out.println(overseaConfig.getStartDate());
		}
		session.setAttribute("list", list);
		return "WEB-INF/yx_jsp/yx_overseaconfig_show2";
	}
	@RequestMapping("/listEdit/{id}")
	public String listEdit(@PathVariable("id")int id,HttpSession session){
	//	SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		OverseaConfig overseaConfig=yx_OverseaConfig_Services.selectOverseaConfig(id);
		session.setAttribute("overseaConfig",overseaConfig);
		return "WEB-INF/yx_jsp/yx_overseaconfig_editshow";
	}
}
