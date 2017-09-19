package com.item.finance.controller;

import java.math.BigInteger;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.item.finance.bean.User;
import com.item.finance.bean.UserRole;
import com.item.finance.bean.UserRoleRelation;
import com.item.finance.services.RolePermissionRelationService;
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
	@Autowired
	private RolePermissionRelationService rolePermissionRelationService;
	
	@RequestMapping("/updatePermission/{pname}")
	@ResponseBody
	public boolean updatePermission(@PathVariable(name="pname")String[] pname,String roleId){
		//修改权限信息
		try {
			rolePermissionRelationService.updateByRoleId(pname,roleId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@RequestMapping("/menuSystem/{id}")
	public String menuSystem(@PathVariable(value="id")String roleId,Map<String,Object> map){
		//根据id查询角色对应的权限
		System.out.println("system>>menuSystem:roleId = "+roleId);
		Set<String> setPermission = rolePermissionRelationService.selectGetByRoleId(roleId);
		System.out.println("system>>menuSystem:setPermission.size = "+setPermission.size());
		String text = JSON.toJSONString(setPermission);
		map.put("setPermission", text);
		map.put("roleId", roleId);
		return "/WEB-INF/backstage/system/menu";
	}
	
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
			String identity = "1";	//身份
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
		
		@RequestMapping("/deleteUser/{id}")
		@ResponseBody
		public boolean deleteUser(@PathVariable(value="id")String id){
			System.out.println("deleteUser:id = "+id);
			//获取user信息
			User user = userService.selectGetById(id);
			//删除user信息
			try {
				//删除关联信息
				List<UserRoleRelation> list = userRoleRelationService.selectGetByUid(id);
				for (UserRoleRelation urr : list) {
					urr.setUserRole(null);
					userRoleRelationService.delete(urr);
				}
				userService.delete(user);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
		@RequestMapping("/toUserUpdate")
		@ResponseBody
		public boolean toUserUpdate(String id,String ustauts,String cname){
			System.out.println("..............................................");
			System.out.println("toUserUpdate:id = "+id+",ustauts = "+ustauts+",cname = "+cname);
			try {
				//根据id获得user信息
				User user = userService.selectGetById(id);
				//修改user信息
				user.setStatus(Byte.valueOf(ustauts));
				Iterator<UserRoleRelation> it = user.getUserRoleRelations().iterator();
				while(it.hasNext()){
					it.next().getUserRole().setId(cname);;
				}
				userService.update(user);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
		/**
		 * 添加角色信息
		 * @param cname
		 * @param remark
		 * @return
		 */
		@RequestMapping("/addUserRole")
		@ResponseBody
		public boolean addUserRole(String cname,String remark){
			System.out.println("addUserRole:cname = "+cname+",remark = "+remark);
			try {
				UserRole userRole = new UserRole();
				userRole.setAvailable((byte)1);
				userRole.setCategory("User");
				userRole.setCname(cname);
				userRole.setDelFlag((byte)0);
				userRole.setCreateDate(new Date());
				userRole.setEname("user:common");
				userRole.setRemark(remark);
				userRole.setSourceId(BigInteger.valueOf(0));
				userRole.setSourceType((byte)0);
				userRole.setUpdateDate(new Date());
				userRole.setRolePermissionRelations(null);
				userRoleService.save(userRole);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
}
