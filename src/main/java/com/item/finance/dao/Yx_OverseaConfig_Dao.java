package com.item.finance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.OverseaConfig;

@Component
public class Yx_OverseaConfig_Dao {
	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public List<OverseaConfig> listOverseaConfig(){
		Session session=getSession();
		String hql="from OverseaConfig";
		List<OverseaConfig> list=session.createQuery(hql).list();
		return list;
	}
	//海外配置预约记录
	public List<OverseaConfig> listOverseaConfigSubscribe(){
		Session session=getSession();
		String hql="from OverseaConfigSubscribe";
		List<OverseaConfig> list=session.createQuery(hql).list();
		return list;
	}

}