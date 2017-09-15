package com.item.finance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.finance.bean.FinanceProductFunds;

@Component
public class Yx_FinanceProductFunds_Dao {
	@Autowired
	private SessionFactory sessionFactory;
	public Session geSession(){
		return sessionFactory.getCurrentSession();
	}
	public List<FinanceProductFunds> listFinanceProductFunds(){
		Session session=geSession();
		String hql="from FinanceProductFunds";
		List<FinanceProductFunds> list=session.createQuery(hql).list();
		return  list;
	}
	public FinanceProductFunds listEdit(int id){
		Session session=geSession();
		FinanceProductFunds fs=(FinanceProductFunds)session.get(FinanceProductFunds.class, id);
		return fs;
	}

}
