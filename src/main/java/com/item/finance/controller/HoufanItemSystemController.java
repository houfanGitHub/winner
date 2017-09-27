package com.item.finance.controller;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.item.finance.avtivity.DeoploymentProcessDefinition;
import com.item.finance.bean.User;
import com.item.finance.bean.UserRole;
import com.item.finance.bean.UserRoleRelation;
import com.item.finance.services.MemberAccountService;
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
	@Autowired
	private DeoploymentProcessDefinition deoploymentProcessDefinition;
	@Autowired
	private MemberAccountService memberAccountService;
	
	/**
	 * 后台审核流程
	 */
	@RequestMapping("/toActivitiReply")
	public String toActivitiReply(Map<String,Object> map){
		//获取当前登录的user信息
		User user = getUser();
		Set<UserRoleRelation> sets = user.getUserRoleRelations();
		String ename = "";
		for (UserRoleRelation userRoleRelation : sets) {
			ename = userRoleRelation.getUserRole().getEname();
		}
		System.out.println("后台审核流程：ename = "+ename);
		//根据ename查询该任务
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		List<String> list = deoploymentProcessDefinition.historyTaskListUnfinished(processEngine, ename);
		List<Map<String, String>> listMaps = deoploymentProcessDefinition.getProcessVariables(processEngine, list);
		map.put("listMaps", listMaps);
		return "WEB-INF/backstage/system/activitiReply";
	}
	
	@RequestMapping("/getThrough")
	@ResponseBody
	public boolean getThrough(String id,String bankCard,String withdrawAmount,String memberID){
		try {
			ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
			//流程通过
			//获取当前登录的user信息
				User user = getUser();
				Set<UserRoleRelation> sets = user.getUserRoleRelations();
				String ename = "";
				for (UserRoleRelation userRoleRelation : sets) {
					ename = userRoleRelation.getUserRole().getEname();
				}
			List<Task> list = processEngine .getTaskService()// 与正在执行的任务管理相关的service
					.createTaskQuery()// 创建任务查询对象
					// 查询条件
					.taskAssignee(ename)// 指定个人任务查询，指定办理人
					// .taskCandidateGroup("")//组任务的办理人查询
					// .processDefinitionId("")//使用流程定义ID查询
					 .processInstanceId(id)//使用流程实例ID查询
					// .executionId(executionId)//使用执行对象ID查询
					/** 排序 */
					.orderByTaskCreateTime().asc()// 使用创建时间的升序排列
					// 返回结果集
					// .singleResult() //返回唯一的结果集
					// .count()//返回结果集的数量
					// .listPage(firstResult, maxResults)//分页查询
					.list();// 返回列表
			System.out.println("List<Task>.size = " + list.size());
			if (list != null && list.size() > 0) {
				for (Task task : list) {
					System.out.println("任务ID：" + task.getId());
					 //任务ID  
			        String taskId = task.getId();  
			        String IsAgree = "批准";  
//			        String IsNotAgree = "驳回";  
//			        String IsStudent = "";  
			          
			        //完成任务的同时，设置流程变量，使用流程变量用来指定完成任务后，下一个连线，对应sequenceFlow.bpmn文件中${message=='不重要'}  
			        Map<String, Object> variables = new HashMap<String, Object>();  
			        variables.put("outcome", IsAgree);  
			        processEngine.getTaskService()//与正在执行的任务管理相关的Service  
			                    .complete(taskId,variables); 
			        if(ename.equals("admin:system")){	//如果会超级管理员 流程结束	完成提款 添加提款记录
			        	HoufanWebItemController houfanWebItemController = new HoufanWebItemController();
			        	
			        	//alipay转账
			        	AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do","app_id","your private_key","json","GBK","alipay_public_key","RSA2");
			        	AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
			        	request.setBizContent("{" +
			        	"\"out_biz_no\":\""+houfanWebItemController.getRandomPayName()+"\"," +
			        	"\"payee_type\":\"ALIPAY_LOGONID\"," +
			        	"\"payee_account\":\"cytjfy1234@sandbox.com\"," +
			        	"\"amount\":\""+withdrawAmount+"\"," +
			        	"\"payer_show_name\":\"赢+系统提现\"," +
			        	"\"payee_real_name\":\""+memberID+"\"," +
			        	"\"remark\":\"赢+系统,您的财富之友\"" +
			        	"  }");
			        	AlipayFundTransToaccountTransferResponse response = alipayClient.execute(request);
			        	if(response.isSuccess()){
			        	System.out.println("调用成功");
			        	//添加提款记录
//			        	memberAccountService.update(memberAccount);
			        	} else {
			        	System.out.println("调用失败");
			        	}
			        }
			        
			        System.out.println("完成任务：任务ID："+taskId); 
					System.out.println("任务名称:" + task.getName());
					System.out.println("任务的创建时间:" + task.getCreateTime());
					System.out.println("任务的办理人:" + task.getAssignee());
					System.out.println("流程实例ID:" + task.getProcessInstanceId());
					System.out.println("执行对象ID:" + task.getExecutionId());
					System.out.println("流程定义ID:" + task.getProcessDefinitionId());
					System.out.println("##################################################");
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
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
