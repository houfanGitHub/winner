package com.item.finance.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.AbstractLongStringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.AwardRecord;
import com.item.finance.bean.Member;
import com.item.finance.bean.MemberAccount;

@Component
public class Ss_AwardRecordDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//得到session
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	//得到 id
	public AwardRecord getId(int id){
		Session session=getSession();
	AwardRecord awardRecord=(AwardRecord)session.get(AwardRecord.class,id);
	return awardRecord;
	}
	
	//得到 member的id
	public Member getmemberid(String id){
		Session session=getSession();
		Member member=(Member)session.get(Member.class, id);
		return member;
	}
	
	
	//查询显示
	public List<AwardRecord> listshowawardRecord(Map map){
		Session session=getSession();
		String hql="from AwardRecord as awa where 0=0";
		hql=list_Award(map, hql);
		List<AwardRecord>listawardRecords=session.createQuery(hql).list();
	//	for (AwardRecord awardRecord : listawardRecords) {
	//    	System.out.println();
		//}
		return  listawardRecords;
	}
	
	//模糊查询
		public String list_Award(Map map,String hql){
			String qmemberName = (String) map.get("qmemberName");  //姓名
			String qmobile_Phone = (String)map.get(" qmobile_Phone");  //手机号
			String qinvitationCode = (String) map.get("qinvitationCode");  //邀请码
			String qinvitedCode = (String) map.get("qinvitedCode");  //被邀请码
			String qtype=(String)map.get("qtype");//  奖励类型         是否注册奖励  是否投资奖励
			String qisAward= (String) map.get("qisAward");//奖励状态    0  为奖励   1已奖励
			
			
			if(qmemberName!=null && !qmemberName.equals("")){  //姓名
				hql+=" and awa.member.memberName like '%"+qmemberName+"%' ";
			}
			if(qmobile_Phone!=null && !qmobile_Phone.equals("")){  //手机号
				hql+=" and awa.member.mobile_Phone="+qmobile_Phone;
			}
			if(qinvitationCode!=null && !qinvitationCode.equals("")){ //邀请码
				hql+=" and awa.member.invitationCode="+qinvitationCode;
			}
			if(qinvitedCode!=null && !qinvitedCode.equals("")){  //被邀请码
				hql+=" and awa.member.invitedCode="+qinvitedCode;
			}
			//   奖励类型       是否注册奖励  是否投资奖励      
			if(qtype!=null && !qtype.equals("")){
				hql+=" and  type="+qtype;
			}
			//奖励状态    0  为奖励   1已奖励
			if(qisAward!=null && !qisAward.equals("")){
				hql+=" and isAward="+qisAward;
			}
		
			return hql;
		}
		
	/*	//奖励记录  点击奖励记录通过查询得到的   id 返回信息  
		public AwardRecord getAward(int id){
			Session session = getSession();
			String hql = "from AwardRecord where id="+id;
			List<AwardRecord> award = session.createQuery(hql).list();
			return award.get(0);  //返回信息
		}
		
		*/
	/*	//奖励记录  点击奖励记录通过查询得到的   id 返回信息    邀请人
		public List<AwardRecord> listinvitingid(int invitingid){
			String hql="from AwardRecord as awardr where awardr.member.id="+invitingid;
			Session session = getSession();
			List<AwardRecord> listaward = session.createQuery(hql).list();
			return listaward;
		}*/
		
	
		//邀请奖励id
		public List<AwardRecord> listawrecord(int id){
				Session session=getSession();
				String hql="from AwardRecord as ar where  ar.member.id="+id;
				List<AwardRecord> listaward=session.createQuery(hql).list();
				return listaward;
		}
		
		
		//投资金额查询
		public List<MemberAccount>listma(){
			Session session=getSession();
			String hql="from MemberAccount ";
			List<MemberAccount>listm=session.createQuery(hql).list();
			return listm;
		}
		
}
