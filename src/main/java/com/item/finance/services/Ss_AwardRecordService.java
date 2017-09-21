package com.item.finance.services;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.AwardRecord;
import com.item.finance.bean.Member;
import com.item.finance.bean.MemberAccount;
import com.item.finance.dao.Ss_AwardRecordDao;

@Service
@Transactional
public class Ss_AwardRecordService implements ItemServiceImpl<AwardRecord> {
	
	@Autowired
	private Ss_AwardRecordDao ss_AwardRecordDao;

	@Override
	public AwardRecord selectGetById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	//得到 id
	public AwardRecord getById(int id){
		AwardRecord awardRecord=ss_AwardRecordDao.getId(id);
		return awardRecord;
	}

	@Override
	public List<AwardRecord> list() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//显示
	public List<AwardRecord>listAwardRecord(Map map){
		return this.ss_AwardRecordDao.listshowawardRecord(map);
	}
	/*
	//点击奖励记录
	public AwardRecord getByAwardr(int id){
		return this.ss_AwardRecordDao.getAward(id);
	}*/
	
	
	

	
	//member表中的 id
	public  Member getbymemberId(String id){
		Member member=ss_AwardRecordDao.getmemberid(id);
		return member;
	}
	
	//邀请奖励id
	public List<AwardRecord> listawardrecord(int id){
		return this.ss_AwardRecordDao.listawrecord(id);
	}
	
	
	
	//投资金额
	public List<MemberAccount>listmema(){
		return this.ss_AwardRecordDao.listma();
	}
	
	@Override
	public void save(AwardRecord t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AwardRecord t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(AwardRecord t) {
		// TODO Auto-generated method stub
		
	}
	
	

}
