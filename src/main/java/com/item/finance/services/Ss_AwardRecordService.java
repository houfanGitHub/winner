package com.item.finance.services;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.AwardRecord;
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
