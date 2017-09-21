package com.item.finance.services;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.MemberWithdrawRecord;
import com.item.finance.dao.Ss_MemberWithdrawRecordDao;

@Service
@Transactional
public class Ss_MemberWithdrawRecordService implements ItemServiceImpl<MemberWithdrawRecord> {

	@Autowired 
	private Ss_MemberWithdrawRecordDao ss_MemberWithdrawRecordDao;

	@Override
	public MemberWithdrawRecord selectGetById(String id) {
		MemberWithdrawRecord memberWithdrawRecord=ss_MemberWithdrawRecordDao.getID(id);
		return memberWithdrawRecord;
	}

	@Override
	public List<MemberWithdrawRecord> list() {
		return null;
		
	}
	
	//显示
	public List<MemberWithdrawRecord> list(Map map) {
		return this.ss_MemberWithdrawRecordDao.listshow(map);
		
	}
	//模态窗口 审核操作
	public void updatememberwith(String id){
		ss_MemberWithdrawRecordDao.updateShenhe(id);
	}

	@Override
	public void save(MemberWithdrawRecord t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MemberWithdrawRecord t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MemberWithdrawRecord t) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
