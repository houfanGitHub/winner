package com.item.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.finance.bean.Subject;
import com.item.finance.services.Yx_Subject_Service;



@Controller
@RequestMapping("/yx")
public class Yx_Subject_Controller {
    @Autowired
	private Yx_Subject_Service yx_Subject_Service;
    
    
    @RequestMapping("/list")
    public String list(Model model){
    List<Subject> list=yx_Subject_Service.list();
    model.addAttribute("list", list);
    for (Subject subject : list) {
		System.out.println(subject.getName());
	}return "WEB-INF/backstage/show";
    }
  /*public String saveSubject(Subject subject){
	  this.yx_Subject_Service.save(subject);
	return "WEB-INF/backstage/show";
}
  public String edit(){
	  return "redirect:";
  }*/


}
