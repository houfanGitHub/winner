package com.item.finance.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.BbinInfo;
import com.item.finance.bean.FinancialPlanner;
import com.item.finance.bean.Member;
import com.item.finance.bean.MemberAccount;
import com.item.finance.bean.MemberDepositRecord;
import com.item.finance.bean.MemberProfitRecord;
import com.item.finance.bean.MemberTradeRecord;
import com.item.finance.bean.MemberWithdrawRecord;
import com.item.finance.bean.Ss_Sumsubject;
import com.item.finance.bean.Ss_suminvest;
import com.item.finance.bean.Ss_sumorder;
import com.item.finance.bean.Subject;
import com.item.finance.bean.SubjectBbinPurchaseRecord;
import com.item.finance.bean.SubjectOrderRecord;
import com.item.finance.bean.SubjectPurchaseRecord;


@Component
public class Ss_zhManangerDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	//账号管理列表显示
	public List<Member>listzh(Map map){
		Session session=getSession();
		String hql="from Member where 0=0";
		hql=gethql(map, hql);
		List<Member>list=session.createQuery(hql).list();
		return list;
	}
	
	//得到 id
	public Member getId(String id){
		Session session=getSession();
		Member member=(Member)session.get(Member.class, id);
		return member;
	}
	
	//模糊查询
	public String gethql(Map map ,String hql){
		String qname1=(String)map.get("qname1");//用户名
		String mobile=(String)map.get("mobile");//手机号
		String qname2=(String)map.get("qname2");//姓名
		String invit=(String)map.get("invit");//邀请码
		String create_date1=(String)map.get("create_date1");//注册时间1
		String create_date2=(String)map.get("create_date2");//注册时间2
		if(qname1!=null && !"".equals(qname1)){  //用户名
			hql=hql+" and name like '%"+qname1+"%'";
		}
		if(mobile!=null && !"".equals(mobile)){ //手机号
			hql=hql+" and mobile_Phone like '%"+mobile+"%'";
		}
		if(qname2!=null && !"".equals(qname2)){ //姓名
			hql=hql+" and member_name like '%"+qname2+"%'";
		}
		if(invit!=null && !"".equals(invit)){  //邀请码
			hql=hql+" and invitationCode like '%"+invit+"%'";
		}
		if(create_date1!=null && !"".equals(create_date1)){  //注册时间1  开始时间
			hql=hql+" and createDate>='"+create_date1+"'";
		}
		if(create_date2!=null && !"".equals(create_date2)){  //注册时间2  结束时间
			hql=hql+" and createDate<='"+create_date2+"'";
		}
		return hql;
	}
	/*
	//查询体验金
	public List<BbinInfo>listbbin(){
		Session session=getSession();
		String hql="from BbinInfo ";
		List<BbinInfo>listbbinin=session.createQuery(hql).list();
		return listbbinin;
	}*/
	
	/*    //查询资金信息详情  通过id  传参  返回对应的数据     按下标取值 
		public  MemberAccount getmemberaccount(String id){
			Session session = getSession();
		//MemberAccount 表中有一member_id 是与member中的id  相对应的  可通过member中的id 取到相应的值
			String hql = "from MemberAccount as memberAccount  where memberAccount.member.id="+id;
			List<MemberAccount> listmembercount = session.createQuery(hql).list();
			return listmembercount.get(0);
		}*/
	public  List<MemberAccount> getmemberaccount(String id){
		Session session = getSession();
	//MemberAccount 表中有一member_id 是与member中的id  相对应的  可通过member中的id 取到相应的值
		String hql = "from MemberAccount as memberAccount  where memberAccount.member.id="+id;
		List<MemberAccount> listmembercount = session.createQuery(hql).list();
		return listmembercount;
		}
	

		
	/*	//理财师详情 通过id  传参  返回对应的数据     按下标取值 
		public FinancialPlanner getFinancialplanner(String id){
			Session session = getSession();
			//FinancialPlanner 表中有一member_id 是与member中的id  相对应的  可通过member中的id 取到相应的值
			String hql = "from FinancialPlanner as finan where finan.member.id="+id;
			List<FinancialPlanner> listFinancialplanner = session.createQuery(hql).list();
			return listFinancialplanner.get(0);
		}*/
	//理财师详情 通过id
		public List<FinancialPlanner> getFinancialplanner(String id){
			Session session = getSession();
			//FinancialPlanner 表中有一member_id 是与member中的id  相对应的  可通过member中的id 取到相应的值
			String hql = "from FinancialPlanner as finan where finan.member.id="+id;
			List<FinancialPlanner> listFinancialplanner = session.createQuery(hql).list();
			return listFinancialplanner;
		}
		
		//查询投资记录   传参  返回集合中对应的数据      (后台 前台数据)
		public List<SubjectPurchaseRecord> listSubjectpur(String id){
			Session session = getSession();
			//SubjectPurchaseRecord 表中有一member_id 是与member中的id  相对应的  可通过member中的id 取到相应的值
			String hql = "from SubjectPurchaseRecord  subjectp where subjectp.member.id="+id;
			List<SubjectPurchaseRecord> listsubjectp = session.createQuery(hql).list();
			
			return listsubjectp;
		}
		
		
		//查询提现记录   传参  返回集合中对应的数据    （后台 前台）
		public  List<MemberWithdrawRecord> getmemberwithdraw(String id){
			Session session=getSession();
			//MemberWithdrawRecord 表中有一member_id 是与member中的id  相对应的  可通过member中的id 取到相应的值
			String hql="from MemberWithdrawRecord as memberwith where memberwith.member.id= "+id;
			List<MemberWithdrawRecord>listmemberwith=session.createQuery(hql).list();
			for (MemberWithdrawRecord memb : listmemberwith) {
				System.out.println("订单："+memb.getSerialNumber()+",金额："+memb.getAmount());
				
			}
			return listmemberwith;
		}
		

		
		//查询充值记录   传参  返回集合中对应的数据   (后台  前台)
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

		//前台个人 查询收益记录    成员利润表
	public List<MemberProfitRecord> getmemberprofit(String id){
		Session session=getSession();
		String hql="from MemberProfitRecord memberprofit where memberprofit.member.id="+id;
		List<MemberProfitRecord> listmemberprofit = session.createQuery(hql).list();
		for (MemberProfitRecord memberProfitRecord : listmemberprofit) {
			System.out.println("订单："+memberProfitRecord.getSerialNumber()+"，金额："+memberProfitRecord.getAmount());
			
		}
		return listmemberprofit;
	}	
	//投资几笔记录
	public Ss_suminvest listinvest(String id){
		Session session=getSession();
		                                                                                       
		String sql="select  count(serial_number) from subject_purchase_record where member_id="+id;
		String str = (String.valueOf(session.createSQLQuery(sql).list().get(0))) ;//取出来  得到值 

			Ss_suminvest ss=new Ss_suminvest();//实例化Ss_Suminvests对象
			ss.setSuminvest(str);

		return ss;
	}
	
	//前台个人预约（订单）记录     标的订单表
		public List<SubjectOrderRecord> getsubjectorder(String id){
			Session session=getSession();
			String hql="from SubjectOrderRecord subjectorder where subjectorder.member.id="+id;
			List<SubjectOrderRecord> listsubjectorder = session.createQuery(hql).list();
			for (SubjectOrderRecord subjec : listsubjectorder) {
				System.out.println("订单金额："+subjec.getAmount());
				
			}
			return listsubjectorder;
		}	
		
		//预约记录  几笔记录
		public  Ss_sumorder listsubjectorder(String id){
			Session session=getSession();
			String sql="select  count(serial_number) from subject_order_record where member_id="+id;
			String str = (String.valueOf(session.createSQLQuery(sql).list().get(0))) ;//取出来  得到值 

			Ss_sumorder ssor=new Ss_sumorder();//实例化Ss_Suminvests对象
			ssor.setSumorder(str);

		return ssor;
	}
		

	/*
	//SubjectBbinPurchaseRecord  //体验金购买标 的表
	public List<SubjectBbinPurchaseRecord>listsubjectbb(String id){
		Session session=getSession();
		String hql="from SubjectBbinPurchaseRecord sbp where sbp.member.id="+id;
		List<SubjectBbinPurchaseRecord> listsbp = session.createQuery(hql).list();
		for (SubjectBbinPurchaseRecord subp : listsbp) {
			System.out.println("还款状态："+subp.getIspayment());
		}
		return listsbp;
	}
	*/
	public SubjectBbinPurchaseRecord getsubjectbinre(String id){
		Session session = getSession();
		//SubjectBbinPurchaseRecord 表中有一member_id 是与member中的id  相对应的  可通过member中的id 取到相应的值
		String hql="from SubjectBbinPurchaseRecord sbp where sbp.member.id="+id;
		List<SubjectBbinPurchaseRecord> listgetjectbb = session.createQuery(hql).list();
		if (listgetjectbb.size()>0) {
			return listgetjectbb.get(0);
			
		}
		return null;
	}
	
	//体验金记录信息
	public BbinInfo getbb(String id){
		Session session = getSession();
		//bbininfo 表中有一member_id 是与member中的id  相对应的  可通过member中的id 取到相应的值
		String hql = "from BbinInfo as bb where bb.member.id="+id;
		List<BbinInfo> listbb = session.createQuery(hql).list();
		if (listbb.size()>0) {
			return listbb.get(0);
		}
		return null;
	}
	
	}
	
	
	
	
	
	
	
	
	
	
	


