package com.item.finance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.FinanceProductFunds;

@Component
public class Yx_FinanceProductFunds_Dao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public void save(FinanceProductFunds financeProductFunds){
		Session session=getSession();
		session.save(financeProductFunds);
	}
	public FinanceProductFunds selectFinanceProductFunds(String id){
		Session session=getSession();
		FinanceProductFunds financeProductFunds=(FinanceProductFunds)session.get(FinanceProductFunds.class, id);
	return financeProductFunds;
	}
	public List<FinanceProductFunds> listFinanceProductFunds(){
		Session session=getSession();
		String hql="from FinanceProductFunds";
		List<FinanceProductFunds> list=session.createQuery(hql).list();
		return list;
	}
    public void deleteFinanceProductFunds(FinanceProductFunds financeProductFunds){
    	Session session=getSession();
    	session.delete(financeProductFunds);
    }
    public void updateFinanceProductFunds(FinanceProductFunds financeProductFunds){
    	Session session=getSession();
    	session.update(financeProductFunds);
    }
}
