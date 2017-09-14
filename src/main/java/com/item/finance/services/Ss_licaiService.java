package com.item.finance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.FinancialPlanner;
import com.item.finance.dao.Ss_licaiDao;

@Service
@Transactional
public class Ss_licaiService implements ItemServiceImpl<FinancialPlanner> {
	
	@Autowired
	private Ss_licaiDao ss_licaiDao;

	@Override
	public FinancialPlanner selectGetById(String id) {
		FinancialPlanner financialPlanner=ss_licaiDao.getByid(id);
		return financialPlanner;
	}

	@Override
	public List<FinancialPlanner> list() {
		
		return this.ss_licaiDao.list();
	}
/*	//显示
public List<FinancialPlanner> list() {
		
		return null;
	}*/

	@Override
	public void save(FinancialPlanner t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(FinancialPlanner t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(FinancialPlanner t) {
		// TODO Auto-generated method stub
		
	}
	
	

}
