package com.item.finance.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javassist.expr.NewArray;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.item.finance.bean.FinanceProductFunds;
import com.item.finance.bean.FinanceProductSubscribe;
import com.item.finance.bean.Subject;
import com.item.finance.services.Yx_FinanceProductFunds_Service;

@Controller
@RequestMapping("/yx2")
public class Yx_FinanceProductFunds_Controller {
	@Autowired
	private Yx_FinanceProductFunds_Service yx_FinanceProductFunds_Service;
	
	@RequestMapping("/list2")
	public String list2(HttpSession session,FinanceProductFunds f,
			@RequestParam(required=false)String qname,
    		@RequestParam(required=false)String qstatus,
    		@RequestParam(required=false)String qtype){
		Map map=new HashMap<>();
    	map.put("qname", qname);
    	map.put("qstatus",qstatus);
    	map.put("qtype", qtype);
		List<FinanceProductFunds> list=yx_FinanceProductFunds_Service.listFinanceProductFunds(map);
		session.setAttribute("list", list);
		 session.setAttribute("qname",qname); 
	      session.setAttribute("qstatus",qstatus);
	      session.setAttribute("qtype",qtype);
		return  "WEB-INF/yx_jsp/yx_FinanceProductFunds_show";
	}
	

	//修改前的查询
	@RequestMapping("/listEdit/{id}")
	public String listEdit(@PathVariable("id")int id,HttpSession session){
		Map map=new HashMap<>();
		FinanceProductFunds fs=this.yx_FinanceProductFunds_Service.listEdit(id);
		List<FinanceProductFunds> list=yx_FinanceProductFunds_Service.listFinanceProductFunds(map);
		session.setAttribute("fs", fs);
		session.setAttribute("list", list);
		return "WEB-INF/yx_jsp/yx_FinanceProductFunds_editshow";
	}
	//添加前跳转
	@RequestMapping("/toFinanceProductFunds")
	public String toFinanceProductFunds(){
		return "WEB-INF/yx_jsp/yx_FinanceProductFunds_add";
	}
	//私募股权类添加
	@RequestMapping("/saveFinanceProductFunds")
	public String saveFinanceProductFunds(FinanceProductFunds financeProductFunds,
			@RequestParam("file_name")
	MultipartFile file_name,HttpServletRequest request,HttpSession session) throws IOException{
		System.out.println("开始时间"+financeProductFunds.getCreateDate()+","+financeProductFunds.getEndDate());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssssss");
    	//this.yx_FinanceProductFunds_Service.saveFinanceProductFunds(financeProductFunds);
    	System.out.println("文件名"+file_name.getOriginalFilename());
    	session.setAttribute("filename",file_name.getOriginalFilename());
    	String type=file_name.getOriginalFilename().substring(file_name.getOriginalFilename().indexOf("."));
		Date date=new Date();
		//System.out.println(sdf.format(date));
		String filenameTime=sdf.format(date)+type;
    	String path=request.getRealPath("/upload/");//String path=request.getSession().getServletContext().getRealPath("/upload/");
    	File newfile=new File(path,filenameTime);
    	if(!newfile.exists()){
			newfile.createNewFile();
		}
    	file_name.transferTo(newfile);
		financeProductFunds.setProductManagerPic(path);
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		financeProductFunds.setCreateDate(sdf2.format(new Date()));
		financeProductFunds.setUpdateDate(sdf2.format(new Date()));
		this.yx_FinanceProductFunds_Service.saveFinanceProductFunds(financeProductFunds);
		return "redirect:/yx2/list2";
	}
	//未签署
	@RequestMapping("/listWqs/{id}")
	public String listWqs(HttpSession session,@PathVariable("id")int id){
		List<FinanceProductSubscribe> fe=this.yx_FinanceProductFunds_Service.listWqs(id);
		session.setAttribute("fe",fe);
		session.setAttribute("id2",id);
		return "WEB-INF/yx_jsp/yx_FinanceProductSubscribe_wqs";
	}//未签署查看
	@RequestMapping("/listchakan/{id}")
	public String listchakan(HttpSession session,@PathVariable("id")int id){
	FinanceProductSubscribe fe=this.yx_FinanceProductFunds_Service.listChakan(id);
		session.setAttribute("fe", fe);
		return "WEB-INF/yx_jsp/yx_FinanceProductFunds_chakan";
	}
	//修改为签署失败
	@RequestMapping("/updatecssb/{id}/{id2}")
	public String updatecssb(@PathVariable("id")int id,@PathVariable("id2")int id2,FinanceProductSubscribe fe){
		FinanceProductSubscribe fe2=this.yx_FinanceProductFunds_Service.selectqssb(id);
		fe2.setStatus("3");
		yx_FinanceProductFunds_Service.updateqssb(fe2);
		return "redirect:/yx2/listWqs/{id2}";
	}
	//签署查询
	@RequestMapping("/selectsign/{id}/{period}")
	public String selectsign(@PathVariable("id")int id,@PathVariable("period")int period,HttpSession session){
		FinanceProductSubscribe fe3=this.yx_FinanceProductFunds_Service.selectqssb(id);
       Date date=new Date();
       date.setDate(date.getDate()+period);
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
       session.setAttribute("endTime",sdf.format(date));
		session.setAttribute("fe3",fe3);
	    return "WEB-INF/yx_jsp/yx_FinanceProductSubscribe_sign";
	}
	
	
	
