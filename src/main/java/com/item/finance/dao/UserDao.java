package com.item.finance.dao;

import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.item.finance.bean.User;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	public User selectGetByUserName(String userName) {
		// System.out.println("selectGetByUserName:name = "+userName);
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from User where name = '" + userName + "'";
		List<User> list = session.createQuery(hql).list();
		System.out.println("selectGetByUserName:list = " + list.size());
		User user = null;
		if (!list.isEmpty()) {
			user = list.get(0);
		}
		return user;
	}

	public List<User> list() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from User";
		List<User> list = session.createQuery(hql).list();
		return list;
	}

	/**
	 * 验证原密码
	 * 
	 * @param user
	 * @param oldPassword
	 * @return
	 */
	public boolean toPasswordValidation(User user, String oldPassword) {
		// TODO Auto-generated method stub
		// 盐值加密
		String hashAlgorithmName = "MD5";
		Object credentials = oldPassword;
		Object obj = ByteSource.Util.bytes(user.getName());
		int hashIterations = 1024;
		Object result = new SimpleHash(hashAlgorithmName, credentials, obj,hashIterations);
		System.out.println("oldpassword = "+result.toString());
		System.out.println("user.getPassword() = "+user.getPassword());
//		System.out.println("password = " + user.getPassword() + ",盐值加密之后 = "+ result);
		if(result.toString().equals(user.getPassword())){
			return true;
		}
		return false;
	}

	public boolean updatePassword(User user,String newPassword) {
		// TODO Auto-generated method stub
		try {
			// 盐值加密
			String hashAlgorithmName = "MD5";
			Object credentials = newPassword;
			Object obj = ByteSource.Util.bytes(user.getName());
			int hashIterations = 1024;
			Object result = new SimpleHash(hashAlgorithmName, credentials, obj,hashIterations);
			user.setPassword(result.toString());
			Session session = sessionFactory.getCurrentSession();
			session.update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
