package com.item.finance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.finance.bean.MemberBankcard;
import com.item.finance.services.Ss_cardmanagementService;

@Controller
@RequestMapping("/sushuang3")
public class Ss_cardmanagementController {
	
	@Autowired
	private Ss_cardmanagementService ss_cardmanagementService;
	
	//显示
	@RequestMapping("/list3")
	public String listshow(Model model,String mobile_phone1,String member_name1,String card_no1,String qdate1,String qdate2 ){
		Map map=new HashMap();
		map.put("mobile_phone1", mobile_phone1);
		map.put("member_name1", member_name1);
		map.put("card_no1", card_no1);
		map.put("qdate1",qdate1);
		map.put("qdate2", qdate2);
		List<MemberBankcard>listbank=ss_cardmanagementService.list();
		model.addAttribute("listbank", listbank);
		
		//模糊查询存储
		model.addAttribute("mobile_phone1", mobile_phone1); //手机号
		model.addAttribute("member_name1", member_name1);  //帮卡姓名
		model.addAttribute("card_no1", card_no1);   //绑卡卡号
		model.addAttribute("qdate1", qdate1);  // 注册时间1 开始时间
		model.addAttribute("qdate2", qdate2);  //注册时间2 结束时间
		return "WEB-INF/ssjsp/cardmanagement";
	}
/*	
	//得到 id
	@RequestMapping("/getbankid/{id}")
	public String getbankid(@PathVariable("id")String id,Model model){
		MemberBankcard memberBankcard=ss_cardmanagementService.selectGetById(id);
		model.addAttribute("memberBankcard", memberBankcard);
		return "WEB-INF/ssjsp/details";   //跳转页面
	}  */

}
