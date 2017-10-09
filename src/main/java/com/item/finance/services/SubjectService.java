package com.item.finance.services;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.item.finance.bean.Subject;
import com.item.finance.bean.SubjectBbinPurchaseRecord;
import com.item.finance.bean.SubjectFile;
import com.item.finance.dao.SubjectDao;



@Service
@Transactional
public class SubjectService {
	
	@Autowired
	private SubjectDao subjectDao;
	
	public void save(Subject subject){
		this.subjectDao.save(subject);
	}
	
	public void savefile(SubjectFile subjectFile){
		this.subjectDao.savefile(subjectFile);
	}
	
	public void update(Subject subject){
		this.subjectDao.update(subject);
	}
	
	public List<Subject> listSubject(Map<String,String> map){
		return subjectDao.ListFixGet(map);
	}
	
	public Subject getById(int id){
		return this.subjectDao.getById(id);
	}
	
	public List<SubjectBbinPurchaseRecord> listsubjectrecord(int id){
		return subjectDao.listsubjectrecord(id);
	}
	

	public List<Subject> listSubjectm(Map map){
		return subjectDao.listsubject(map);
	}
	public List<Subject> subject(Map<String,String> map){
		return subjectDao.listsubject(map);

	}
	
	public List<Subject> subject(int id){
		return subjectDao.list_subject(id);
	}
	
	public List<Subject> query(String hql){
		return subjectDao.query(hql);
	}
}
