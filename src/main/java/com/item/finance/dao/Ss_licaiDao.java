package com.item.finance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.FinancialPlanner;

@Component
public class Ss_licaiDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	//得到 id
	public FinancialPlanner getByid(String id){
		Session session=getSession();
		FinancialPlanner financialPlanner=(FinancialPlanner)session.get(FinancialPlanner.class, id);
		return financialPlanner;
	}
	
	//显示
	public List<FinancialPlanner> list(){
		Session session=getSession();
		String hql="from FinancialPlanner as fina" ;
		List<FinancialPlanner>list=session.createQuery(hql).list();
		return list;
	}
	
	public List<FinancialPlanner> listfina(){
		Session session=getSession();
		String hql="from FinancialPlanner as fina" ;
		List<FinancialPlanner>listfina=session.createQuery(hql).list();
		return listfina;
	}

}
