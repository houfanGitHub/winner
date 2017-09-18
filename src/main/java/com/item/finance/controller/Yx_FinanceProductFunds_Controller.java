package com.item.finance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.item.finance.bean.FinanceProductFunds;
import com.item.finance.services.Yx_FinanceProductFunds_Service;

@Controller
@RequestMapping("/yx2")
public class Yx_FinanceProductFunds_Controller {
	@Autowired
	private Yx_FinanceProductFunds_Service yx_FinanceProductFunds_Service;
	
	@RequestMapping("/list2")
	public String list2(HttpSession session,FinanceProductFunds f,
			@RequestParam(required=false)String qname,
    		@RequestParam(required=false)String qstatus,
    		@RequestParam(required=false)String qtype){
		Map map=new HashMap<>();
    	map.put("qname", qname);
    	map.put("qstatus",qstatus);
    	map.put("qtype", qtype);
		List<FinanceProductFunds> list=yx_FinanceProductFunds_Service.listFinanceProductFunds(map);
		session.setAttribute("list", list);
		 session.setAttribute("qname",qname); 
	      session.setAttribute("qstatus",qstatus);
	      session.setAttribute("qtype",qtype);
		return  "WEB-INF/yx_jsp/yx_FinanceProductFunds_show";
	}
	
	//修改前的查询
	@RequestMapping("/listEdit/{id}")
	public String listEdit(@PathVariable("id")int id,HttpSession session){
		Map map=new HashMap<>();
		FinanceProductFunds fs=this.yx_FinanceProductFunds_Service.listEdit(id);
		List<FinanceProductFunds> list=yx_FinanceProductFunds_Service.listFinanceProductFunds(map);
		session.setAttribute("fs", fs);
		session.setAttribute("list", list);
		return "WEB-INF/yx_jsp/yx_FinanceProductFunds_editshow";
	}
}
