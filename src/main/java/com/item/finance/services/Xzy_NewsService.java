package com.item.finance.services;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.News;
import com.item.finance.dao.XiezhengyuDao;

@Service
@Transactional
public class Xzy_NewsService implements  ItemServiceImpl<News>{
@Autowired
private XiezhengyuDao dao;
@Override
public News selectGetById(String id) {
News n  = this.dao.getNews(Integer.valueOf(id));
return n;
}

@Override
public List<News> list() {
// TODO Auto-generated method stub
return null;
}
public List<News> listNews(Map map){
List<News> list= this.dao.listNews(map);
return list;
}

@Override
public void save(News n) {
this.dao.saveNews(n);
}

@Override
public void update(News n) {
	// TODO Auto-generated method stub
this.dao.updateNews(n);
}

@Override
public void delete(News n) {
	// TODO Auto-generated method stub
this.dao.deleteNews(n, n.getId());
}


}
