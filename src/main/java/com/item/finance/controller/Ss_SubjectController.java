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

import com.item.finance.bean.Ss_Sumsubject;
import com.item.finance.bean.Subject;
import com.item.finance.bean.SubjectBbinPurchaseRecord;
import com.item.finance.bean.SubjectPurchaseRecord;
import com.item.finance.services.Ss_SubjectService;

@Controller
@RequestMapping("/sushuang8")
public class Ss_SubjectController {
	
	@Autowired
	private Ss_SubjectService ss_SubjectService;
	
	//显示
	@RequestMapping("/list8")
	public  String listshowsubject(HttpSession session,Model  model,String sname,String sstatus,String stype ){
		
		Map map=new HashMap();
		map.put("sname", sname);//名称
		map.put("sstatus", sstatus);//状态
		map.put("stype", stype);//类型
	List<Subject>listsubject=ss_SubjectService.list(map);  //显示
		List<Ss_Sumsubject>listsumsubject=ss_SubjectService.listsumsub();  //已投金额
		for (Ss_Sumsubject ss : listsumsubject) {
			System.out.println("标的id："+ss.getSubject_id()+",标的已投金额："+ss.getSumamount());
		}
	
		model.addAttribute("listsubject", listsubject);
	//session.setAttribute("listsubject", listsubject);
	model.addAttribute("listsumsubject", listsumsubject);
//session.setAttribute("listsumsubject", listsumsubject);
	
	//模糊查询
		model.addAttribute("sname", sname);
		model.addAttribute("sstatus", sstatus);
		model.addAttribute("stype", stype);  
	
	/*session.setAttribute("sname", sname);
	session.setAttribute("sstatus", sstatus);
	session.setAttribute("stype", stype);*/
	

		System.out.println("111111111111");
		return "WEB-INF/ssjsp/subjectplan"; //跳转
		
	}
	/*//重置操作
	@RequestMapping("/listcz8")
	public String listcz(HttpSession session){
		session.removeAttribute("sname");
		session.removeAttribute("sstatus");
		session.removeAttribute("stype");
		
		//return null;
		return "redirect:/sushuang8/list8";   //重定向到首页
	}*/
	
	//体验金购买列表
		@RequestMapping("/listsubjectbbin8/{id}")
		public String listSubjectbbin(@PathVariable("id")int id,Model model){
			List<SubjectBbinPurchaseRecord> listsubjectbb = ss_SubjectService.listSubjectbb(id);
			model.addAttribute("listsubjectbb", listsubjectbb);
			return "WEB-INF/ssjsp/subjectbbinpur"; //跳转
		}
		
		  //体验金还款   (怕重复不好分辨  这里用subject_id 代替id)
		@RequestMapping("/updatesubjectbbin8/{id}/{subject_id}")
		public String updateSubject_bbin(@PathVariable("id")int id,@PathVariable("subject_id")String subject_id){
				ss_SubjectService.updatesubjectb(id);
				
					return "redirect:/sushuang8/listsubjectbbin8/"+subject_id;//重定向页面跳转
					//return "redirect:/sushuang8/list8";  //重定向到主页面
				}
				
		
		//付息列表显示 
		@RequestMapping("/listsubjectpurchaserecord8/{id}")
		public String listSubject_Purchase_Record(@PathVariable("id")String id,Model model){
		List<SubjectPurchaseRecord> listsubjectpp = ss_SubjectService.listSubjectpurchase(id);
		model.addAttribute("listsubjectpp", listsubjectpp);
			return "WEB-INF/ssjsp/subjectpurchaserecord";  //跳转
	}
		
		//付息列表  还款功能       (怕重复不好分辨  这里用subject_id 代替id)
		@RequestMapping("/updatesubjectpurchase8/{id}/{subject_id}")
		public String updateSubjectpurchase(@PathVariable("id")String id,@PathVariable("subject_id")String subject_id){
			ss_SubjectService.updatesubjectpurchase(id);  //service中的方法 
			return "redirect:/sushuang8/listsubjectpurchaserecord8/"+subject_id;   //重定向跳转
		}
		
	
	
}
