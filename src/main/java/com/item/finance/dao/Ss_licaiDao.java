package com.item.finance.dao;

import java.util.List;
import java.util.Map;

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
	public List<FinancialPlanner> list(Map map){
		Session session=getSession();
		String hql="from FinancialPlanner as fina where 0=0" ;
		hql=gethql(map, hql);
		List<FinancialPlanner>list=session.createQuery(hql).list();
		return list;
	}
	
	
	//模糊查询
		public String gethql(Map map,String hql){
			String amobile_Phone=(String)map.get("amobile_Phone");  //手机号
			String amemberName=(String)map.get("amemberName");//真实姓名
			String astatu=(String)map.get("astatu");//状态
			String adate1=(String)map.get("adate1");  //注册时间1
			String adate2=(String)map.get("adate2"); //注册时间2
			/*
			if(mobile1!=null && !"".equals(mobile1)){  //手机号
				hql=hql+" and member.mobile_Phone like '%"+mobile1+"%'";
			}*/
			
			if(amobile_Phone!=null && !"".equals(amobile_Phone)){ //手机号
				hql=hql+" and fina.member.mobile_Phone like '%"+amobile_Phone+"%'";
			}
			
			
			if(amemberName!=null && !"".equals(amemberName)){ //真实姓名
				hql=hql+" and  fina.member.memberName like '%"+amemberName+"%'";
			}
			if(astatu!=null && !"".equals(astatu)){ //状态
				hql=hql+" and status= "+astatu+"";
			}
			
			if(adate1!=null && !"".equals(adate1)){  //注册时间1 开始时间
				hql=hql+" and createDate>='"+adate1+"'";
			}
			if(adate2!=null && !"".equals(adate2)){  //注册时间2  结束时间
				hql=hql+" and createDate<='"+adate2+"'";
			}
			return hql;
		}

}
