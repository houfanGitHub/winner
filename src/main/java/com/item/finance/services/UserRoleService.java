package com.item.finance.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.User;
import com.item.finance.bean.UserRole;
import com.item.finance.dao.UserDao;
import com.item.finance.dao.UserRoleDao;

@Service
@Transactional
public class UserRoleService implements ItemServiceImpl<UserRole> {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Override
	public UserRole selectGetById(String id) {
		// TODO Auto-generated method stub
		UserRole userRole = userRoleDao.selectGetById(id);
		return userRole;
	}

	@Override
	public List<UserRole> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(UserRole t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UserRole t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserRole t) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 根据用户名查询角色
	 * @param username
	 * @return
	 */
	public Set<String> getRole(String userName) {
		// TODO Auto-generated method stub
		User user  = userDao.selectGetByUserName(userName);
		Set<String> set = userRoleDao.getRole(user.getId());
		return set;
	}

}
