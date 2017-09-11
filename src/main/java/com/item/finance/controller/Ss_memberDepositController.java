package com.item.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.finance.bean.MemberDepositRecord;
import com.item.finance.services.Ss_memberDepositService;



@Controller
@RequestMapping("/sushuang4")
public class Ss_memberDepositController {
	
	@Autowired
	private Ss_memberDepositService ss_memberDepositService;
	
	
	@RequestMapping("/list4")
	public String listshow(Model model){
		List<MemberDepositRecord>listdeposit=ss_memberDepositService.list();
		model.addAttribute("listdeposit", listdeposit);
		return "WEB-INF/ssjsp/memberdeposit";
	}
	

	
	

}
