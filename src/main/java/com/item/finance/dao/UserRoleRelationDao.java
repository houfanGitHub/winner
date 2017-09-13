package com.item.finance.dao;

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
}
