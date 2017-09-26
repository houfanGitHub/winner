package com.item.finance.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.item.finance.bean.OverseaConfig;
import com.item.finance.bean.OverseaConfigSubscribe;
import com.item.finance.bean.Subject;
import com.item.finance.services.Yx_OverseaConfig_Services;

@Controller
@RequestMapping("/yx3")
public class Yx_OverseaConfig_Controller {
	@Autowired
private Yx_OverseaConfig_Services yx_OverseaConfig_Services;
	
	@RequestMapping("/list3")
	public String list(HttpSession session){
		List<OverseaConfig> list=yx_OverseaConfig_Services.list();
		session.setAttribute("list", list);
		return "WEB-INF/yx_jsp/yx_overseaconfig_show";
	}
	//海外配置预约记录
	@RequestMapping("/list3_3")
	public String list3_3(HttpSession session){
		List<OverseaConfigSubscribe> list=yx_OverseaConfig_Services.list2();
		for (OverseaConfigSubscribe overseaConfigSubscribe : list) {
			System.out.println(overseaConfigSubscribe.getName());
		}
		session.setAttribute("list", list);
		return "WEB-INF/yx_jsp/yx_overseaconfig_show2";
	}
	//修改前查询
	@RequestMapping("/listEdit/{id}")
	public String listEdit(@PathVariable("id")int id,HttpSession session){
     SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		OverseaConfig overseaConfig=yx_OverseaConfig_Services.selectOverseaConfig(id);
		//overseaConfig.setStartDate(sdf.format(overseaConfig.getStartDate()));
		//String ss=sdf.format(overseaConfig.getStartDate());
		session.setAttribute("overseaConfig",overseaConfig);
		return "WEB-INF/yx_jsp/yx_overseaconfig_editshow";
	}
	//修改
	@RequestMapping("/updateOverseaConfig")
	public String updateOverseaConfig(OverseaConfig overseaConfig,
			@RequestParam("fileopload")MultipartFile file_name,
			HttpServletRequest request,HttpSession session) throws IOException{
		//System.out.println(overseaConfig.getStartDate()+","+overseaConfig.getEndDate()+","+overseaConfig.getId()+overseaConfig.getChildTitle());
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		overseaConfig.setAddTime(sdf2.format(new Date()));
		overseaConfig.setUpdTime(sdf2.format(new Date()));
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssssss");
    	session.setAttribute("fileopload",file_name.getOriginalFilename());
    	String type=file_name.getOriginalFilename().substring(file_name.getOriginalFilename().indexOf("."));
    	Date date=new Date();
		String filenameTime=sdf.format(date)+type;
    	String path=request.getRealPath("/upload/");
    	File newfile=new File(path,filenameTime);
    	if(!newfile.exists()){
			newfile.createNewFile();
		}
    	file_name.transferTo(newfile);
		overseaConfig.setOverseaIcon(filenameTime);
		
		this.yx_OverseaConfig_Services.updateOverseaConfig(overseaConfig);
		return "redirect:/yx3/list3";
	}

	@RequestMapping("/toOverseaConfig")
	public String toOverseaConfig(){
		return "WEB-INF/yx_jsp/yx_overseaconfig_add";
	}
	
	@RequestMapping("/saveOverseaConfig")
	public String saveOverseaConfig(OverseaConfig overseaConfig,@RequestParam("fileopload")MultipartFile fileopload,
			HttpServletRequest request,HttpSession session) throws IOException{
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		overseaConfig.setAddTime(sdf2.format(new Date()));
		overseaConfig.setUpdTime(sdf2.format(new Date()));
		//System.out.println(overseaConfig.getStartDate()+","+overseaConfig.getEndDate()+","+overseaConfig.getId()+overseaConfig.getChildTitle());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssssss");
    	session.setAttribute("fileopload",fileopload.getOriginalFilename());
    	String type=fileopload.getOriginalFilename().substring(fileopload.getOriginalFilename().indexOf("."));
    	Date date=new Date();
		String filenameTime=sdf.format(date)+type;
    	String path=request.getRealPath("/upload/");
    	File newfile=new File(path,filenameTime);
    	if(!newfile.exists()){
			newfile.createNewFile();
		}
    	fileopload.transferTo(newfile);
		overseaConfig.setOverseaIcon(filenameTime);
		//System.out.println(overseaConfig.getEndDate()+overseaConfig.getStartDate());
		this.yx_OverseaConfig_Services.saveOverseaConfig(overseaConfig);
		return "redirect:/yx3/list3";
		
	}
	
}
