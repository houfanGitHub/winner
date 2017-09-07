package com.item.finance.services;

import java.util.List;


/**
 * 
 * @author 侯凡
 *	服务层interface
 */


public interface ItemServiceImpl<T> {
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public T getById(int id);
	
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
