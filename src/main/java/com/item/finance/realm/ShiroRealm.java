package com.item.finance.realm;

import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.item.finance.bean.User;
import com.item.finance.services.RolePermissionRelationService;
import com.item.finance.services.UserRoleService;
import com.item.finance.services.UserService;
/**
 * 
 * @author 侯凡
 *	权限管理
 */
public class ShiroRealm extends AuthorizingRealm {
	
	/**
	 * 用户的服务层
	 */
	private UserService userService;

	private UserRoleService userRoleService;
	
	private RolePermissionRelationService rolePermissionRelationService ;

	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}	

	public UserRoleService getUserRoleService() {
		return userRoleService;
	}

	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	public RolePermissionRelationService getRolePermissionRelationService() {
		return rolePermissionRelationService;
	}

	public void setRolePermissionRelationService(
			RolePermissionRelationService rolePermissionRelationService) {
		this.rolePermissionRelationService = rolePermissionRelationService;
	}

	/**
	 * 获取授权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		//从 PrincipalCollection 获取用户登录信息
				System.out.println("ShiroRealm:获取用户授权信息");
				String username = (String)arg0.getPrimaryPrincipal();
				//根据username查询user 并赋予 SimpleAuthorizationInfo
				SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
				//角色
				//根据 username 查询 set<role>
				Set<String> roles = userRoleService.getRole(username);
				System.out.println("用户角色 = "+ roles.toArray().toString());
				authorizationInfo.setRoles(roles);
				//权限
				//根据 set<role> 查询 set<permission>
				authorizationInfo.setStringPermissions(rolePermissionRelationService.getPermission(roles));
				return authorizationInfo;
	}

	/**
	 * 获取认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken arg0) throws AuthenticationException {
		System.out.println("ShiroRealm:验证当前登录的用户");
		//1. 把 AuthenticationToken 转换为 UsernamePasswordToken 
		 UsernamePasswordToken token = (UsernamePasswordToken) arg0;  
		 
		//2. 从 UsernamePasswordToken 中来获取 username
	        String username = token.getUsername();  
	        
	      //3. 调用数据库的方法, 从数据库中查询 username 对应的用户记录
	        System.out.println("ShiroRealm:username = "+username);
	        
	      //4. 若用户不存在, 则可以抛出 UnknownAccountException 异常
	        if (username != null && !"".equals(username)) {  
	            User user = userService.getUserByUserName(username); 
	            if (user != null) {  
//	            	System.out.println("userName="+user.getName()+",password="+user.getPassword());
	            	// 盐值. 
	        		ByteSource credentialsSalt = ByteSource.Util.bytes(username);
	            	
	                AuthenticationInfo info =  new SimpleAuthenticationInfo(user.getName(), user.getPassword(), credentialsSalt, getName());  
//	                SecurityUtils.getSubject().getSession().setAttribute("currentUser", user);  
	                return info;
	            }  
	        }  
	  
	        return null;
	}
	
	public static void main(String[] args) {
		String hashAlgorithmName = "MD5";
		Object credentials = "123456";
		Object obj = ByteSource.Util.bytes("admin");
		int hashIterations = 1024;
		Object result = new SimpleHash(hashAlgorithmName, credentials, obj, hashIterations);
		System.out.println("password = 123456,盐值加密之后 = "+ result);
	}

}
