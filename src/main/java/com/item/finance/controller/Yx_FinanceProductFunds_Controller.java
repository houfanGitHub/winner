package com.item.finance.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.finance.bean.FinanceProductFunds;
import com.item.finance.services.Yx_FinanceProductFunds_Service;

@Controller
@RequestMapping("/yx2")
public class Yx_FinanceProductFunds_Controller {
	@Autowired
	private Yx_FinanceProductFunds_Service yx_FinanceProductFunds_Service;
	
	@RequestMapping("/list2")
	public String list2(HttpSession session,FinanceProductFunds f){
		List<FinanceProductFunds> list=yx_FinanceProductFunds_Service.listFinanceProductFunds();
		session.setAttribute("list", list);
		return  "WEB-INF/yx_jsp/yx_FinanceProductFunds_show";
	}
	@RequestMapping("/listEdit/{id}")
	public String listEdit(@PathVariable("id")int id,HttpSession session){
		System.out.println("id"+id);
		FinanceProductFunds fs=this.yx_FinanceProductFunds_Service.listEdit(id);
		List<FinanceProductFunds> list=yx_FinanceProductFunds_Service.listFinanceProductFunds();
		session.setAttribute("fs", fs);
		session.setAttribute("list", list);
		return "WEB-INF/yx_jsp/yx_FinanceProductFunds_editshow";
	}
}
