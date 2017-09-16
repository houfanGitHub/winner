package com.item.finance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.UserRoleRelation;

@Component
public class UserRoleRelationDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(UserRoleRelation userRoleRelation){
		Session session = sessionFactory.getCurrentSession();
		session.save(userRoleRelation);
	}

	public List<UserRoleRelation> selectGetByUid(String id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from UserRoleRelation where user_id = '"+id+"'";
		List<UserRoleRelation> list = session.createQuery(hql).list();
		return list;
	}

	public void delete(UserRoleRelation userRoleRelation) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(userRoleRelation);
	}
}