	//签署合同
	@RequestMapping("/upatesign/{id2}")
	public String upatesign(@PathVariable("id2")int id2,@RequestParam("file_name")
	MultipartFile[] files,FinanceProductSubscribe financeProductSubscribe
	,HttpSession session,HttpServletRequest request) throws IOException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssssss");
    	//System.out.println("文件名"+files.getOriginalFilename());
    	for(int i=0;i<files.length;i++){
    		String filename=files[i].getOriginalFilename();//获取文件名称
    		String path=request.getRealPath("/upload/");
    		File newfile=new File(path, filename);
    		if(!newfile.exists()){
    			newfile.createNewFile();
    		}
    //	String type=files[i].getOriginalFilename().substring(files[i].getOriginalFilename().indexOf("."));
		//Date date=new Date();
		//System.out.println(sdf.format(date));
		//String filenameTime=sdf.format(date)+type;
    	files[i].transferTo(newfile);
    	SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	financeProductSubscribe.setComment("upload/"+files[0].getOriginalFilename());
    	financeProductSubscribe.setRiskReveal("upload/"+files[1].getOriginalFilename());
    	financeProductSubscribe.setStatus("1");
		financeProductSubscribe.setCreateDate(sdf2.format(new Date()));
		financeProductSubscribe.setEndDate(sdf2.format(new Date()));
		financeProductSubscribe.setStartDate(sdf2.format(new Date()));
		financeProductSubscribe.setUpdateDate(sdf2.format(new Date()));
	     FinanceProductFunds financeProductFunds=this.yx_FinanceProductFunds_Service.listEdit(id2);
	   financeProductSubscribe.setFinanceProductFunds(financeProductFunds);
		this.yx_FinanceProductFunds_Service.updatesign(financeProductSubscribe);
    	}
		return "redirect:/yx2/listWqs/{id2}";
	}
	
	/*@RequestMapping("/updateFinanceProductFunds")
	public String updateFinanceProductFunds(){
		return "redirect:/yx2/list2";
	}*/
	
	
	//修改
	@RequestMapping("/updateFinanceProductFunds")
	public String updateFinanceProductFunds(FinanceProductFunds financeProductFunds,
	@RequestParam("file_name")
	MultipartFile productManagerPic,
	HttpServletRequest request,HttpSession session) throws IOException{
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		financeProductFunds.setCreateDate(sdf2.format(new Date()));
		financeProductFunds.setUpdateDate(sdf2.format(new Date()));
		//financeProductFunds.setStartDate(sdf2.format(new Date()));
		//financeProductFunds.setEndDate(sdf2.format(new Date()));
		//System.out.println("开始时间"+financeProductFunds.getCreateDate()+","+financeProductFunds.getEndDate());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssssss");
    	//this.yx_FinanceProductFunds_Service.saveFinanceProductFunds(financeProductFunds);
    	System.out.println("文件名"+productManagerPic.getOriginalFilename());
    	session.setAttribute("filename",productManagerPic.getOriginalFilename());
    	String type=productManagerPic.getOriginalFilename().substring(productManagerPic.getOriginalFilename().indexOf("."));
		Date date=new Date();
		//System.out.println(sdf.format(date));
		String filenameTime=sdf.format(date)+type;
    	String path=request.getRealPath("/upload/");//String path=request.getSession().getServletContext().getRealPath("/upload/");
    	File newfile=new File(path,filenameTime);
    	if(!newfile.exists()){
			newfile.createNewFile();
		}
    	productManagerPic.transferTo(newfile);
		financeProductFunds.setProductManagerPic(path);
	
		this.yx_FinanceProductFunds_Service.updateFinanceProductFunds(financeProductFunds);
		return "redirect:/yx2/list2";
	}
	
	
}
