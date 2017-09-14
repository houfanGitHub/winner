package com.item.finance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.UserRoleRelation;
import com.item.finance.dao.UserRoleRelationDao;

@Service
@Transactional
public class UserRoleRelationService implements ItemServiceImpl<UserRoleRelation> {

	@Autowired
	private UserRoleRelationDao userRoleRelationDao;
	
	@Override
	public UserRoleRelation selectGetById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRoleRelation> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(UserRoleRelation t) {
		// TODO Auto-generated method stub
		userRoleRelationDao.save(t);
	}

	@Override
	public void update(UserRoleRelation t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserRoleRelation t) {
		// TODO Auto-generated method stub
		
	}
	
	
}
