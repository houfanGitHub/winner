package com.item.finance.services;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.item.finance.bean.NewsType;
import com.item.finance.dao.XiezhengyuDao;
@Service
@Transactional
public class Xzy_NewsTypeService implements ItemServiceImpl<NewsType>{
	@Autowired
	private XiezhengyuDao dao;
	@Override
	public NewsType selectGetById(String id) {
		// TODO Auto-generated method stub
		NewsType nt = this.dao.getNewsType(Integer.valueOf(id));
		return  nt;
	}

	@Override
	public List<NewsType> list() {
		return null;
	}
	public List<NewsType> listNewsType(Map map) {
		List<NewsType> list = this.dao.listNewsType(map);
		return list;
	}
	@Override
	public void save(NewsType nt) {
		// TODO Auto-generated method stub
	this.dao.saveNewsType(nt);
	}

	@Override
	public void update(NewsType nt) {
	this.dao.updateNewsType(nt);
	}

	@Override
	public void delete(NewsType nt) {
		// TODO Auto-generated method stub
	this.dao.deleteNewsType(nt);
	}
}
