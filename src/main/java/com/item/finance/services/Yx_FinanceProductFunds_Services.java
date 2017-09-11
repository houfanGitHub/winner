package com.item.finance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.item.finance.bean.FinanceProductFunds;
import com.item.finance.dao.Yx_FinanceProductFunds_Dao;

@Service
@Transactional
public class Yx_FinanceProductFunds_Services {
    @Autowired
	private Yx_FinanceProductFunds_Dao yx_FinanceProductFunds_Dao;
    
    public void save(FinanceProductFunds financeProductFunds){
    	this.yx_FinanceProductFunds_Dao.saveFinanceProductFunds(financeProductFunds);
    }
    public List<FinanceProductFunds> listFinanceProductFunds(){
    	return yx_FinanceProductFunds_Dao.listFinanceProductFunds();
    }
    public FinanceProductFunds selectFinanceProductFunds(String id){
    	return yx_FinanceProductFunds_Dao.selectFinanceProductFunds(id);
    } 
    public void deleteFinanceProductFunds(FinanceProductFunds financeProductFunds){
    	this.yx_FinanceProductFunds_Dao.deleteFinanceProductFunds(financeProductFunds);
    }
    public void updateFinanceProductFunds(FinanceProductFunds financeProductFunds){
    	this.yx_FinanceProductFunds_Dao.updateFinanceProductFunds(financeProductFunds);
    }
}
