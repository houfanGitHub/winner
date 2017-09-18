package com.item.finance.dao;

import java.util.List;
import java.util.Map;

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
	public List<FinanceProductFunds> listFinanceProductFunds(Map map){
		Session session=geSession();
		String hql="from FinanceProductFunds where 0=0";
		hql=datehql(map, hql);
		List<FinanceProductFunds> list=session.createQuery(hql).list();
		return  list;
	}
	public String datehql(Map map,String hql){
		String qname=(String)map.get("qname");
		String qstatus=(String)map.get("qstatus");
		String qtype=(String)map.get("qtype");
		if(qname!=null&&!qname.equals("")){
			hql+="and name like '%"+qname+"%'";
		}
		if(qstatus!=null&&!qstatus.equals("")){
			hql+="and status like '%"+qstatus+"%'";
		}
		if(qtype!=null&&!qtype.equals("")){
			hql+="and type like '%"+qtype+"%'";
		}
		return hql;
	}
	public FinanceProductFunds listEdit(int id){
		Session session=geSession();
		FinanceProductFunds fs=(FinanceProductFunds)session.get(FinanceProductFunds.class, id);
		return fs;
	}

}
