package com.item.finance.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Id;
import javax.print.DocFlavor.STRING;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
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
	public List<Member>listzh(Map map){
		Session session=getSession();
		String hql="from Member where 0=0";
		hql=gethql(map, hql);
		List<Member>list=session.createQuery(hql).list();
		return list;
	}
	
	//得到 id
	public Member getId(String id){
		Session session=getSession();
		Member member=(Member)session.get(Member.class, id);
		return member;
	}
	
	//模糊查询
	public String gethql(Map map ,String hql){
		String qname1=(String)map.get("qname1");//用户名
		String mobile=(String)map.get("mobile");//手机号
		String qname2=(String)map.get("qname2");//姓名
		String invit=(String)map.get("invit");//邀请码
		String create_date1=(String)map.get("create_date1");//注册时间1
		String create_date2=(String)map.get("create_date2");//注册时间2
		if(qname1!=null && !"".equals(qname1)){  //用户名
			hql=hql+" and name like '%"+qname1+"%'";
		}
		if(mobile!=null && !"".equals(mobile)){ //手机号
			hql=hql+" and mobile_Phone like '%"+mobile+"%'";
		}
		if(qname2!=null && !"".equals(qname2)){ //姓名
			hql=hql+" and member_name like '%"+qname2+"%'";
		}
		if(invit!=null && !"".equals(invit)){  //邀请码
			hql=hql+" and invitationCode like '%"+invit+"%'";
		}
		if(create_date1!=null && !"".equals(create_date1)){  //注册时间1  开始时间
			hql=hql+" and createDate>='"+create_date1+"'";
		}
		if(create_date2!=null && !"".equals(create_date2)){  //注册时间2  结束时间
			hql=hql+" and createDate<='"+create_date2+"'";
		}
		
		return hql;
		
	}
	
	
	
	
	
	
	
	
	
	

}
