package com.item.finance.services;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.Ss_Sumsubject;
import com.item.finance.bean.Subject;
import com.item.finance.bean.SubjectBbinPurchaseRecord;
import com.item.finance.bean.SubjectPurchaseRecord;
import com.item.finance.dao.Ss_SubjectDao;

@Service
@Transactional
public class Ss_SubjectService  implements ItemServiceImpl<Subject>{
	
	@Autowired
	private Ss_SubjectDao ss_SubjectDao;

	@Override
	public Subject selectGetById(String id) {
		// TODO Auto-generated method stub
		return this.ss_SubjectDao.getById(id);
	}

	@Override
	public List<Subject> list() {
		// TODO Auto-generated method stub
		return null;
	}
	//显示
	public List<Subject> list(Map map) {
		// TODO Auto-generated method stub
		return this.ss_SubjectDao.listsub(map);
	}
	
	//体验金付息  id
	public  List<SubjectBbinPurchaseRecord>listSubjectbb(int id){
		return this.ss_SubjectDao.listsubjectbbin(id);
	}
	//体验金 还款功能
	public void updatesubjectb(int id){
		this.ss_SubjectDao.updatesubjectbbinp(id);
	}
	
	//付息列表
	public List<SubjectPurchaseRecord> listSubjectpurchase(String id){
		return ss_SubjectDao.listSubjectpr(id);
   }
	//付息列表中的  还款功能	
	
	public void updatesubjectpurchase(String id){
		this.ss_SubjectDao.updatesubjectp(id);
	}
	
	//已投金额
	public List<Ss_Sumsubject>listsumsub(){
		return ss_SubjectDao.listsumsubject();
	}
			
			
		
	
		

	@Override
	public void save(Subject t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Subject t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Subject t) {
		// TODO Auto-generated method stub
		
	}
	
	//

}
