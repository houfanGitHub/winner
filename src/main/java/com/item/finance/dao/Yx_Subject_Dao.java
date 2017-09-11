package com.item.finance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.FinanceProductFunds;
import com.item.finance.bean.Subject;

@Component
public class Yx_Subject_Dao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public void saveSubject(Subject subject){
		Session session=getSession();
		session.save(subject);
	}
	public Subject selectSubject(String id){
		Session session=getSession();
		Subject subject=(Subject)session.get(Subject.class, id);
	return subject;
	}
	public List<Subject> listSubject(){
		Session session=getSession();
		String hql="from Subject";
		List<Subject> list=session.createQuery(hql).list();
		return list;
	}
    public void deleteSubject(Subject subject){
    	Session session=getSession();
    	session.delete(subject);
    }
    public void updateSubject(Subject subject){
    	Session session=getSession();
    	session.update(subject);
    }
}
