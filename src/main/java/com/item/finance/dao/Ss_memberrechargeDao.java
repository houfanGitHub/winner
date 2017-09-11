package com.item.finance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.MemberDepositRecord;

@Component
public class Ss_memberrechargeDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	//得到 id
	public MemberDepositRecord getbyid(String id){
		Session session=getSession();
		MemberDepositRecord memberDepositRecord=(MemberDepositRecord)session.get(MemberDepositRecord.class, id);
		return memberDepositRecord;
	}
	
	//显示
	public List<MemberDepositRecord>listshowdeposit(){
		Session session=getSession();
		String hql="from MemberDepositRecord";
		List<MemberDepositRecord>listdeposit=session.createQuery(hql).list();
		return listdeposit;
	}

}
