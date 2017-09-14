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
	public String listshow(Model model,String mobile1,String name1,String card1,String qdate1,String qdate2 ){
		Map map=new HashMap();
		map.put("mobile1", mobile1);
		map.put("name1", name1);
		map.put("card1", card1);
		map.put("qdate1",qdate1);
		map.put("qdate2", qdate2);
		List<MemberBankcard>listbank=ss_cardmanagementService.listshow(map);
		model.addAttribute("listbank", listbank);
		
		//模糊查询存储
		model.addAttribute("mobile1", mobile1); //手机号
		model.addAttribute("name1", name1);  //帮卡姓名
		model.addAttribute("card1", card1);   //绑卡卡号
		model.addAttribute("qdate1", qdate1);  // 注册时间1 开始时间
		model.addAttribute("qdate2", qdate2);  //注册时间2 结束时间
		return "WEB-INF/ssjsp/cardmanagement";
	}
	
	/*//得到 id
	@RequestMapping("/getbankid/{id}")
	public String getbankid(@PathVariable("id")String id,Model model){
		MemberBankcard memberBankcard=ss_cardmanagementService.selectGetById(id);
		model.addAttribute("memberBankcard", memberBankcard);
		return "redirect:/sushuang3/list3";   //跳转页面
	}  */
	
	//修改是否解绑
		@RequestMapping("/updateDelflag/{id}")
		public String updateDelflag(@PathVariable("id")String id){
			ss_cardmanagementService.updateDelflag(id);
			return "redirect:/sushuang3/list3";
		}

}
