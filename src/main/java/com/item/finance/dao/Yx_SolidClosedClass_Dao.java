package com.item.finance.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.FinanceProductFunds;

@Component
public class Yx_SolidClosedClass_Dao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public void save(FinanceProductFunds financeProductFunds){
		Session session=getSession();
		session.save(financeProductFunds);
	}

}
