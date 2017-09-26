package com.item.finance.services;

import java.util.List;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.item.finance.bean.Subject;
import com.item.finance.bean.SubjectBbinPurchaseRecord;
import com.item.finance.bean.SubjectFile;
import com.item.finance.bean.SubjectFolder;
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
   //查询对象
    public Subject selectGetById(int id){
    	return this.yx_Subject_Dao.selectSubject(id);
    } 
    //修改上传前的查询
    public SubjectFile selectSubjectFile(int id){
    	return this.yx_Subject_Dao.selectSubjectFile(id);
    } 
   
    public void delete(Subject subject){
    	this.yx_Subject_Dao.deleteSubject(subject);
    }
    //修改
    public void updateSubject(Subject subject){
    	this.yx_Subject_Dao.updateSubject(subject);
    }
    //修改上传
    public void updateSubjectFile(SubjectFile subjectFile){
    	this.yx_Subject_Dao.updateSubjectFile(subjectFile);
    }
    //添加SubjectFolder表
    public void saveSubjectFolder(SubjectFolder subjectFolder){
    	this.yx_Subject_Dao.saveSubjectFolder(subjectFolder);
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
