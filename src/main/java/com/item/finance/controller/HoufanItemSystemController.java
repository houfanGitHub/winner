package com.item.finance.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.item.finance.bean.User;
import com.item.finance.bean.UserRole;
import com.item.finance.bean.UserRoleRelation;
import com.item.finance.services.UserRoleRelationService;
import com.item.finance.services.UserRoleService;
import com.item.finance.services.UserService;

@Controller
@RequestMapping("/system")
public class HoufanItemSystemController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private UserRoleRelationService userRoleRelationService;
	
	@RequestMapping("/users")
	public String systemUsers(Map<String,Object> map){
		getUserList(map);
		return "/WEB-INF/backstage/system/users";
	}
	
	//查询所有用户信息
	public void getUserList(Map<String,Object> map){
		List<User> list = userService.list();
		map.put("userList", list);
	}
	
	@RequestMapping("/asynchronousUsers")
	@ResponseBody
	public void asynchronousUsers(Map<String,Object> map){
		getUserList(map);
	}
	
	@RequestMapping("/roles")
	public String roles(Map<String,Object> map){
		//查询所有角色信息
		List<UserRole> list = userRoleService.list();
		map.put("roleList", list);
		return "/WEB-INF/backstage/system/roles";
	}
	
	@RequestMapping("/toPasswords")
	public String passwords(){
		return "/WEB-INF/backstage/system/passwords";
	}
	
	/**
	 * 验证原密码
	 */
	@RequestMapping("/toPasswordValidation")
	@ResponseBody
	public boolean toPasswordValidation(String oldPassword){
		System.out.println("验证原密码:oldPassword = "+ oldPassword);
		User user = getUser();
		System.out.println("name = "+ user.getName()+",passowrd = "+user.getPassword());
		if(userService.toPasswordValidation(user,oldPassword)){
			return true;
		}
		return false;
	}
	
	public User getUser(){
		//获取用户信息
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		return user;
	}
	
	/**
	 * 修改密码
	 * @param newPassword
	 * @return
	 */
	@RequestMapping("/updatePassword")
	@ResponseBody
	public boolean updatePassword(String newPassword){
		System.out.println("修改密码:newPassword = "+ newPassword);
		if(userService.updatePassword(getUser(),newPassword)){
			return true;
		}
		return false;
	}
	
	//用户注册
		@RequestMapping("/userAdd")
		@ResponseBody
		public boolean userRegistration(String name,String userName,String phone,String password){
			User user = new User();
			user.setName(name);
			user.setUserName(userName);
			user.setMobile_Phone(phone);
			user.setPassword(password);
//			byte delFlag = '0';	//删除标志
			byte identity = 1;	//身份
			user.setCreateDate(new Date());	//创建时间
			user.setIdentity(identity);
			user.setSalt(name);	//密码盐
			user.setStatus((byte)0);	//账号状态(正常，锁定，删除)
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
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
}
