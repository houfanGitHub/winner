package com.item.finance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.MemberDepositRecord;
import com.item.finance.dao.MemberDepositRecordDao;

@Service
@Transactional
public class MemberDepositRecordService implements ItemServiceImpl<MemberDepositRecord> {

	@Autowired
	private MemberDepositRecordDao memberDepositRecordDao;
	
	@Override
	public MemberDepositRecord selectGetById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberDepositRecord> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(MemberDepositRecord memberDepositRecord) {
		// TODO Auto-generated method stub
		memberDepositRecordDao.save(memberDepositRecord);
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
