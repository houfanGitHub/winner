package com.item.finance.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.MemberBankcard;

@Component
public class MemberBankcardDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void save(MemberBankcard memberBankcard) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(memberBankcard);
	}

	public MemberBankcard selectGetByMemberId(String id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from MemberBankcard where member_id = "+id;
		MemberBankcard memberBankcard = (MemberBankcard) session.createQuery(hql).list().get(0);
		return memberBankcard;
	}

}
