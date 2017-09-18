package com.item.finance.services;

import java.util.List;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.item.finance.bean.Subject;
import com.item.finance.bean.SubjectBbinPurchaseRecord;
import com.item.finance.bean.SubjectFile;
import com.item.finance.dao.Yx_Subject_Dao;
@Service
@Transactional
public class Yx_Subject_Service implements ItemServiceImpl<Subject> {
	
    @Autowired
	private Yx_Subject_Dao yx_Subject_Dao;
    
    public void saveSubject(Subject subject){
    	this.yx_Subject_Dao.saveSubject(subject);
    }
    //上传
 public void saveSubjectFile(SubjectFile subjectFile){
	 this.yx_Subject_Dao.saveSubjectFile(subjectFile);
    }
    public List<Subject> list(Map map){
    	return this.yx_Subject_Dao.listSubject(map);
    }
    public List<SubjectBbinPurchaseRecord>  listtouzi(int id){
    	return this.yx_Subject_Dao.listtouzi(id);
    }
   
    public Subject selectGetById(int id){
    	return this.yx_Subject_Dao.selectSubject(id);
    } 
   
    public void delete(Subject subject){
    	this.yx_Subject_Dao.deleteSubject(subject);
    }
    public void updateSubject(Subject subject){
    	this.yx_Subject_Dao.updateSubject(subject);
    }
	@Override
	public List<Subject> list() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Subject selectGetById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void save(Subject t) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Subject t) {
		// TODO Auto-generated method stub
		
	}
	
}
