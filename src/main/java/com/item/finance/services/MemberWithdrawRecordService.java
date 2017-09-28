package com.item.finance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.MemberWithdrawRecord;
import com.item.finance.dao.MemberWithdrawRecordDao;

@Service
@Transactional
public class MemberWithdrawRecordService implements ItemServiceImpl<MemberWithdrawRecord> {

	@Autowired
	private MemberWithdrawRecordDao memberWithdrawRecordDao;
	
	@Override
	public MemberWithdrawRecord selectGetById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberWithdrawRecord> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(MemberWithdrawRecord t) {
		// TODO Auto-generated method stub
		memberWithdrawRecordDao.save(t);
	}

	@Override
	public void update(MemberWithdrawRecord t) {
		// TODO Auto-generated method stub
		memberWithdrawRecordDao.update(t);
	}

	@Override
	public void delete(MemberWithdrawRecord t) {
		// TODO Auto-generated method stub
		
	}

	public MemberWithdrawRecord selectGetByRandomPayNumber(String randomPayNumber) {
		// TODO Auto-generated method stub
		MemberWithdrawRecord memberWithdrawRecord = memberWithdrawRecordDao.selectGetByRandomPayNumber(randomPayNumber);
		return memberWithdrawRecord;
	}
	
}
