package com.item.finance.services;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.News;
import com.item.finance.bean.NewsType;
import com.item.finance.dao.XiezhengyuDao;

@Service
@Transactional
public class XiezhengyuService {
@Autowired
private XiezhengyuDao dao;
/*--------------------------------------------------------------news------------------------------------------------------------- */
//增
public void saveNews(News n){
this.dao.saveNews(n);
}
//删
public void delteNews(News n,int id){
n = this.dao.getNews(id);
n.setNewsType(null);
this.dao.deleteNews(n);
}
//改
public void updateNews(News n,int id){
n = this.dao.getNews(id);
this.dao.updateNews(n);
}
//查
public void listNews(Map map){
this.dao.listNews(map);
}
/*--------------------------------------------------------------newsType--------------------------------------------------------- */
//增
public void saveNewsType(NewsType nt){
this.dao.saveNewsType(nt);
}
//删
public void delteNewsType(NewsType nt,int id){
nt = this.dao.getNewsType(id);
this.dao.deleteNewsType(nt);
}
//改
public void updateNewsType(NewsType nt,int id){
nt = this.dao.getNewsType(id);
this.dao.updateNewsType(nt);
}
//查
public void listNewsType(Map map){
this.dao.listNewsType(map);
}
}
