package com.item.finance.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.MemberWithdrawRecord;

@Component
public class MemberWithdrawRecordDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(MemberWithdrawRecord t) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
	}

	public MemberWithdrawRecord selectGetByRandomPayNumber(
			String randomPayNumber) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from MemberWithdrawRecord where serial_number = "+randomPayNumber;
		MemberWithdrawRecord memberWithdrawRecord = (MemberWithdrawRecord) session.createQuery(hql).list().get(0);
		return memberWithdrawRecord;
	}

	public void update(MemberWithdrawRecord t) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
	}

}
