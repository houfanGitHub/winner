package com.item.finance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.OverseaConfig;
import com.item.finance.bean.OverseaConfigSubscribe;
import com.item.finance.dao.Yx_OverseaConfig_Dao;

@Service
@Transactional
public class Yx_OverseaConfig_Services implements ItemServiceImpl<OverseaConfig>{

	@Autowired
	private Yx_OverseaConfig_Dao yx_OverseaConfig_Dao;
	
	
	@Override
	public OverseaConfig selectGetById(String id) {
		return null;
	}
	
	@Override
	public List<OverseaConfig> list() {
		return this.yx_OverseaConfig_Dao.listOverseaConfig();
	}
	//海外配置预约记录
	public List<OverseaConfigSubscribe> list2() {
		return this.yx_OverseaConfig_Dao.listOverseaConfigSubscribe();
	}
	//海外配置修改前查询
	public OverseaConfig selectOverseaConfig(int id){
		return this.yx_OverseaConfig_Dao.selectOverseaConfig(id);
	}
public void updateOverseaConfig(OverseaConfig overseaConfig){
	this.yx_OverseaConfig_Dao.updateOverseaConfig(overseaConfig);
}
public void saveOverseaConfig(OverseaConfig overseaConfig){
	this.yx_OverseaConfig_Dao.saveOverseaConfig(overseaConfig);
}
	@Override
	public void save(OverseaConfig t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(OverseaConfig t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(OverseaConfig t) {
		// TODO Auto-generated method stub
		
	}

}
