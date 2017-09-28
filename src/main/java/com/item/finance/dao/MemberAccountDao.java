package com.item.finance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.MemberAccount;

@Component
public class MemberAccountDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public MemberAccount selectGetByMemberId(String id) {
		// TODO Auto-generated method stub
		MemberAccount memberAccount = null;
		Session session = sessionFactory.getCurrentSession();
		String hql = "from MemberAccount where member_id = '"+id+"'";
		List<MemberAccount> list = session.createQuery(hql).list();
		if(list.size()!=0){
			memberAccount = list.get(0);
		}
		return memberAccount;
	}

	public void update(MemberAccount memberAccount) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(memberAccount);
	}

	public void save(MemberAccount memberAccount) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(memberAccount);
	}

}
