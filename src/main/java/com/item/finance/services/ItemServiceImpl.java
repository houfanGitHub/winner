package com.item.finance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


/**
 * 
 * @author 侯凡
 *	服务层interface
 */

@Service
@Transactional
public interface ItemServiceImpl<T> {
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public T selectGetById(String id);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<T> list();
	
	/**
	 * 添加
	 */
	public void save();
	
	/**
	 * 修改
	 */
	public void update();
	
	/**
	 * 删除
	 */
	public void delete();
	
}
