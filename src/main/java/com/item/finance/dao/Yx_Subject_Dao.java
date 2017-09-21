package com.item.finance.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.FinanceProductFunds;
import com.item.finance.bean.Subject;
import com.item.finance.bean.SubjectBbinPurchaseRecord;
import com.item.finance.bean.SubjectFile;

@Component
public class Yx_Subject_Dao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	//保存
	public void saveSubject(Subject subject){
		Session session=getSession();
		session.save(subject);
	}
	//上传
	public void saveSubjectFile(SubjectFile subjectFile){
		Session session=getSession();
		session.save(subjectFile);
	}
	//根据id查询对象
	public Subject selectSubject(int id){
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
	//查看投资
	public List<SubjectBbinPurchaseRecord> listtouzi(int id){
		Session session=getSession();
		String hql="from SubjectBbinPurchaseRecord where subject_id="+id;
		List<SubjectBbinPurchaseRecord> list=session.createQuery(hql).list();
		return list;
	}
	
    public void deleteSubject(Subject subject){
    	Session session=getSession();
    	session.delete(subject);
    }
    //修改
    public void updateSubject(Subject subject){
    	Session session=getSession();
    	session.update(subject);
    }
    //修改上传
    public void updateSubject(SubjectFile subjectFile){
    	Session session=getSession();
    	session.update(subjectFile);
    }
}
