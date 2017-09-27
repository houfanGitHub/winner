package com.item.finance.services;


import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.Member;
import com.item.finance.bean.MemberBankcard;
import com.item.finance.bean.MemberDepositRecord;
import com.item.finance.dao.Ss_memberrechargeDao;

@Service
@Transactional
public class Ss_memberDepositService implements ItemServiceImpl<MemberDepositRecord> {
	
	@Autowired
	private Ss_memberrechargeDao ss_memberrechargeDao;

	@Override
	public MemberDepositRecord selectGetById(String id) {
		MemberDepositRecord memberDepositRecord=ss_memberrechargeDao.getbyid(id);
		return memberDepositRecord;
		
	}

	@Override
	public List<MemberDepositRecord> list() {
		return null;
		
	}
	
	public Member getmemberbyid(String id){
		return this.ss_memberrechargeDao.getmemberid(id);
		
	}
	
	public List<MemberDepositRecord> listmemberdeposit(String id){
		return this.ss_memberrechargeDao.getmemberdeposit(id);
	}
	
	//显示
		public List<MemberDepositRecord> list(Map map) {
			return this.ss_memberrechargeDao.listshowdeposit(map);
			
		}
	/*	
		//更新订单操作
		public  void updatememberdepoist(String id){
			this.ss_memberrechargeDao.updatememberdeposit(id);
		}
*/
		//更新操作
		public  void updatememberdeposit(String id){
			MemberDepositRecord memberDepositRecord=ss_memberrechargeDao.getbyid(id);
			memberDepositRecord.setStatus((byte) 1);   //更改状态
			ss_memberrechargeDao.updatestatus(memberDepositRecord);
		}
	@Override
	public void save(MemberDepositRecord t) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void update(MemberDepositRecord t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MemberDepositRecord t) {
		// TODO Auto-generated method stub
		
	}

}
