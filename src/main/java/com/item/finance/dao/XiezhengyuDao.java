package com.item.finance.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.finance.bean.Feedback;
import com.item.finance.bean.Member;
import com.item.finance.bean.News;
import com.item.finance.bean.NewsType;
import com.item.finance.bean.PushNotice;
import com.item.finance.bean.SubjectFile;

@Component
public class XiezhengyuDao {
@Autowired
private SessionFactory sessionFactory;
public Session getsesstion(){
	return sessionFactory.getCurrentSession();
}
/*-------------------------------------------------------------------------news----------------------------------------------------*/
//增
public void saveNews(News n){
Session session = getsesstion();
session.save(n);
}
//删
public void deleteNews(News n,int id){
Session session = getsesstion();
n = getNews(id);
n.setNewsType(null);
session.delete(n);
} 
//改
public void updateNews(News n){
Session session = getsesstion();
session.update(n);
} 
//查
public List<News> listNews(Map map){
String hql = "from  News as n where   0=0 ";
hql=getNewsHql(map, hql);
System.out.println(hql);
Session session = getsesstion();
List<News> list = session.createQuery(hql).list();
return list;
}
public String getNewsHql(Map map,String hql){
String  stitle=(String) map.get("stitle");
String  stname= (String) map.get("stname");
if(stitle!=null && !stitle.equals("")){
hql+=" and n.title like '%"+stitle+"%'";
}
if(stname != null && !stname.equals("")){
hql+=" and n.newsType.name like  '%"+stname+"%'";
}
return hql;
}
//news
public News getNews(int id){
Session session = sessionFactory.getCurrentSession();
News n = (News) session.get(News.class, id);
return n;
}
/*-------------------------------------------------------------------------newsType----------------------------------------------------*/
//增
public void saveNewsType(NewsType nt){
Session session = sessionFactory.getCurrentSession();
session.save(nt);
}
//删
public void deleteNewsType(NewsType nt){
Session session = sessionFactory.getCurrentSession();
session.delete(nt);
}
//改
public void updateNewsType(NewsType nt){
Session session = sessionFactory.getCurrentSession();
session.update(nt);
}
//查
public List<NewsType> listNewsType(Map map){
String hql = "from NewsType where 0=0";
hql= getNewsTypeHql(map, hql);
 System.out.println(hql);
Session session = sessionFactory.getCurrentSession();
List<NewsType> list= session.createQuery(hql).list();
return list;
}
//获得news
public String getNewsTypeHql(Map map,String hql){
Session session = sessionFactory.getCurrentSession();
String tname = (String) map.get("tname");
if(tname!=null && !tname.equals("")){
hql+= " and name like '%"+tname+"%'";
}
return hql;
}
//newstype
public NewsType getNewsType(int id){
Session session = sessionFactory.getCurrentSession();
NewsType nt = (NewsType) session.get(NewsType.class, id);
return nt;
}
/*-------------------------------------------------------------------------Push_----------------------------------------------------*/
//增
public void savePushNotice(PushNotice p){
Session session = sessionFactory.getCurrentSession();
session.save(p);
}
//删
public void deletePushNotice(PushNotice nt){
Session session = sessionFactory.getCurrentSession();
session.delete(nt);
}
//改
public void updatePushNotice(PushNotice nt){
Session session = sessionFactory.getCurrentSession();
session.update(nt);
}
//查
public List<PushNotice> listPushNotice(Map map){
String hql = "from PushNotice where status = 0  and  0=0";
hql= getPushNoticeHql(map, hql);
Session session = sessionFactory.getCurrentSession();
List<PushNotice> list= session.createQuery(hql).list();
return list;
}
//查
public List<PushNotice> listPushNoticeed(Map map){
String hql = "from PushNotice where status = 1 and  0=0 ";
hql= getPushNoticeHql(map, hql);
Session session = sessionFactory.getCurrentSession();
List<PushNotice> list= session.createQuery(hql).list();
return list;
}
//获得PushNotice
public String getPushNoticeHql(Map map,String hql){
Session session = sessionFactory.getCurrentSession();
String tname = (String) map.get("tname");
if(tname!=null && !tname.equals("")){
hql+= " and title like '%"+tname+"%'";
}
return hql;
}
//PushNotice
public PushNotice getPushNotice(String id){
Session session = sessionFactory.getCurrentSession();
PushNotice p = (PushNotice) session.get(PushNotice.class,id);
return p;
}
/*-------------------------------------------------------------------------feedback----------------------------------------------------*/
//查
public List<Feedback> listFeedback(Map map){
String hql = "from Feedback as f  where  0=0 ";
hql= getFeedbackHql(map, hql);
Session session = sessionFactory.getCurrentSession();
List<Feedback> list= session.createQuery(hql).list();
return list;
}
//模糊
public String getFeedbackHql(Map map,String hql){
Session session = sessionFactory.getCurrentSession();
String tname = (String) map.get("tname");
if(tname!=null && !tname.equals("")){
hql+= " and  f.member.memberName like '%"+tname+"%'";
}
return hql;
}
//获得Member
public Member getMember(String id){
Session session = sessionFactory.getCurrentSession();
Member m = (Member) session.get(Member.class, id);
return m;
}
public void saveFeedback(Feedback f){
Session session = getsesstion();
session.save(f);
}
/*-----------------------------------------------------------------subject_file-----------------------------------------------------------------------*/
public SubjectFile getSubjectFile(int id){
Session session = getsesstion();
SubjectFile f = (SubjectFile) session.get(SubjectFile.class, id);
return f;
}
}
