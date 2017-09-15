package com.item.finance.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.AwardRecord;

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
	
	//查询显示
	public List<AwardRecord> listshowawardRecord(Map map){
		Session session=getSession();
		String hql="from AwardRecord as awardr where 0=0";
		hql=list_Award(map, hql);
		List<AwardRecord>listawardRecords=session.createQuery(hql).list();
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
				hql+=" and  awardr.member.memberName like '%"+qmemberName+"%' ";
			}
			if(qmobile_Phone!=null && !qmobile_Phone.equals("")){  //手机号
				hql+=" and  awardr.member.mobile_Phone="+qmobile_Phone;
			}
			if(qinvitationCode!=null && !qinvitationCode.equals("")){ //邀请码
				hql+=" and  awardr.member.invitationCode="+qinvitationCode;
			}
			if(qinvitedCode!=null && !qinvitedCode.equals("")){  //被邀请码
				hql+=" and  awardr.member.invitedCode="+qinvitedCode;
			}
			//   奖励类型       是否注册奖励  是否投资奖励      
			if(qtype!=null && !qtype.equals("")){
				hql+=" and  awardr.type="+qtype;
			}
			//奖励状态    0  为奖励   1已奖励
			if(qisAward!=null && !qisAward.equals("")){
				hql+=" and awardr.isAward="+qisAward;
			}
		
			return hql;
		}
		
		//奖励记录  点击奖励记录通过查询得到的   id 返回信息
		public AwardRecord getAward(int id){
			Session session = getSession();
			String hql = "from AwardRecord as awardr where id="+id;
			List<AwardRecord> award = session.createQuery(hql).list();
			return award.get(0);  //返回信息
		}

}
