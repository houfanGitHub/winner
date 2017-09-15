package com.item.finance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.item.finance.bean.FinancialPlanner;
import com.item.finance.bean.Member;
import com.item.finance.bean.MemberAccount;
import com.item.finance.bean.MemberDepositRecord;
import com.item.finance.bean.MemberTradeRecord;
import com.item.finance.bean.MemberWithdrawRecord;
import com.item.finance.services.Ss_zhmanagerService;

@Controller
@RequestMapping("/sushuang1")
public class Ss_zhmanagerController {
	@Autowired
	private Ss_zhmanagerService ss_zhmanagerService;
	
	@RequestMapping("/list1")
	public String listShowzh(Model model,@RequestParam(required=false)String qname1,
			@RequestParam(required=false)String mobile,
			@RequestParam(required=false)String qname2,
			@RequestParam(required=false)String invit,
			@RequestParam(required=false)String create_date1,
			@RequestParam(required=false)String create_date2){
		
		Map map=new HashMap();
		map.put("qname1", qname1);  //用户名
		map.put("mobile", mobile);//手机号
		map.put("qname2", qname2);//姓名
		map.put("invit", invit);  //邀请码
		map.put("create_date1", create_date1);//注册时间1开始
		map.put("create_date2", create_date2);//注册时间2 结束
		List<Member>listzh=ss_zhmanagerService.list(map);
		model.addAttribute("listzh", listzh);
		
		//模糊查询
		model.addAttribute("qname1", qname1);
		model.addAttribute("mobile", mobile);
		model.addAttribute("qname2", qname2);
		model.addAttribute("invit", invit);
		model.addAttribute("create_date1", create_date1);
		model.addAttribute("create_date2", create_date2);
		
		return "WEB-INF/ssjsp/zhmanager";
	}
	
	//得到id  传值     model 保存  传值
	@RequestMapping("/getmemberId/{id}")
	public String getMember(@PathVariable("id")String id,Model model){
		Member member=this.ss_zhmanagerService.selectGetById(id);  //会员表
		MemberAccount memberAccount=this.ss_zhmanagerService.getById(id);//资金信息表
		FinancialPlanner financialPlanner=this.ss_zhmanagerService.getBYid(id);//理财师表
		 //集合取出来
		List<MemberWithdrawRecord> memberWithdrawRecord=this.ss_zhmanagerService.getByIdwith(id);//提现记录表
		List<MemberDepositRecord> memberDepositRecord=this.ss_zhmanagerService.getbyIddeposit(id);//充值记录表
		List<MemberTradeRecord> memberTradeRecord=this.ss_zhmanagerService.getbyIdtrade(id);//钱包交易记录表
		model.addAttribute("member", member);
		model.addAttribute("memberAccount", memberAccount);
		model.addAttribute("financialPlanner", financialPlanner);
		
		model.addAttribute("memberWithdrawRecord", memberWithdrawRecord);
		//System.out.println("memberWithdrawRecord"+memberWithdrawRecord.size());
	
	
		model.addAttribute("memberDepositRecord", memberDepositRecord);
		/*for (int i = 0; i < memberDepositRecord.size(); i++) {
			System.out.println(memberDepositRecord.get(i).getId());
		}*/
		//System.out.println("memberDepositRecord"+memberDepositRecord.size());
	
		model.addAttribute("memberTradeRecord", memberTradeRecord);
		//System.out.println("memberTradeRecord"+memberTradeRecord.size());
	
		return "WEB-INF/ssjsp/details";   //跳转页面
	}

}
