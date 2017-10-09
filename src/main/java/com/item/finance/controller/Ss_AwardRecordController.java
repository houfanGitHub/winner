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

import com.item.finance.bean.AwardRecord;
import com.item.finance.bean.Member;
import com.item.finance.bean.MemberAccount;
import com.item.finance.services.Ss_AwardRecordService;

@Controller
@RequestMapping("/sushuang6")
public class Ss_AwardRecordController {
	
	@Autowired
	private Ss_AwardRecordService ss_AwardRecordService;
	
	//显示
	@RequestMapping("/list6")
	public String listShowAwardrecord( HttpSession session,Model model ,String qmemberName,String qmobile_Phone,
			String qtype,String qisAward,String qinvitationCode,String qinvitedCode  ){
	/*	if (qtype!= null  && qtype.equals("-1"))  {
			qtype=null;	
		};
		if (qisAward!= null  && qisAward.equals("-1"))  {
			qisAward=null;
		};*/
		Map map=new HashMap();
		map.put("qmemberName", qmemberName);  //姓名
		map.put("qmobile_Phone", qmobile_Phone); //手机号
		map.put("qtype", qtype);   //奖励类型
		map.put("qisAward", qisAward);   //奖励状态
		map.put("qinvitationCode", qinvitationCode);  //邀请码
		map.put("qinvitedCode", qinvitedCode); //被邀请码
		List<AwardRecord>listawardrecord=ss_AwardRecordService.listAwardRecord(map);//显示信息
		model.addAttribute("listawardrecord", listawardrecord);
	
		//session.setAttribute("listawardrecord", listawardrecord);  //显示信息
		
		
		//模糊查询
		model.addAttribute("qmemberName",qmemberName);
		model.addAttribute("qmobile_Phone",qmobile_Phone);
		model.addAttribute("qtype",qtype);
		model.addAttribute("qisAward",qisAward);
		model.addAttribute("qinvitationCode",qinvitationCode);
		model.addAttribute("qinvitedCode",qinvitedCode);  
	/*	
		session.setAttribute("qmemberName", qmemberName);  
		session.setAttribute("qmobile_Phone", qmobile_Phone);  
		session.setAttribute("qtype", qtype);  
		session.setAttribute("qisAward", qisAward);  
		session.setAttribute("qinvitationCode", qinvitationCode);  
		session.setAttribute("qinvitedCode", qinvitedCode);  	*/
		return "WEB-INF/ssjsp/awardRecord";  //跳转页面
	}
	
/*	
	//重置操作
		@RequestMapping("/listcz6")
		public String listcz(HttpSession session){
			session.removeAttribute("qmemberName");
			session.removeAttribute("qmobile_Phone");
			session.removeAttribute("qtype");
			session.removeAttribute("qisAward");
			session.removeAttribute("qinvitationCode");
			session.removeAttribute("qinvitedCode");
			
			return "redirect:/sushuang6/list6";   //重定向到首页
		}*/
	/*
	//奖励记录  传两个参数 避免重复   用byinvitingid代替    通过两个id 找到个人奖励记录信息    和 被邀请人信息
		@RequestMapping("/awardrecord6/{id}/{byinvitingid}")
		public String listrewardrecord(@PathVariable("id")int id,@PathVariable("byinvitingid")int byinvitingid,Model model){
			AwardRecord awardrecord = ss_AwardRecordService.getByAwardr(id);
			Member memberbyinvitingname=ss_AwardRecordService.getbyinvitingname(byinvitingid);
			
			model.addAttribute("awardRecord", awardrecord);
			model.addAttribute("memberbyinvitingname", memberbyinvitingname);
			return "WEB-INF/ssjsp/awardRecordDetails";  //跳转页面
		}
	*/

	//邀请奖励id
		@RequestMapping("/awardrecord6/{id}/{invitingid}")
		public String listinvite1(@PathVariable("id")int id,@PathVariable("invitingid")String  invitingid,Model model){
			List<AwardRecord> listawrd=ss_AwardRecordService.listawardrecord(id);
			Member member=ss_AwardRecordService.getbymemberId(invitingid);
			//System.out.println(listawrd.getMember().getMobile_Phone());
			model.addAttribute("member", member);
			model.addAttribute("listawrd", listawrd);
			return "WEB-INF/ssjsp/awardRecordDetails";  //跳转页面
		} 
}
