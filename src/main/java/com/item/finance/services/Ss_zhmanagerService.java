package com.item.finance.services;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.FinancialPlanner;
import com.item.finance.bean.Member;
import com.item.finance.bean.MemberAccount;
import com.item.finance.bean.MemberDepositRecord;
import com.item.finance.bean.MemberTradeRecord;
import com.item.finance.bean.MemberWithdrawRecord;
import com.item.finance.bean.SubjectPurchaseRecord;
import com.item.finance.dao.Ss_zhManangerDao;

@Service
@Transactional
public class Ss_zhmanagerService implements ItemServiceImpl<Member>  {

	
	@Autowired
	private Ss_zhManangerDao Ss_zhManangerDao;
//用户id
	@Override
	public Member selectGetById(String id) {
		Member member=Ss_zhManangerDao.getId(id);
		return member;
	}
	
	

	@Override
	public List<Member> list() {
		
		return null;
	}
	//显示
public List<Member> list(Map map) {
	return this.Ss_zhManangerDao.listzh(map);

	}

//资金详情id
	public MemberAccount getById(String id){
		return Ss_zhManangerDao.getmemberaccount(id);
	}
	
	//理财师id
	public FinancialPlanner getBYid(String id){
		return Ss_zhManangerDao.getFinancialplanner(id);
	}
	
	//投资记录id
	
	public List<SubjectPurchaseRecord> getlistspr(String id){
		return this.Ss_zhManangerDao.listSubjectpur(id);
	}
	
	
	
	
	//提现记录  id
	public List<MemberWithdrawRecord> getByIdwith(String id){
		return this.Ss_zhManangerDao.getmemberwithdraw(id);
		
	}
	//充值记录id
	public List<MemberDepositRecord> getbyIddeposit(String id){
		return this.Ss_zhManangerDao.getmemberdeposit(id);
	}
	//钱包交易记录 id
	public List<MemberTradeRecord> getbyIdtrade(String id){
		return this.Ss_zhManangerDao.getmemberTrade(id);
	}
	

	@Override
	public void save(Member t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Member t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Member t) {
		// TODO Auto-generated method stub
		
	}
	
}
