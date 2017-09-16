package com.item.finance.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.UserRole;

@Component
public class UserRoleDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Set<String> getRole(String id) {
		String sql = "select cname from user_role where id in (select role_id from user_role_relation where user_id ='"+id+"')";
		Session session = sessionFactory.getCurrentSession();
		Set<String> set = new HashSet<>();
		set.addAll(session.createSQLQuery(sql).list());
		return set;
	}

	public UserRole selectGetById(String id) {
		// TODO Auto-generated method stub
		System.out.println("id = "+ id);
		Session session = sessionFactory.getCurrentSession();
		String hql = "from UserRole where id = '"+id+"'";
		UserRole userRole = (UserRole) session.createQuery(hql).list().get(0);
		System.out.println(userRole.toString());
		return userRole;
	}

	public List<UserRole> list() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from UserRole";
		List<UserRole> list = session.createQuery(hql).list();
		System.out.println("UserRoleDao:list:"+list.size());
		return list;
	}

	public void save(UserRole t) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
	}
	
	
}
