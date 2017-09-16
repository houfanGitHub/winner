package com.item.finance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.finance.bean.AwardRecord;
import com.item.finance.bean.Member;
import com.item.finance.services.Ss_AwardRecordService;

@Controller
@RequestMapping("/sushuang6")
public class Ss_AwardRecordController {
	
	@Autowired
	private Ss_AwardRecordService ss_AwardRecordService;
	
	//显示
	@RequestMapping("/list6")
	public String listShowAwardrecord(Model model ,String qmemberName,String qmobile_Phone,
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
		List<AwardRecord>listawardrecord=ss_AwardRecordService.listAwardRecord(map);
		System.out.println("qtype"+qtype);
		System.out.println("qisAward"+qisAward);
		model.addAttribute("listawardrecord", listawardrecord);
		
		//模糊查询
		model.addAttribute("qmemberName",qmemberName);
		model.addAttribute("qmobile_Phone",qmobile_Phone);
		model.addAttribute("qtype",qtype);
		model.addAttribute("qisAward",qisAward);
		model.addAttribute("qinvitationCode",qinvitationCode);
		model.addAttribute("qinvitedCode",qinvitedCode);
		
		return "WEB-INF/ssjsp/awardRecord";  //跳转页面
	}
	
	//奖励记录  传两个参数   通过两个id 找到个人奖励记录信息    和 被邀请人信息
		@RequestMapping("/awardrecord6/{id}/{byinvitingid}")
		public String reward_record(@PathVariable("id")int id,@PathVariable("byinvitingid")int byinvitingid,Model model){
			AwardRecord awardRecord = ss_AwardRecordService.getByAwardr(id);
			Member memberbyinvitingname=ss_AwardRecordService.getbyinvitingname(byinvitingid);
			
			model.addAttribute("awardRecord", awardRecord);
			model.addAttribute("member_ByinvitingName", memberbyinvitingname);
			return "WEB-INF/ssjsp/awardRecordDetails";  //跳转页面
		}
	

}
