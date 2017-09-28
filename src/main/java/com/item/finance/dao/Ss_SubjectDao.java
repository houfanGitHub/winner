package com.item.finance.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.Ss_Sumsubject;
import com.item.finance.bean.Subject;
import com.item.finance.bean.SubjectBbinPurchaseRecord;
import com.item.finance.bean.SubjectPurchaseRecord;

@Component
public class Ss_SubjectDao {
	
	@Autowired
	private  SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	//得到 id
	public Subject getById(String id){
		Session session=getSession();
		Subject subject=(Subject)session.get(Subject.class,id);
		return subject;
	}
	
	//显示
	public List<Subject>listsub(Map map){
		Session session=getSession();
		String hql="from Subject where 0=0 ";
		hql=gethql(map, hql);
		List<Subject>listsubject=session.createQuery(hql).list();
		return listsubject;
	}
	
	//模糊查询
	public String gethql(Map map,String hql){
		
		String sname=(String)map.get("sname");   //名称
	
		String sstatus=(String)map.get("sstatus");//状态 
		String stype=(String)map.get("stype");//类型
		
		
		if(sname!=null && !"".equals(sname)){ //名称
			hql=hql+" and name= '"+sname+"'";
		}
		if(sstatus!=null && !"".equals(sstatus)){ //状态
			hql=hql+" and status= "+sstatus;
		}
		if(stype!=null && !"".equals(stype)){ //类型
			hql=hql+" and type= "+stype;
		}
		
		return hql;
	}
	
	
	//体验金付息列表        传参  返回集合中对应的数据       通过id 找到相关信息
	public  List<SubjectBbinPurchaseRecord>listsubjectbbin(int id){
		Session session=getSession();
		//SubjectBbinPurchaseRecord 表中有一subject_id 是与subject中的id  相对应的  可通过subject中的id 取到相应的值
		String hql="from SubjectBbinPurchaseRecord as subjectbbinp where subjectbbinp.subject.id="+id;
		List<SubjectBbinPurchaseRecord>listsubjectbb=session.createQuery(hql).list();
		return listsubjectbb;
	}
	
	//体验金列表  还款功能
	public void updatesubjectbbinp(int id){
		Session session=getSession();
		SubjectBbinPurchaseRecord subjectbbin=(SubjectBbinPurchaseRecord)session.get(SubjectBbinPurchaseRecord.class, id);
		subjectbbin.setIspayment((byte) 1);    //是否还款    强转byte型
		session.update(subjectbbin);
	}
	
	//付息列表显示
	public List<SubjectPurchaseRecord> listSubjectpr(String  id){
		Session session = getSession();
		//SubjectPurchaseRecord 表中有一subject_id 是与subject中的id  相对应的  可通过subject中的id 取到相应的值
		//String hql = "from SubjectPurchaseRecord as subjectp where subjectp.subject.id="+id;
		String sql = "select * from subject_purchase_record where subject_id = "+id;
		List<SubjectPurchaseRecord> listsubjectp = session.createSQLQuery(sql).addEntity(SubjectPurchaseRecord.class).list();
		//List<SubjectPurchaseRecord> listsubjectp=session.createQuery(hql).list();
		return listsubjectp;
	}
	
	//付息列表显示 中的 还款功能
	public void updatesubjectp(String  id){
		Session session=getSession();
		SubjectPurchaseRecord subjectpp=(SubjectPurchaseRecord)session.get(SubjectPurchaseRecord.class, id);
		subjectpp.setIspayment((byte) 1);  //是否还款
		Date date=new Date();
		subjectpp.setUpdateDate(date);  //修改时间
		session.update(subjectpp);
		
	}
	//已投金额       sql语句查询    需要创建实体类   
	public List<Ss_Sumsubject>listsumsubject(){
		Session session=getSession();
		//金额 * 次数              先在SubjectPurchaseRecord标的购买表中  查询 总金额   总次数       然后  金额* 次数         表 字段 必须是数据库中的表 字段                                                                                                                                                                                          
		String sql="select s.subject_id,s.sumamount*s.sumpaytimes  from (select spr.subject_id,SUM(spr.amount)as sumamount,SUM(spr.pay_interest_times)as sumpaytimes from subject_purchase_record spr GROUP BY spr.subject_id asc) as s left JOIN subject as sub ON s.subject_id=sub.id;";
		List list=session.createSQLQuery(sql).list();//list不指定泛型   list为object类型
		List<Ss_Sumsubject>sumsubject=new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Object[] obj=(Object[])list.get(i);//将list 变成obj数组
			Ss_Sumsubject ss=new Ss_Sumsubject();//实例化Ss_Sumsubject对象
			ss.setSubject_id(obj[0].toString());
			ss.setSumamount(obj[1].toString());//把object数组中的数据转换为Ss_Sumsubject对象   下表更具上面sql语句来判断 第一个为0  第二个为1,第三个为2
			//ss.setSumpaytimes(obj[2].toString());
			sumsubject.add(ss);//将转换后的数据添加进Ss_Sumsubject集合中去
		}
		return sumsubject;
	}
}
