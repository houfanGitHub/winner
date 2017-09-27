package com.item.finance.services;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.Member;
import com.item.finance.bean.MemberTradeRecord;
import com.item.finance.dao.Ss_MemberTradeRecordDao;

@Service
@Transactional
public class Ss_MemberTradeRecordService  implements ItemServiceImpl<MemberTradeRecord>{
	@Autowired
	private Ss_MemberTradeRecordDao Ss_memberTradeRecordDao;
	
	//id
	@Override
	public MemberTradeRecord selectGetById(String id) {
		MemberTradeRecord memberTradeRecord=Ss_memberTradeRecordDao.getByID(id);
		return memberTradeRecord;
	}

	@Override
	public List<MemberTradeRecord> list() {
		// TODO Auto-generated method stub
		return null;
	}
	//显示全部
	public List<MemberTradeRecord> listmembertrade(Map map) {
		return this.Ss_memberTradeRecordDao.listmembertrade(map);
	}

	@Override
	public void save(MemberTradeRecord t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MemberTradeRecord t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MemberTradeRecord t) {
		// TODO Auto-generated method stub
		
	}

}
