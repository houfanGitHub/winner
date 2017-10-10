package com.item.finance.dao;

import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.MemberWithdrawRecord;

@Component
public class Ss_MemberWithdrawRecordDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//得到 session
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	//得到 id
	public MemberWithdrawRecord getID(String id){
		Session session=getSession();
		MemberWithdrawRecord memberWithdrawRecord=(MemberWithdrawRecord)session.get(MemberWithdrawRecord.class, id);
		return memberWithdrawRecord;
	}
	
	//显示
	public List<MemberWithdrawRecord> listshow(Map map){
		Session session=getSession();
		String hql="from  MemberWithdrawRecord as memberwith  where 0=0";
		hql=gethql(map, hql);
		List<MemberWithdrawRecord>listshow=session.createQuery(hql).list();
		return listshow;
	}
	
	//模糊查询
		public String gethql(Map map,String hql){
			
			String aname =(String)map.get("aname");   //姓名
			String aphone =(String)map.get("aphone");//手机号
			String anumber=(String)map.get("anumber");//绑卡卡号
			String astatu=(String)map.get("astatu");//状态
			String adate1=(String)map.get("adate1");  //提现时间
			String adate2=(String)map.get("adate2");  //提现时间
			
			if(aname!=null && !"".equals(aname)){ //姓名
				hql=hql+" and  memberwith .member.memberName like '%"+aname+"%'";
			}
			if(aphone!=null && !"".equals(aphone)){ //手机号
				hql=hql+" and memberwith .member.mobile_Phone like '%"+aphone+"%'";
			}
			
			if(anumber!=null && !"".equals(anumber)){ //绑卡卡号
				hql=hql+" and bankCard="+anumber;
			}
			
			if(astatu!=null && !"".equals(astatu)){ //订单状态
				hql=hql+" and status= "+astatu;
			}
			
			if(adate1!=null && !"".equals(adate1)){  //提现时间1  开始时间
				hql=hql+" and createDate>='"+adate1+"'";
			}
			if(adate2!=null && !"".equals(adate2)){  //体现时间2  结束时间
				hql=hql+" and createDate<='"+adate2+"'";
			}
		
			return hql;
		}
	
		//模态窗口 审核操作
		public  void updateShenhe(String id){
			Session session=getSession();
			MemberWithdrawRecord memberwithd=(MemberWithdrawRecord)session.get(MemberWithdrawRecord.class, id);
			memberwithd.setStatus((byte) 2);  //根据提现状态  审核     变成打款中状态
			session.update(memberwithd);
			
		}
		
		

}
