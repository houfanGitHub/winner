package com.item.finance.services;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.MemberBankcard;
import com.item.finance.dao.SS_cardmanagementDao;

@Service
@Transactional
public class Ss_cardmanagementService implements ItemServiceImpl<MemberBankcard> {
	
	@Autowired
	private SS_cardmanagementDao ss_cardmanagementDao;

	@Override
	public MemberBankcard selectGetById(String id) {
		MemberBankcard memberBankcard=ss_cardmanagementDao.getByID(id);
		return memberBankcard;
	}

	@Override
	public List<MemberBankcard> list() {
		return null;
	
	}
	//显示
	public List<MemberBankcard> listshow(Map map){
		return this.ss_cardmanagementDao.list(map);
	}


	@Override
	public void save(MemberBankcard t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MemberBankcard t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MemberBankcard t) {
		// TODO Auto-generated method stub
		
	}
	

}
