package com.item.finance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.Member;

@Component
public class MemberDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void save(Member member) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(member);
	}

	public Member selectGetByName(String name) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Member where name = '"+name+"'";
		Member member = (Member) session.createQuery(hql).list().get(0);
		return member;
	}
	
}
