package com.item.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.finance.bean.FinancialPlanner;
import com.item.finance.bean.Member;
import com.item.finance.services.Ss_licaiService;

@Controller
@RequestMapping("/sushuang2")
public class Ss_licaiController {
	
	@Autowired
	private Ss_licaiService ss_licaiService;
	
	//显示
	@RequestMapping("/list2")
	public String  listshow(Model model){
		List<FinancialPlanner>listfinap=ss_licaiService.list();
		model.addAttribute("listfinap",listfinap);
		return "WEB-INF/ssjsp/licai";
	}
	
	//得到id  传值     model 保存  传值
		@RequestMapping("/getfinapId/{id}")
		public String getMember(@PathVariable("id")String id,Model model){
			FinancialPlanner financialPlanner=ss_licaiService.selectGetById(id);  //id 在dao方法里 已经由 string 转为int类型了
			model.addAttribute("financialPlanner", financialPlanner);
			return "WEB-INF/ssjsp/details";   //跳转页面
		}
	

}
