package com.item.finance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.finance.bean.Member;
import com.item.finance.bean.MemberWithdrawRecord;
import com.item.finance.services.Ss_MemberWithdrawRecordService;

@Controller
@RequestMapping("/sushuang5")
public class Ss_MemberWithdrawRecordController {
	
	@Autowired
	private Ss_MemberWithdrawRecordService ss_MemberWithdrawRecordService;
	
	@RequestMapping("/list5")
	public String listshow(Model model,String aname,String aphone ,String anumber,String astatu,String adate ){
		Map map=new HashMap();
		map.put("aname", aname);   //姓名
		map.put("aphone", aphone);  //手机号
		map.put("anumber", anumber);  //绑卡卡号
		map.put("astatu", astatu);  //状态
		map.put("adate", adate);   //提现时间
		List<MemberWithdrawRecord>listwithdrawrecord=ss_MemberWithdrawRecordService.list(map);
		model.addAttribute("listwithdrawrecord", listwithdrawrecord);
		
		//模糊查询
		model.addAttribute("aname", aname);
		model.addAttribute("aphone", aphone);
		model.addAttribute("anumber", anumber);
		model.addAttribute("astatu", astatu);
		model.addAttribute("adate", adate);
		return "WEB-INF/ssjsp/MemberWithdrawRecord";
	}
	
	
	//得到id  传值     model 保存  传值
		@RequestMapping("/getmemberWithId/{id}")
		public String getMember(@PathVariable("id")String id,Model model){
			MemberWithdrawRecord memberWithdrawRecord=ss_MemberWithdrawRecordService.selectGetById(id);  //id 在dao方法里 已经由 string 转为int类型了
			model.addAttribute("memberWithdrawRecord", memberWithdrawRecord);
			return "WEB-INF/ssjsp/memberWithdrawRecord_details";   //跳转页面
		}

}
