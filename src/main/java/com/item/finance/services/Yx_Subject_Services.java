package com.item.finance.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.item.finance.bean.Subject;
import com.item.finance.dao.Yx_Subject_Dao;
@Service
@Transactional
public class Yx_Subject_Services implements ItemServiceImpl<Subject> {
	
    @Autowired
	private Yx_Subject_Dao yx_FinanceProductFunds_Dao;
    
    public void save(Subject subject){
    	this.yx_FinanceProductFunds_Dao.saveSubject(subject);
    }
    public List<Subject> list(){
    	return this.yx_FinanceProductFunds_Dao.listSubject();
    }
    public Subject selectGetById(String id){
    	return this.yx_FinanceProductFunds_Dao.selectSubject(id);
    } 
    public void delete(Subject subject){
    	this.yx_FinanceProductFunds_Dao.deleteSubject(subject);
    }
    public void update(Subject subject){
    	this.yx_FinanceProductFunds_Dao.updateSubject(subject);
    }
}
