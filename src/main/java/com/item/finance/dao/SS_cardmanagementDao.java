package com.item.finance.dao;

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
	
		String hql="from MemberBankcard where 0=0 ";
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
		String mobile_phone1=(String)map.get("mobile_phone1");  //手机号
		String member_name1=(String)map.get("member_name1");//绑卡姓名
		String card_no1=(String)map.get("card_no1");//绑卡卡号
		String qdate1=(String)map.get("qdate1");  //注册时间1
		String qdate2=(String)map.get("qdate2"); //注册时间2
		
		if(mobile_phone1!=null && !"".equals(mobile_phone1)){  //手机号
			hql=hql+" and mobile_phone like '%"+mobile_phone1+"%'";
		}
		if(member_name1!=null && !"".equals(member_name1)){ //绑卡姓名
			hql=hql+" and member_name like '%"+member_name1+"%'";
		}
		if(card_no1!=null && !"".equals(card_no1)){ //绑卡卡号
			hql=hql+" and card_no like '%"+card_no1+"%'";
		}
		
		if(qdate1!=null && !"".equals(qdate1)){  //注册时间1 开始时间
			hql=hql+" and create_date>='%"+qdate1+"%'";
		}
		if(qdate2!=null && !"".equals(qdate2)){  //注册时间2  结束时间
			hql=hql+" and create_date<='%"+qdate2+"%'";
		}
		return hql;
	}
	

}
