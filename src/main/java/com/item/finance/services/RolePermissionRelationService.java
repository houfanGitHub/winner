package com.item.finance.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.RolePermissionRelation;
import com.item.finance.dao.RolePermissionRelationDao;

@Service
@Transactional
public class RolePermissionRelationService implements ItemServiceImpl<RolePermissionRelation> {

	@Autowired
	private RolePermissionRelationDao rolePermissionRelationDao;
	
	@Override
	public RolePermissionRelation selectGetById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RolePermissionRelation> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(RolePermissionRelation t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(RolePermissionRelation t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(RolePermissionRelation t) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 根据角色查询权限
	 * @param roles
	 * @return
	 */
	public Set<String> getPermission(Set<String> roles) {
		// TODO Auto-generated method stub
		Set<String> set = rolePermissionRelationDao.getPermission(roles);
		return set;
	}

	/**
	 * 根据角色id查询权限名称
	 * @param roleId
	 * @return
	 */
	public Set<String> selectGetByRoleId(String roleId) {
		// TODO Auto-generated method stub
		Set<String> set = rolePermissionRelationDao.selectGetByRoleId(roleId);
		return set;
	}

	public void updateByRoleId(String[] pname, String roleId) {
		// TODO Auto-generated method stub
		rolePermissionRelationDao.updateByRoleId(pname,roleId);
	}

}
