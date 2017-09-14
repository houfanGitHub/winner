package com.item.finance.services;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.User;
import com.item.finance.dao.UserDao;

@Service
@Transactional
public class UserService implements ItemServiceImpl<User> {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User selectGetById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		List<User> list = userDao.list();
		return list;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User ser) {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * 通过用户名查询id
	 * @param userName
	 * @return
	 */
	public User selectGetByUserName(String userName) {
		User user = userDao.selectGetByUserName(userName);
		return user;
	}

	/**
	 * 根据userName查询Role
	 * @param username
	 * @return
	 */
	public Set<String> getRole(String userName) {
		// TODO Auto-generated method stub
		User uesr = selectGetByUserName(userName);
//		String 
		return null;
	}

	/**
	 * 通过用户名查询用户信息
	 * @param username
	 * @return
	 */
	public User getUserByUserName(String username) {
		// TODO Auto-generated method stub
		User user = userDao.selectGetByUserName(username);
		return user;
	}

}
