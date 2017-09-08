package com.item.finance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.Member;

@Component
public class Ss_zhManangerDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	//账号管理列表显示
	public List<Member>listzh(){
		Session session=getSession();
		String hql="from Member";
		List<Member>list=session.createQuery(hql).list();
		return list;
	}
	
	

}
