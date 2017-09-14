package com.item.finance.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.item.finance.bean.User;
import com.item.finance.bean.UserRole;
import com.item.finance.bean.UserRoleRelation;
import com.item.finance.services.UserRoleRelationService;
import com.item.finance.services.UserRoleService;
import com.item.finance.services.UserService;

@Controller
@RequestMapping("/itemweb")
public class HoufanWebItemController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleRelationService userRoleRelationService;
	@Autowired
	private UserRoleService userRoleService;
	
	//进入用户登录界面
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "WEB-INF/login/login";
	}
	
	//进入用户注册界面
	@RequestMapping("/toRegistration")
	public String toRegistration(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException {
		
		return "WEB-INF/registration/registration";
	}
	
	/**
	 * 前台登陆
	 * @param user
	 * @return
	 */
	@RequestMapping("/userLogin")
	public String userLogin(User user){
			 login(user.getName(), user.getPassword());
	        // 登录成功后会跳转到successUrl配置的链接，不用管下面返回的链接。  
	        return "redirect:/itemweb/index";  
	}
	
	public void login(String name,String password){
		SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());  
        // 登录后存放进shiro token  	
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);  
       token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();  
        subject.login(token); 
	}
	
	@RequestMapping("/backstageUserLogin")
	public String backstageUserLogin(@RequestParam("name")String name,@RequestParam("password")String password){
		login(name, password);
		return "redirect:/itemweb/backstage";
	}
	
	//用户注册
	@RequestMapping("/userRegistration")
	public String userRegistration(User user,@RequestParam(required=false)String invitationCode){
		System.out.println("invitationCode = "+invitationCode);
		
		Date createDate = new Date();	//创建时间
//		byte delFlag = '0';	//删除标志
		byte identity = 1;	//身份
		String salt = user.getName();	//密码盐
		byte status = 0;	//账号状态(正常，锁定，删除)
		user.setCreateDate(createDate);
		user.setIdentity(identity);
		user.setSalt(salt);
		user.setStatus(status);
		//盐值加密
		String hashAlgorithmName = "MD5";
		Object credentials = user.getPassword();
		Object obj = ByteSource.Util.bytes(user.getName());
		int hashIterations = 1024;
		Object result = new SimpleHash(hashAlgorithmName, credentials, obj, hashIterations);
		System.out.println("password = "+user.getPassword()+",盐值加密之后 = "+ result);
		user.setPassword(result.toString());
		//输出用户信息
		System.out.println(user.toString());
		
		//添加用户信息
		try {
			userService.save(user);
			//查询普通用户的信息
			UserRole userRole = userRoleService.selectGetById("4");
			//添加角色信息
			UserRoleRelation urr = new UserRoleRelation(user, userRole, new Date());
			userRoleRelationService.save(urr);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/itemweb/toRegistration";
		}
		return "redirect:/itemweb/toLogin";
	}
	
	//返回首页
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	//后台显示页面
	@RequestMapping("/backstage")
	public String backstage(){
		return "WEB-INF/backstage/show";
	}
	
	//后台登陆页面
	@RequestMapping("/backstageLogin")
	public String backstageLogin(){
		return "WEB-INF/backstage/login";
	}
	
	//后台登陆页面
	@RequestMapping("/error")
	public String error(){
		return "WEB-INF/error/error";
	}
}
