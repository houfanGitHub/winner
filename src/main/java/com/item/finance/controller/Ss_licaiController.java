package com.item.finance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
	public String  listshowfina( HttpSession session,Model model, String amobile_Phone,String amemberName,
			String astatu,String adate1,String adate2){
			Map map=new HashMap();
			map.put("amobile_Phone", amobile_Phone);  //手机号
			map.put("amemberName", amemberName);   //真实姓名
			map.put("astatu", astatu);   //状态
			map.put("adate1", adate1);   //注册时间前
			map.put("adate2", adate2);   //注册时间后
		List<FinancialPlanner>listfinap=ss_licaiService.list(map);
		//model.addAttribute("listfinap",listfinap);
		session.setAttribute("listfinap",listfinap);
	/*	//模糊查询
		model.addAttribute("amobile_Phone", amobile_Phone);
		model.addAttribute("amemberName", amemberName);
		model.addAttribute("astatu", astatu);
		model.addAttribute("adate1", adate1);
		model.addAttribute("adate2", adate2);*/
		
		session.setAttribute("amobile_Phone",amobile_Phone);
		session.setAttribute("amemberName",amemberName);
		session.setAttribute("astatu",astatu);
		session.setAttribute("adate1",adate1);
		session.setAttribute("adate2",adate2);
		
		return "WEB-INF/ssjsp/licai";
	}
	/*//提现管理用
	@RequestMapping("/listapp")
	public String  listshow(Model model){
		List<FinancialPlanner>list=ss_licaiService.list();
		model.addAttribute("list",list);
		return "WEB-INF/ssjsp/memberWithdrawRecord_details";   //跳转页面
	}*/
	
	//得到id  传值     model 保存  传值
		@RequestMapping("/getfinapId/{id}")
		public String getMember(@PathVariable("id")String id,Model model){
			FinancialPlanner financialPlanner=ss_licaiService.selectGetById(id);  //id 在dao方法里 已经由 string 转为int类型了
			model.addAttribute("financialPlanner", financialPlanner);
			return "WEB-INF/ssjsp/details";   //跳转页面
		}
		
		@RequestMapping("/listcz2")
		public String listcz(HttpSession session){
			session.removeAttribute("amobile_Phone");
			session.removeAttribute("amemberName");
			session.removeAttribute("astatu");
			session.removeAttribute("adate1");
			session.removeAttribute("adate2");
			
			
			return "redirect:/sushuang2/list2";   //重定向到首页
		}
	

}
