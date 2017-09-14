package com.item.finance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.AwardRecord;

@Component
public class Ss_AwardRecordDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//得到session
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	//得到 id
	public AwardRecord getId(int id){
		Session session=getSession();
	AwardRecord awardRecord=(AwardRecord)session.get(AwardRecord.class,id);
	return awardRecord;
	}
	
	//查询显示
	public List<AwardRecord> listshowawardRecord(){
		Session session=getSession();
		String hql="from AwardRecord as awardr";
		List<AwardRecord>listawardRecords=session.createQuery(hql).list();
		return  listawardRecords;
	}

}
