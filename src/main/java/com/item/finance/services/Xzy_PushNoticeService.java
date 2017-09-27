package com.item.finance.services;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.item.finance.bean.PushNotice;
import com.item.finance.dao.XiezhengyuDao;
@Service
@Transactional
public class Xzy_PushNoticeService implements ItemServiceImpl<PushNotice>{
	@Autowired
	private XiezhengyuDao dao;
	@Override
	public PushNotice selectGetById(String id) {
		// TODO Auto-generated method stub
		PushNotice p = this.dao.getPushNotice(id);
		return  p;
	}
	@Override
	public List<PushNotice> list() {
		return null;
	}
	public List<PushNotice> listPushNotice(Map map) {
		List<PushNotice> list = this.dao.listPushNotice(map);
		return list;
	}
	public List<PushNotice> listPushNoticeed(Map map) {
		List<PushNotice> list = this.dao.listPushNoticeed(map);
		return list;
	}
	@Override
	public void save(PushNotice p) {
		// TODO Auto-generated method stub
	this.dao.savePushNotice(p);
	}

	@Override
	public void update(PushNotice nt) {
	this.dao.updatePushNotice(nt);
	}

	@Override
	public void delete(PushNotice p) {
		// TODO Auto-generated method stub
	this.dao.deletePushNotice(p);
	}
}
