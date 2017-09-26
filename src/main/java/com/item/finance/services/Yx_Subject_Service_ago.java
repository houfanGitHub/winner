package com.item.finance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.Subject;

@Service
@Transactional
public class Yx_Subject_Service_ago {
	@Autowired
	private Yx_Subject_Service_ago yx_Subject_Service_ago;
	
	public List<Subject> listSubject_ago(){
		return this.yx_Subject_Service_ago.listSubject_ago();
	}
	
	
    
    
}    
    
