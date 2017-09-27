package com.item.finance.services;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.Feedback;
import com.item.finance.bean.Member;
import com.item.finance.dao.XiezhengyuDao;
@Service
@Transactional
public class Xzy_FeedbackService implements ItemServiceImpl<Member>{
@Autowired
private XiezhengyuDao dao;
	@Override
	public Member selectGetById(String id) {
		Member m = this.dao.getMember(id);
		return m;
	}

	@Override
	public List<Member> list() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Feedback> listFeedback(Map map){
	List<Feedback> list = this.dao.listFeedback(map);
	return list;
	}
	@Override
	public void save(Member t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Member t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Member t) {
		// TODO Auto-generated method stub
		
	}

}
