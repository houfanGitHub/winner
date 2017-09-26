package com.item.finance.services;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.FinanceProductFunds;
import com.item.finance.bean.FinanceProductSubscribe;
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

	public List<FinanceProductFunds> listFinanceProductFunds(Map map) {
		return this.yx_FinanceProductFunds_Dao.listFinanceProductFunds(map);
	}
	public FinanceProductFunds listEdit(int id){
		return yx_FinanceProductFunds_Dao.listEdit(id);
	}
	//私募股权类添加
	public void saveFinanceProductFunds(FinanceProductFunds financeProductFunds){
		this.yx_FinanceProductFunds_Dao.saveFinanceProductFunds(financeProductFunds);
	}
	//未签署查询
	public List<FinanceProductSubscribe> listWqs(int id){
		return this.yx_FinanceProductFunds_Dao.listWdl(id);
	}
	public FinanceProductSubscribe listChakan(int id){
		return this.yx_FinanceProductFunds_Dao.listchakan(id);
	}
	public FinanceProductSubscribe	selectqssb(int id){
		return this.yx_FinanceProductFunds_Dao.selectqssb(id);
	}
	public void updateqssb(FinanceProductSubscribe fe){
		 this.yx_FinanceProductFunds_Dao.updateqssb(fe);
	}
	//私募股权类修改
	public void updateFinanceProductFunds(FinanceProductFunds financeProductFunds){
		 this.yx_FinanceProductFunds_Dao.updateFinanceProductFunds(financeProductFunds);
	}
	//已签署
	public void savesign(FinanceProductSubscribe financeProductSubscribe){
		this.yx_FinanceProductFunds_Dao.saveSign(financeProductSubscribe);
	}
	
	
	
	@Override
	public void save(FinanceProductFunds t) {
	}
	@Override
	public void update(FinanceProductFunds t) {
	}
	@Override
	public void delete(FinanceProductFunds t) {
	}
	@Override
	public List<FinanceProductFunds> list() {
		return null;
	}
}
