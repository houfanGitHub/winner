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
	public String list2(HttpSession session, FinanceProductFunds f,
			@RequestParam(required = false) String qname,
			@RequestParam(required = false) String qstatus,
			@RequestParam(required = false) String qtype) {
		Map map = new HashMap<>();
		map.put("qname", qname);
		map.put("qstatus", qstatus);
		map.put("qtype", qtype);
		List<FinanceProductFunds> list = yx_FinanceProductFunds_Service
		.listFinanceProductFunds(map);
		session.setAttribute("list", list);
		session.setAttribute("qname", qname);
		session.setAttribute("qstatus", qstatus);
		session.setAttribute("qtype", qtype);
		return "WEB-INF/yx_jsp/yx_FinanceProductFunds_show";
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
	//私募股权类修改
	@RequestMapping("/updateFinanceProductFunds")//productManagerPic
	public String updateFinanceProductFunds(FinanceProductFunds financeProductFunds,@RequestParam("file_name")
	MultipartFile productManagerPic,HttpServletRequest request,HttpSession session) throws IOException{
		System.out.println(financeProductFunds.getEndDate()+financeProductFunds.getStartDate());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssssss");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
    	session.setAttribute("filename",productManagerPic.getOriginalFilename());
    	String type=productManagerPic.getOriginalFilename().substring(productManagerPic.getOriginalFilename().indexOf("."));
		Date date=new Date();
		String filenameTime=sdf.format(date)+type;
    	String path=request.getRealPath("/upload/");
    	File newfile=new File(path,filenameTime);
    	if(!newfile.exists()){
			newfile.createNewFile();
		}
    	productManagerPic.transferTo(newfile);
		financeProductFunds.setProductManagerPic(filenameTime);
		financeProductFunds.setCreateDate(sdf2.format(new Date()));
		this.yx_FinanceProductFunds_Service.updateFinanceProductFunds(financeProductFunds);
		return "redirect:/yx2/list2";
	}
	
	//添加前跳转
	@RequestMapping("/toFinanceProductFunds")
	public String toFinanceProductFunds(){
		return "WEB-INF/yx_jsp/yx_FinanceProductFunds_add";
	}
	//私募股权类添加
	@RequestMapping("/saveFinanceProductFunds")//productManagerPic
	public String saveFinanceProductFunds(FinanceProductFunds financeProductFunds,@RequestParam("file_name")
	MultipartFile productManagerPic,HttpServletRequest request,HttpSession session) throws IOException{
		System.out.println(financeProductFunds.getEndDate()+financeProductFunds.getStartDate());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssssss");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
    	session.setAttribute("filename",productManagerPic.getOriginalFilename());
    	String type=productManagerPic.getOriginalFilename().substring(productManagerPic.getOriginalFilename().indexOf("."));
		Date date=new Date();
		String filenameTime=sdf.format(date)+type;
    	String path=request.getRealPath("/upload/");
    	File newfile=new File(path,filenameTime);
    	if(!newfile.exists()){
			newfile.createNewFile();
		}
    	productManagerPic.transferTo(newfile);
		financeProductFunds.setProductManagerPic(filenameTime);
		financeProductFunds.setCreateDate(sdf2.format(new Date()));
		this.yx_FinanceProductFunds_Service.saveFinanceProductFunds(financeProductFunds);
		return "redirect:/yx2/list2";
	}
	//未签署
	@RequestMapping("/listWqs/{id}")
	public String listWqs(HttpSession session,@PathVariable("id")int id){
		List<FinanceProductSubscribe> fe=this.yx_FinanceProductFunds_Service.listWqs(id);
		session.setAttribute("fe",fe);//period
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
		fe2.setStatus(3);
		yx_FinanceProductFunds_Service.updateqssb(fe2);
		return "redirect:/yx2/listWqs/{id2}";
	}
	//签署
	@RequestMapping("/selectsign/{id}/{period}")
	public String selectsign(@PathVariable("id")int id,HttpSession session,@PathVariable("period")int period){
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		date.setDate(date.getDate()+period);
		FinanceProductSubscribe fe3=this.yx_FinanceProductFunds_Service.selectqssb(id);
		session.setAttribute("fe3",fe3);
		session.setAttribute("endTime",sdf.format(date));
	    return "WEB-INF/yx_jsp/yx_FinanceProductSubscribe_sign";
	}
	//签署合同
	@RequestMapping("/savesign/{id2}")
	public String   savesign(FinanceProductSubscribe fe,@PathVariable("id2")int id2,
			@RequestParam("file_name") MultipartFile comment,@RequestParam("file_name2") MultipartFile riskReveal,
			HttpServletRequest request,HttpSession session) throws IOException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssssss");
		SimpleDateFormat sd2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	session.setAttribute("comment",comment.getOriginalFilename());
    	session.setAttribute("riskReveal", riskReveal.getOriginalFilename());
    	String type=comment.getOriginalFilename().substring(comment.getOriginalFilename().indexOf("."));
    	String type2=riskReveal.getOriginalFilename().substring(riskReveal.getOriginalFilename().indexOf("."));
		Date date=new Date();
		String filenameTime=sdf.format(date)+type;
		String filenameTime2=sdf.format(date)+type2;
    	String path=request.getRealPath("/upload/");
    	File newfile=new File(path,filenameTime);
    	File newfile2=new File(path,filenameTime2);
    	if(!newfile.exists()){
			newfile.createNewFile();
		}
    	if(!newfile2.exists()){
			newfile2.createNewFile();
		}
    	fe.setComment(path+filenameTime);
    	fe.setRiskReveal(path+filenameTime2);
    //FinanceProductSubscribe ff=this.yx_FinanceProductFunds_Service.selectqssb(id2);
       fe.setStatus(1);
		fe.setCreateDate(sd2.format(new Date()));
		fe.setUpdateDate(sd2.format(new Date()));
		fe.setEndDate(sd2.format(new Date()));
		fe.setStartDate(sd2.format(new Date()));
		this.yx_FinanceProductFunds_Service.updateqssb(fe);
		return "redirect:/yx2/listWqs/{id2}";
	}
	
}
