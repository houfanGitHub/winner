package com.item.finance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.item.finance.bean.SubjectPurchaseRecord;

@Service
@Transactional
public class SubjectPurchaseRecordService implements ItemServiceImpl<SubjectPurchaseRecord> {

	@Override
	public SubjectPurchaseRecord selectGetById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectPurchaseRecord> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(SubjectPurchaseRecord t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SubjectPurchaseRecord t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(SubjectPurchaseRecord t) {
		// TODO Auto-generated method stub
		
	}

}
