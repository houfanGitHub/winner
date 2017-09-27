package com.item.finance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.finance.bean.MemberTradeRecord;
import com.item.finance.services.Ss_MemberTradeRecordService;

@Controller
@RequestMapping("/sushuang9")
public class Ss_MemberTradeRecordController {
	
	@Autowired
	private Ss_MemberTradeRecordService ss_MemberTradeRecordService;
	
	@RequestMapping("/list9")
	public String listmembertrade(Model model, String stat2,String tradeStatus2,String date1,String date2){
		
		Map map=new HashMap();
		map.put("stat2", stat2);//交易记录
		map.put("tradeStatus2", tradeStatus2); //交易状态
		map.put("date1", date1);  //交易时间  开始时间1
		map.put("date2", date2);   //交易时间   结束时间2
		List<MemberTradeRecord>listmembertrade=ss_MemberTradeRecordService.listmembertrade(map);
		
		model.addAttribute("listmembertrade", listmembertrade);
		
		//模糊查询
		model.addAttribute("stat2", stat2);
		model.addAttribute("tradeStatus2", tradeStatus2);
		model.addAttribute("date1", date1);
		model.addAttribute("date2", date2);
		
		return "WEB-INF/ssjsp/memberTradeRecord";
	}

}
