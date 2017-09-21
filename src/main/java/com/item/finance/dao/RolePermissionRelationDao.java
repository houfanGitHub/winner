package com.item.finance.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.RolePermissionRelation;
import com.item.finance.bean.UserRole;

@Component
public class RolePermissionRelationDao {
	
	@Autowired
	private UserRoleDao userRoleDao;
	@Autowired
	private SessionFactory sessionFactory;

	public Set<String> getPermission(Set<String> roles) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<>();
		Session session = sessionFactory.getCurrentSession();
		for (String string : roles) {
			String sql = "select permission_ename role_permission_relation where role_id =(select id from user_role where cname='"+string+"')";
			set.addAll(session.createQuery(sql).list());
		}
		return set;
	}
	
	/**
	 * 根据角色id查询权限名称
	 * @param roleId
	 * @return
	 */
	public Set<String> selectGetByRoleId(String roleId) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<>();
		Session session = sessionFactory.getCurrentSession();
		String sql = "select permission_ename from role_permission_relation where role_id = '" + roleId +"'";
		set.addAll(session.createSQLQuery(sql).list());
		return set;
	}

	public void updateByRoleId(String[] pname, String roleId) {
		Session session = sessionFactory.getCurrentSession();
			List<String> listPname = new ArrayList<>();
			Collections.addAll(listPname, pname);
			//得到原来的所有权限
			Set<String> oldSet = selectGetByRoleId(roleId);
			for(int i=listPname.size();i>0;i--){
				//移除重复项
				if(oldSet.contains(listPname.get(i-1))){
					oldSet.remove(listPname.get(i-1));
					listPname.remove(i-1);
				}
			}
			System.out.println("去除重复项之后:oldSet="+oldSet.toString());
			System.out.println("去除重复项之后:listPname="+listPname);
			//如果还有原来的权限存在则删除
			if(!oldSet.isEmpty()){
				//根据pname和role查询该对象并删除
				for (String string : oldSet) {
					String hql = "from RolePermissionRelation where role_id = '"+roleId+"' and permission_ename = '"+string+"'";
					session.delete(session.createQuery(hql).list().get(0));
				}
			}
			
			//如果还有新的元素存在则添加
			if(!listPname.isEmpty()){
				UserRole userRole = null;
				RolePermissionRelation rolePermissionRelation = null;
				for (String string : listPname) {
					//根据roleId查询出该角色对象
					userRole = userRoleDao.selectGetById(roleId);
					rolePermissionRelation = new RolePermissionRelation(string, new Date(), userRole);
					session.save(rolePermissionRelation);
				}
			}
	}
	
	
}
