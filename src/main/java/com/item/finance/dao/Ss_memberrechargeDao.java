package com.item.finance.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.Member;
import com.item.finance.bean.MemberBankcard;
import com.item.finance.bean.MemberDepositRecord;
import com.item.finance.bean.SubjectBbinPurchaseRecord;

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
	public List<MemberDepositRecord> getmemberdeposit(String id){
		Session session=getSession();
		//MemberDepositRecord 表中有一member_id 是与member中的id  相对应的  可通过member中的id 取到相应的值
		String hql="from MemberDepositRecord as memberdeposit where memberdeposit.member.id= "+id;
				List<MemberDepositRecord>listmemberdeposit=session.createQuery(hql).list();
				return listmemberdeposit;
	}
	
	public Member getmemberid(String id){
		Session session=getSession();
		Member member=(Member)session.get(Member.class, id);
		return member;
	}
	
	//显示
	public List<MemberDepositRecord>listshowdeposit(Map map){
		Session session=getSession();
		String hql = "from MemberDepositRecord  as mem where mem.payChannelName='FUIOU' and 0=0 ";
		hql=gethql(map, hql);
		List<MemberDepositRecord>listdeposit=session.createQuery(hql).list();
		return listdeposit;
	}
	
	//模糊查询
	public String gethql(Map map,String hql){
		
		String serialNumber2=(String)map.get("serialNumber2");   //订单编号
		String mobile2=(String)map.get("mobile2");//手机号
		String status2=(String)map.get("status2");//订单状态 (0:待付款;1:完成)
		String payChannelName2=(String)map.get("payChannelName2");//富友订单
		String date1=(String)map.get("date1");  //订单时间1  开始时间
		String date2=(String)map.get("date2"); //订单时间2  结束时间
		
		if(serialNumber2!=null && !"".equals(serialNumber2)){ //订单编号
			hql=hql+" and serialNumber like '%"+serialNumber2+"%'";
		}
		if(mobile2!=null && !"".equals(mobile2)){ //手机号
			hql=hql+" and mem.member.mobile_Phone like '%"+mobile2+"%'";
		}
		if(status2!=null && !"".equals(status2)){ //订单状态
			hql=hql+" and status= "+status2;
		}
		if(payChannelName2!=null && !"".equals(payChannelName2)){ //富友订单
			hql=hql+" and payChannelName="+payChannelName2;
		}
		
		if(date1!=null && !"".equals(date1)){  //订单时间1 开始时间
			hql=hql+" and createDate>='"+date1+"'";
		}
		if(date2!=null && !"".equals(date2)){  //订单时间2  结束时间
			hql=hql+" and createDate<='"+date2+"'";
		}
		return hql;
	}
	/*
	//更新订单处理
	public void updatememberdeposit(String  id){
		Session session=getSession();
		MemberDepositRecord memberDepositRecord=(MemberDepositRecord)session.get(MemberDepositRecord.class, id);
		memberDepositRecord.setStatus((byte) 1);    //订单状态    强转byte型  0 充值失败   2.充值成功
		session.update(memberDepositRecord);
	} */
	//更新操作
	public void updatestatus(MemberDepositRecord memberDepositRecord){
		Session session=getSession();
		Date date=new Date();
		memberDepositRecord.setUpdateDate(date);
		session.update(memberDepositRecord);
	}
}
