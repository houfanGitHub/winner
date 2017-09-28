package com.item.finance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.FinancialPlanner;
import com.item.finance.bean.Member;
import com.item.finance.bean.MemberAccount;
import com.item.finance.bean.MemberDepositRecord;
import com.item.finance.bean.MemberTradeRecord;
import com.item.finance.bean.MemberWithdrawRecord;
import com.item.finance.bean.SubjectPurchaseRecord;


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
	
	//得到 id
	public Member getId(String id){
		Session session=getSession();
		Member member=(Member)session.get(Member.class, id);
		return member;
	}
	
	  //查询资金信息详情  通过id  传参  返回对应的数据     按下标取值 
			public  MemberAccount getmemberaccount(String id){
				Session session = getSession();
			//MemberAccount 表中有一member_id 是与member中的id  相对应的  可通过member中的id 取到相应的值
				String hql = "from MemberAccount as memberAccount  where memberAccount.member.id="+id;
				List<MemberAccount> listmembercount = session.createQuery(hql).list();
				return listmembercount.get(0);
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
			public List<SubjectPurchaseRecord> listSubjectpur(String id){
				Session session = getSession();
				//SubjectPurchaseRecord 表中有一member_id 是与member中的id  相对应的  可通过member中的id 取到相应的值
				String hql = "from SubjectPurchaseRecord as subjectp where subjectp.member.id="+id;
				List<SubjectPurchaseRecord> listsubjectp = session.createQuery(hql).list();
				
				return listsubjectp;
			}
			
			//查询提现记录   传参  返回集合中对应的数据   
			public  List<MemberWithdrawRecord> getmemberwithdraw(String id){
				Session session=getSession();
				//MemberWithdrawRecord 表中有一member_id 是与member中的id  相对应的  可通过member中的id 取到相应的值
				String hql="from MemberWithdrawRecord as memberwith where memberwith.member.id= "+id;
				List<MemberWithdrawRecord>listmemberwith=session.createQuery(hql).list();
				return listmemberwith;
			}
			
			
			//查询充值记录   传参  返回集合中对应的数据   
			public List<MemberDepositRecord> getmemberdeposit(String id){
				Session session=getSession();
				//MemberDepositRecord 表中有一member_id 是与member中的id  相对应的  可通过member中的id 取到相应的值
				String hql="from MemberDepositRecord as memberdeposit where memberdeposit.member.id= "+id;
						List<MemberDepositRecord>listmemberdeposit=session.createQuery(hql).list();
						return listmemberdeposit;
			}
			
			//查询交易记录   传参  返回集合中对应的数据   按下标取值 
					public List<MemberTradeRecord> getmemberTrade(String id){
						Session session=getSession();
						//MemberTradeRecord 表中有一member_id 是与member中的id  相对应的  可通过member中的id 取到相应的值
						String hql="from MemberTradeRecord as memberTrad where memberTrad.member.id= "+id;
								List<MemberTradeRecord>listmemberTrad=session.createQuery(hql).list();
								return listmemberTrad;
					}
		
			

}
