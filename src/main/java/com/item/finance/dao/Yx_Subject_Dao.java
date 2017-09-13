package com.item.finance.dao;

import java.util.List;
import java.util.Map;

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
	public List<Subject> listSubject(Map map){
		Session session=getSession();
		String hql="from Subject where 0=0 ";
		hql=datehql(map, hql);
		List<Subject> list=session.createQuery(hql).list();
		return list;
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
    public void deleteSubject(Subject subject){
    	Session session=getSession();
    	session.delete(subject);
    }
    public void updateSubject(Subject subject){
    	Session session=getSession();
    	session.update(subject);
    }
}
