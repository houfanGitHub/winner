package com.item.finance.services;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.FinancialPlanner;
import com.item.finance.bean.Member;
import com.item.finance.bean.MemberAccount;
import com.item.finance.dao.Ss_zhManangerDao;

@Service
@Transactional
public class Ss_zhmanagerService implements ItemServiceImpl<Member>  {

	
	@Autowired
	private Ss_zhManangerDao Ss_zhManangerDao;

	@Override
	public Member selectGetById(String id) {
		Member member=Ss_zhManangerDao.getId(id);
		return member;
	}
	
	//账号详情id
	public MemberAccount getById(String id){
		return Ss_zhManangerDao.getmemberaccount(id);
	}
	
	//理财师id
	public FinancialPlanner getBYid(String id){
		return Ss_zhManangerDao.getFinancialplanner(id);
	}

	@Override
	public List<Member> list() {
		
		return null;
	}
	//显示
public List<Member> list(Map map) {
	return this.Ss_zhManangerDao.listzh(map);

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
