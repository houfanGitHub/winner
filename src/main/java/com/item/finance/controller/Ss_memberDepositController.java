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

import com.item.finance.bean.MemberDepositRecord;
import com.item.finance.services.Ss_memberDepositService;



@Controller
@RequestMapping("/sushuang4")
public class Ss_memberDepositController {
	
	@Autowired
	private Ss_memberDepositService ss_memberDepositService;
	
	
	@RequestMapping("/list4")
	public String listshow(HttpSession session,Model model,String serialNumber2,String mobile2,String status2,String payChannelName2,String date1,String date2 ){
		Map map=new HashMap();
		map.put("serialNumber2", serialNumber2);
		map.put("mobile2", mobile2);
		map.put("status2", status2);
		map.put("payChannelName2", payChannelName2);
		map.put("date1", date1);
		map.put("date2", date2);
		List<MemberDepositRecord>listdeposit=ss_memberDepositService.list(map);
	/*	for (MemberDepositRecord memberDepositRecord : listdeposit) {
			System.out.println( "memberDepositRecord "+ memberDepositRecord.getId()+"memberDepositRecord"+memberDepositRecord.getPayChannelOrderNo());
		}*/
	//	model.addAttribute("listdeposit", listdeposit);
		
		session.setAttribute("listdeposit", listdeposit);
		
	/*	//模糊查询保存
		model.addAttribute("serialNumber2", serialNumber2);  //流水号
		model.addAttribute("mobile2", mobile2);  //手机号
		model.addAttribute("status2", status2);  //状态(0:待付款;1:完成)
		model.addAttribute("payChannelName2", payChannelName2);  //  充值渠道名称  富友订单
		model.addAttribute("date1", date1);   //订单时间  开始
		model.addAttribute("date2", date2);  //订单时间2  结束  */
		
		session.setAttribute("serialNumber2", serialNumber2);
		session.setAttribute("mobile2", mobile2);
		session.setAttribute("status2", status2);
		session.setAttribute("payChannelName2", payChannelName2);
		session.setAttribute("date1", date1);
		session.setAttribute("date2", date2);
		
		return "WEB-INF/ssjsp/memberdeposit";
	}
	
	//重置操作
		@RequestMapping("/listcz4")
		public String listcz(HttpSession session){
			session.removeAttribute("serialNumber2");
			session.removeAttribute("mobile2");
			session.removeAttribute("status2");
			session.removeAttribute("payChannelName2");
			session.removeAttribute("date1");
			session.removeAttribute("date2");
			
			return "redirect:/sushuang4/list4";   //重定向到首页
		}
		/*
		  //更新操作  
				@RequestMapping("/updatememberdepoist4/{id}/")
				public String updateSubjectmemberdeposit(@PathVariable("id")String id){
						ss_memberDepositService.updatememberdepoist(id);
						
							return "redirect:/sushuang4/list4";//主页面跳转
							
						}
	*/

		//修改是否执行更新操作
			@RequestMapping("/updatememberdeposit4/{id}")
			public String updatememberdeposit(@PathVariable("id")String id){
				ss_memberDepositService.updatememberdeposit(id);
				return "redirect:/sushuang4/list4";
			}


	
	

}
