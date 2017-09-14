package com.item.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.finance.bean.AwardRecord;
import com.item.finance.services.Ss_AwardRecordService;

@Controller
@RequestMapping("/sushuang6")
public class Ss_AwardRecordController {
	
	@Autowired
	private Ss_AwardRecordService ss_AwardRecordService;
	
	//显示
	@RequestMapping("/list6")
	public String listShowAwardrecord(Model model){
		List<AwardRecord>listawardrecord=ss_AwardRecordService.listAwardRecord();
		model.addAttribute("listawardrecord", listawardrecord);
		return "WEB-INF/ssjsp/awardRecord";
	}
	

}
