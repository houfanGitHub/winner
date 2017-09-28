package com.item.finance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.finance.bean.OverseaConfig;
import com.item.finance.bean.OverseaConfigSubscribe;

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
	public List<OverseaConfigSubscribe> listOverseaConfigSubscribe(){
		Session session=getSession();
		String hql="from OverseaConfigSubscribe";
		List<OverseaConfigSubscribe> list=session.createQuery(hql).list();
		return list;
	}
	//修改前查询
	public OverseaConfig selectOverseaConfig(int id){
		Session session=getSession();
		OverseaConfig overseaConfig=(OverseaConfig)session.get(OverseaConfig.class,id);
	    return overseaConfig;
	}
	//修改
	public void updateOverseaConfig(OverseaConfig overseaConfig){
		Session session=getSession();
		session.update(overseaConfig);
	}
	//保存
	public void saveOverseaConfig(OverseaConfig overseaConfig){
		Session session=getSession();
		session.update(overseaConfig);
	}

}
