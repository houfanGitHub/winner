package com.item.finance.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.MemberBankcard;

@Component
public class SS_cardmanagementDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	//列表显示
	public List<MemberBankcard>list(Map map){
		Session session=getSession();
	
		String hql="from MemberBankcard as membank where 0=0 ";
		hql=gethql(map, hql);
		List<MemberBankcard>list=session.createQuery(hql).list();
		return list;
	}
	
	//得到 id
	public MemberBankcard getByID(String id){
		Session session=getSession();
		MemberBankcard memberBankcard=(MemberBankcard)session.get(MemberBankcard.class, id);
		return memberBankcard;
	}
	
	//模糊查询
	public String gethql(Map map,String hql){
		String mobile1=(String)map.get("mobile1");  //手机号
		String name1=(String)map.get("name1");//绑卡姓名
		String card1=(String)map.get("card1");//绑卡卡号
		String qdate1=(String)map.get("qdate1");  //注册时间1
		String qdate2=(String)map.get("qdate2"); //注册时间2
		/*
		if(mobile1!=null && !"".equals(mobile1)){  //手机号
			hql=hql+" and member.mobile_Phone like '%"+mobile1+"%'";
		}*/
		
		if(mobile1!=null && !"".equals(mobile1)){ //手机号
			hql=hql+" and membank.member.mobile_Phone like '%"+mobile1+"%'";
		}
		
		
		if(name1!=null && !"".equals(name1)){ //绑卡姓名
			hql=hql+" and  membank.member.memberName like '%"+name1+"%'";
		}
		if(card1!=null && !"".equals(card1)){ //绑卡卡号
			hql=hql+" and cardNo like '%"+card1+"%'";
		}
		
		if(qdate1!=null && !"".equals(qdate1)){  //注册时间1 开始时间
			hql=hql+" and createDate>='"+qdate1+"'";
		}
		if(qdate2!=null && !"".equals(qdate2)){  //注册时间2  结束时间
			hql=hql+" and createDate<='"+qdate2+"'";
		}
		return hql;
	}
	
	//解绑状态的方法
	public void updateDelflag(MemberBankcard memberBankcard){
		Session session=getSession();
		Date date=new Date();
		memberBankcard.setUpdateDate(date);
		session.update(memberBankcard);
	}
	

}
