package com.item.finance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.FinanceProductFunds;
import com.item.finance.dao.Yx_FinanceProductFunds_Dao;

@Service
@Transactional
public class Yx_FinanceProductFunds_Service implements ItemServiceImpl<FinanceProductFunds>{
     @Autowired
	private Yx_FinanceProductFunds_Dao yx_FinanceProductFunds_Dao;
	
	@Override
	public FinanceProductFunds selectGetById(String id) {
		return null;
	}

	public List<FinanceProductFunds> listFinanceProductFunds() {
		return this.yx_FinanceProductFunds_Dao.listFinanceProductFunds();
	}
	public FinanceProductFunds listEdit(int id){
		return yx_FinanceProductFunds_Dao.listEdit(id);
	}
	@Override
	public void save(FinanceProductFunds t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(FinanceProductFunds t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(FinanceProductFunds t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FinanceProductFunds> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
