package com.item.finance.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.item.finance.services.ItemServiceImpl;
/**
 * 
 * @author 侯凡
 *	权限管理
 */
public class ShiroRealm extends AuthorizingRealm {
	
	/**
	 * 用户的服务层
	 */
	private ItemServiceImpl itemServiceImpl;

	public ItemServiceImpl getItemServiceImpl() {
		return itemServiceImpl;
	}

	public void setItemServiceImpl(ItemServiceImpl itemServiceImpl) {
		this.itemServiceImpl = itemServiceImpl;
	}

	/**
	 * 获取授权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 获取认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
