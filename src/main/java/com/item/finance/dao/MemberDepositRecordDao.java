package com.item.finance.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.MemberDepositRecord;

@Component
public class MemberDepositRecordDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void save(MemberDepositRecord memberDepositRecord) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(memberDepositRecord);
	}

}
