package com.item.finance.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.item.finance.bean.Member;
import com.item.finance.bean.MemberAccount;
import com.item.finance.bean.MemberBankcard;
import com.item.finance.bean.MemberProfitRecord;
import com.item.finance.bean.MemberTally;
import com.item.finance.bean.MemberTradeRecord;
import com.item.finance.bean.Subject;
import com.item.finance.bean.SubjectPurchaseRecord;
@Component
public class FrontDao {
		
	
	@Resource
	private SessionFactory sf;
	
	public Session getSession(){
		return this.sf.getCurrentSession();
	}
	
	public List<MemberBankcard> listbankcards(){
		String hql="from MemberBankcard";
		Session session=getSession();
		List<MemberBankcard> memberbankcards=session.createQuery(hql).list();
		return memberbankcards;
	}
	
	public void savebankcards(MemberBankcard MemberBankcard){
		Session session=getSession();
		session.save(MemberBankcard);
	}
	
	public MemberBankcard getBankcardsById(String member_id){
		Session session=getSession();
		String hql="from MemberBankcard where member_id="+member_id;
		List<MemberBankcard> list=session.createQuery(hql).list();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
		
	public List<Member> listMember(){
		String hql="from Member where 0=0";
		Session session=getSession();
		List<Member> listmember=session.createQuery(hql).list();
		return listmember;
	}
	
	public Member getMemberById(int member_id){
		Session session=getSession();
		Member member=(Member)session.get(Member.class,member_id);
		return member;
	}
	
	public MemberAccount memberAccount(String member_id){
		Session session=getSession();
		String hql="from MemberAccount where member_id="+member_id;
		List<MemberAccount> listaccount=session.createQuery(hql).list();
		if(listaccount.size()>0){
			return listaccount.get(0);
		}
		return null;
	}
	
	public Subject getSubjectById(int subject_id){
		Session session=getSession();
		Subject subject=(Subject)session.get(Subject.class, subject_id);
		return subject;
	}
	
	public void updatesubject(Subject subject){
		Session session=getSession();
		session.update(subject);
	}
	
	public void updateaccount(MemberAccount MemberAccount){
		Session session=getSession();
		session.update(MemberAccount);
	}
	
	public void savetraderecord(MemberTradeRecord member_trade_record){
		Session session=getSession();
		session.save(member_trade_record);
	}
	
	public void saveprofit(MemberProfitRecord member_profit_record){
		Session session=getSession();
		session.save(member_profit_record);
	}
	
	public void savetally(MemberTally member_tally){
		Session session=getSession();
		session.save(member_tally);
	}
	
	public void savepurchaserecord(SubjectPurchaseRecord subject_purchase_record){
		Session session=getSession();
		session.save(subject_purchase_record);
	}
	
	public List<SubjectPurchaseRecord> listpurchase(int subject_id){
		Session session=getSession();
		String hql="from SubjectPurchaseRecord where subject_id="+subject_id;
		List<SubjectPurchaseRecord> list=session.createQuery(hql).list();
		if(list.size()>0){
			SubjectPurchaseRecord a=list.get(0); 
		}
			return null;
	}
	
	public List<SubjectPurchaseRecord> listallpurchase(){
		String hql="from SubjectPurchaseRecord where 0=0";
		Session session=getSession();
		List<SubjectPurchaseRecord> listpurchase=session.createQuery(hql).list();
		return listpurchase;
	}
}
