package com.item.finance.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
import com.item.finance.bean.SubjectPurchaseRecord;
import com.item.finance.services.Ss_zhmanagerService;

@Controller
@RequestMapping("/sushuang1")
public class Ss_zhmanagerController {
	@Autowired
	private Ss_zhmanagerService ss_zhmanagerService;
	
	@RequestMapping("/list1")
	public String listShowzh(HttpSession session,Model model,@RequestParam(required=false)String qname1,
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
		//model.addAttribute("listzh", listzh);
		session.setAttribute("listzh", listzh);
		
		session.setAttribute("qname1", qname1);
		session.setAttribute("mobile", mobile);
		session.setAttribute("qname2", qname2);
		session.setAttribute("invit", invit);
		session.setAttribute("create_date1", create_date1);
		session.setAttribute("create_date2", create_date2);
		
		
		/*//模糊查询
		model.addAttribute("qname1", qname1);
		model.addAttribute("mobile", mobile);
		model.addAttribute("qname2", qname2);
		model.addAttribute("invit", invit);
		model.addAttribute("create_date1", create_date1);
		model.addAttribute("create_date2", create_date2);*/
		
		return "WEB-INF/ssjsp/zhmanager";
	}
	//重置操作
	@RequestMapping("/listcz1")
	public String listcz(HttpSession session){
		session.removeAttribute("qname1");
		session.removeAttribute("mobile");
		session.removeAttribute("qname2");
		session.removeAttribute("invit");
		session.removeAttribute("create_date1");
		session.removeAttribute("create_date2");
		
		return "redirect:/sushuang1/list1";   //重定向到首页
	}
	
	//得到id  传值     model 保存  传值
	@RequestMapping("/getmemberId/{id}")
	public String getMember(@PathVariable("id")String id,Model model){
		Member member=this.ss_zhmanagerService.selectGetById(id);  //会员表
		MemberAccount memberAccount=this.ss_zhmanagerService.getById(id);//资金信息表
		FinancialPlanner financialPlanner=this.ss_zhmanagerService.getBYid(id);//理财师表
		 //集合取出来
		List<SubjectPurchaseRecord>listspr=this.ss_zhmanagerService.getlistspr(id); //投资详请
	   /*  Date date = new Date();
		double day = 0;//天数
		double earnings = 0;//投资收益(earnings)
		String result = "";//格式化小数位后的投资收益数
		for (SubjectPurchaseRecord s : listspr) {
			//时间date格式  转换为String类型
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ssss");
			String sdate =sdf.format(s.getSubject().getStartDate());//得到开始时间
			String edate = sdf.format(s.getSubject().getEndDate());//得到结束时间
			System.out.println("开始日期："+sdate);
			System.out.println("结束日期："+edate);
			double time1=(double)date.parse(sdate);//   字符串string类型转换为double类型
			double time2=(double)date.parse(edate);
			
			double qamount= s.getAmount();//标的购买金额
			double yearRate= s.getSubject().getYearRate();//标的年化率.
			day = (Math.abs(time2 - time1))/1000/60/60/24;//得到天数   /1000  毫秒    Math.abs（）取绝对值
			//amount*.subject.yearRate/365*day
			earnings = qamount*yearRate/365*day;
			result= String.format("%.2f", earnings);//格式化数据
		}
		System.out.println("day="+day);
		System.out.println("投资收益="+result);  
		*/
		List<MemberWithdrawRecord> memberWithdrawRecord=this.ss_zhmanagerService.getByIdwith(id);//提现记录表
		List<MemberDepositRecord> memberDepositRecord=this.ss_zhmanagerService.getbyIddeposit(id);//充值记录表
		List<MemberTradeRecord> memberTradeRecord=this.ss_zhmanagerService.getbyIdtrade(id);//钱包交易记录表
		model.addAttribute("member", member);
		model.addAttribute("memberAccount", memberAccount);
		model.addAttribute("financialPlanner", financialPlanner);
		
	   model.addAttribute("listspr", listspr);
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
