package com.item.finance.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.MemberTradeRecord;

import aj.org.objectweb.asm.Handle;

@Component
public class Ss_MemberTradeRecordDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	//得到 id 
	public MemberTradeRecord getByID(String  id){
		Session session=getSession();
		MemberTradeRecord memberTradeRecord=(MemberTradeRecord)session.get(MemberTradeRecord.class, id);
		return memberTradeRecord;
	}
	
	//显示所有
	public List<MemberTradeRecord>listmembertrade(Map map){
		Session session=getSession();
		String hql="from MemberTradeRecord as membertrade where 0=0 ";
		hql=gethql(map, hql);
		List<MemberTradeRecord>listmembertra=session.createQuery(hql).list();
		return listmembertra;
	}
	
	//模糊查询
		public String gethql(Map map,String hql){
			
			String stat2=(String)map.get("stat2");   //交易记录
			String tradeStatus2=(String)map.get("tradeStatus2");//交易状态
			
			String date1=(String)map.get("date1");  //订单时间1  开始时间
			String date2=(String)map.get("date2"); //订单时间2  结束时间
			
			if(stat2!=null && !"".equals(stat2)){ //交易记录
				hql=hql+" and stat like '%"+stat2+"%'";
			}
			if(tradeStatus2!=null && !"".equals(tradeStatus2)){ //交易状态
				hql=hql+" and tradeStatus= '%"+tradeStatus2+"%'";
			}
			
			
			if(date1!=null && !"".equals(date1)){  //订单时间1 开始时间
				hql=hql+" and createDate>='"+date1+"'";
			}
			if(date2!=null && !"".equals(date2)){  //订单时间2  结束时间
				hql=hql+" and createDate<='"+date2+"'";
			}
			return hql;
		}

}
