package com.item.finance.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RolePermissionRelationDao {
	
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
	
	
}
