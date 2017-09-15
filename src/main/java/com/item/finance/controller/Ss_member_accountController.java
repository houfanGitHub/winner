package com.item.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.finance.bean.MemberAccount;
import com.item.finance.services.Ss_member_accountService;

@Controller
@RequestMapping("sushuang7")
public class Ss_member_accountController {
	
	@Autowired
	private Ss_member_accountService ss_member_accountService;
	
	
	@RequestMapping("/list7")
	public  String  listmemberaccount(Model model){
		List<MemberAccount>listmemberaccount=ss_member_accountService.list();
		model.addAttribute("listmemberaccount", listmemberaccount);
		return "WEB-INF/ssjsp/memberWithdrawRecord_details";   //跳转页面
	}

}
