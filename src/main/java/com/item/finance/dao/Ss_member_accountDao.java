package com.item.finance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.FinancialPlanner;
import com.item.finance.bean.Member;
import com.item.finance.bean.MemberAccount;
import com.item.finance.bean.MemberWithdrawRecord;


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
	
	
	//查询资金信息详情  通过id  传参  返回对应的数据     按下标取值 
			public Member getmember(String id){
				Session session = getSession();
			//MemberAccount 表中有一member_id 是与member中的id  相对应的  可通过member中的id 取到相应的值
				String hql = "from Member as mem  where mem.memberAccounts.id="+id;
				List<Member> listmem = session.createQuery(hql).list();
				return listmem.get(0);
			}
			
			//理财师详情 通过id  传参  返回对应的数据     按下标取值 
			public FinancialPlanner getFinancialplanner(String id){
				Session session = getSession();
				//FinancialPlanner 表中有一member_id 是与member中的id  相对应的  可通过member中的id 取到相应的值
				String hql = "from FinancialPlanner as finan where finan.member.id="+id;
				List<FinancialPlanner> listFinancialplanner = session.createQuery(hql).list();
				return listFinancialplanner.get(0);
			}
			
			//查询投资记录   传参  返回集合中对应的数据     
			
			//查询提现记录   传参  返回集合中对应的数据   
			public  List<MemberWithdrawRecord> getmemberwithdraw(String id){
				Session session=getSession();
				//MemberWithdrawRecord 表中有一member_id 是与member中的id  相对应的  可通过member中的id 取到相应的值
				String hql="from MemberWithdrawRecord as memberwith where memberwith.member.id= "+id;
				List<MemberWithdrawRecord>listmemberwith=session.createQuery(hql).list();
				return listmemberwith;
			}
			

}
