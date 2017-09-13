package com.item.finance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.item.finance.bean.Subject;
import com.item.finance.services.Yx_Subject_Service;



@Controller
@RequestMapping("/yx")
public class Yx_Subject_Controller {
    @Autowired
	private Yx_Subject_Service yx_Subject_Service;
    
    @RequestMapping("/list")
    public String list(HttpSession session,@RequestParam(required=false)String qname,@RequestParam(required=false)String qstatus,@RequestParam(required=false)String qtype){
    	Map map=new HashMap<>();
    	map.put("qname", qname);
    	map.put("qstatus",qstatus);
    	map.put("qtype", qtype);
    	List<Subject> list=yx_Subject_Service.list(map);
      session.setAttribute("list",list);
      session.setAttribute("qname",qname); 
      session.setAttribute("qstatus",qstatus);
      session.setAttribute("qtype",qtype);
     return "WEB-INF/yx_jsp/yx_subject_show";
    }
    @RequestMapping("/toSubject")
    public String toSubject(){
    	return "WEB-INF/yx_jsp/yx_subject_add";
    }
    
public String saveSubject(Subject subject){
	  this.yx_Subject_Service.save(subject);
	return "WEB-INF/backstage/show";
}
  /*public String edit(){
	  return "redirect:";
  }*/


}
