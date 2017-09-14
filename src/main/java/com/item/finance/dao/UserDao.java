package com.item.finance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.item.finance.bean.User;

@Repository
public class UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void save(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}
	

	public User selectGetByUserName(String userName) {
//		System.out.println("selectGetByUserName:name = "+userName);
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from User where name = '"+userName+"'";
		List<User> list = session.createQuery(hql).list();
		System.out.println("selectGetByUserName:list = "+list.size());
		User user = null;
		if(!list.isEmpty()){
			user = list.get(0);
		}
		return user;
	}


	public List<User> list() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from User";
		List<User> list = session.createQuery(hql).list();
		return list;
	}
	

}
