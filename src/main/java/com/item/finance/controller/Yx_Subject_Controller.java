package com.item.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.finance.bean.Subject;
import com.item.finance.services.Yx_Subject_Services;



@Controller
@RequestMapping("/yx")
public class Yx_Subject_Controller {
    @Autowired
	private Yx_Subject_Services yx_FinanceProductFunds_Services;
    
    
    @RequestMapping("/list")
    public String list(Model model,Subject subject){
    	System.out.println(subject);
    List<Subject> list=yx_FinanceProductFunds_Services.list();
    model.addAttribute("list", list);
    	return "/WEB-INF/yx_subject";
    }



}
