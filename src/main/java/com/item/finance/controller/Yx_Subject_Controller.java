package com.item.finance.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.expr.NewArray;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.item.finance.bean.Member;
import com.item.finance.bean.Subject;
import com.item.finance.bean.SubjectBbinPurchaseRecord;
import com.item.finance.bean.SubjectFile;
import com.item.finance.bean.SubjectFolder;
import com.item.finance.services.Yx_Subject_Service;



@Controller
@RequestMapping("/yx")
public class Yx_Subject_Controller {
    @Autowired
	private Yx_Subject_Service yx_Subject_Service;
    
    @RequestMapping("/list")
    public String list(HttpSession session,@RequestParam(required=false)String qname,
    		@RequestParam(required=false)String qstatus,
    		@RequestParam(required=false)String qtype){
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
    
    @RequestMapping("/saveSubject")
public String saveSubject(Subject subject,@RequestParam("file_name")
MultipartFile file_name,HttpServletRequest request,HttpSession session,SubjectFile subjectFile
,SubjectFolder subjectFolder
		)throws IOException{
    	//System.out.println(subject.getName()+","+subject.getComment()+","+subject.getProjectDetails()+","+subject.getSafetyControl());
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssssss");
    	SimpleDateFormat sdf3=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		subject.setCreateDate(sdf3.format(new Date()));
		subject.setUpdateDate(sdf3.format(new Date()));
    	subject.setSerialNumber("YJ"+sdf.format(new Date()));
    	this.yx_Subject_Service.saveSubject(subject);
    	System.out.println("文件名"+file_name.getOriginalFilename());
    	session.setAttribute("filename",file_name.getOriginalFilename());
    	String type=file_name.getOriginalFilename().substring(file_name.getOriginalFilename().indexOf("."));
		Date date=new Date();
		
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyyMMdd");
		//System.out.println(sdf.format(date));
		String filenameTime=sdf.format(date)+type;
    	String path=request.getRealPath("/upload/");//String path=request.getSession().getServletContext().getRealPath("/upload/");
    	File newfile=new File(path,filenameTime);
    	if(!newfile.exists()){
			newfile.createNewFile();
		}
		file_name.transferTo(newfile);
		session.setAttribute("filenameTime",filenameTime);
		session.setAttribute("path",path);
		//System.out.println(subjectFile.getFileName()+","+subjectFile.getPath());
		subjectFile.setFileName(filenameTime);
		subjectFile.setPath(path+sdf2.format(date));
		subjectFile.setCreateDate(new Date());
		this.yx_Subject_Service.saveSubjectFile(subjectFile);
    	
	return "redirect:/yx/list";
}

    
    //重置
    @RequestMapping("/listcz")
    public String listcz(HttpSession session){
    	session.removeAttribute("qname");
    return "WEB-INF/yx_jsp/yx_subject_show";
    }
    
    //查看投资
    @RequestMapping("/listtouzi/{id}")
    public String  listtouzi(HttpSession session,@PathVariable("id")int id,Member member){
    	List<SubjectBbinPurchaseRecord> list=yx_Subject_Service.listtouzi(id);
    	session.setAttribute("list", list);
    	return "WEB-INF/yx_jsp/yx_subject_show2";
    }
    //修改前的查询
    @RequestMapping("/listEdit/{id}")
  public String listEdit(@PathVariable("id")int id,HttpSession session){
    	Map map=new HashMap<>();
    	Subject subject=this.yx_Subject_Service.selectGetById(id);
    	List<Subject> list=yx_Subject_Service.list(map);
    	session.setAttribute("subject", subject);
		session.setAttribute("list", list);
	  return "WEB-INF/yx_jsp/yx_subject_editshow";
  }
    
    
    //修改
    @RequestMapping("/updateSubject/{id}")
    public String updateSubject(
    @RequestParam("file_name")MultipartFile file_name,
    SubjectFile subjectFile,
    HttpServletRequest request,HttpSession session,Subject subject) throws IOException{
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		subject.setCreateDate(sdf2.format(new Date()));
		subject.setUpdateDate(sdf2.format(new Date()));
    	yx_Subject_Service.updateSubject(subject);//subject2
    	String type=file_name.getOriginalFilename().substring(file_name.getOriginalFilename().indexOf("."));
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssssss");
		String filenameTime=sdf.format(date)+type;
    	String path=request.getRealPath("/upload/");
    	File newfile=new File(path,filenameTime);
    	if(!newfile.exists()){
			newfile.createNewFile();
		}
		file_name.transferTo(newfile);
		subjectFile.setPath(path);
		this.yx_Subject_Service.updateSubjectFile(subjectFile);
    	return "redirect:/yx/list";
    }
    
    
}    
    
