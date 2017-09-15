package com.item.finance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.MemberAccount;


@Component
public class Ss_member_accountDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public  Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	//显示
	public List<MemberAccount>listMemberAccount(){
		Session session=getSession();
		String hql="from MemberAccount as memberacc ";
		List<MemberAccount>listmemberAccounts=session.createQuery(hql).list();
		return listmemberAccounts;
	}
	
	//得到 id
	public  MemberAccount getByID(String id){
		Session session=getSession();
		MemberAccount memberAccount=(MemberAccount)session.get(MemberAccount.class, id);
		return memberAccount;
	}
	
	//查询账户详情
	public  MemberAccount getmemberaccount(String id){
		Session session = getSession();
		String hql = "from MemberAccount as memberAccount  where memberAccount.member.id="+id;
		List<MemberAccount> listmembercount = session.createQuery(hql).list();
		return listmembercount.get(0);
	}

}
