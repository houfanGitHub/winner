package com.item.finance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.MemberDepositRecord;
import com.item.finance.dao.Ss_memberrechargeDao;

@Service
@Transactional
public class Ss_memberDepositService implements ItemServiceImpl<MemberDepositRecord> {
	
	@Autowired
	private Ss_memberrechargeDao ss_memberrechargeDao;

	@Override
	public MemberDepositRecord selectGetById(String id) {
		MemberDepositRecord memberDepositRecord=ss_memberrechargeDao.getbyid(id);
		return memberDepositRecord;
		
	}

	@Override
	public List<MemberDepositRecord> list() {
		return this.ss_memberrechargeDao.listshowdeposit();
		
	}

	@Override
	public void save(MemberDepositRecord t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MemberDepositRecord t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MemberDepositRecord t) {
		// TODO Auto-generated method stub
		
	}


}
