package com.item.finance.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.item.finance.bean.Member;
import com.item.finance.bean.Subject;
import com.item.finance.bean.SubjectBbinPurchaseRecord;
import com.item.finance.bean.SubjectFile;
import com.item.finance.bean.SubjectFolder;
import com.item.finance.dao.Yx_Subject_Dao_ago;
import com.item.finance.services.Yx_Subject_Service;
import com.item.finance.services.Yx_Subject_Service_ago;



@Controller
@RequestMapping("/ago")
public class Yx_Subject_Controller_ago {
	@Autowired
	private Yx_Subject_Service_ago yx_Subject_Service_ago;
	
	@RequestMapping("/check_ago")
	@ResponseBody//用于处理异步请求，返回值是json
	public  boolean check_ago(HttpServletRequest request){
		boolean flag=false;
		List<Subject> list=this.yx_Subject_Service_ago.listSubject_ago();
		if(!list.equals("")&&list!=null){
			flag=true;
		}
		return flag;
	}
	@RequestMapping("/listSubject_ago")
	public String listSubject_ago(HttpSession session){
		List<Subject> list=this.yx_Subject_Service_ago.listSubject_ago();
		session.setAttribute("list", list);
		for (Subject subject : list) {
			System.out.println(subject.getId()+","+subject.getName());
		}
		return "WEB-INF/products/products";
	}
    
    
}    
    
