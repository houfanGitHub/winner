package com.item.finance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.FinancialPlanner;
import com.item.finance.bean.Member;
import com.item.finance.bean.MemberAccount;
import com.item.finance.bean.MemberDepositRecord;
import com.item.finance.bean.MemberTradeRecord;
import com.item.finance.bean.MemberWithdrawRecord;
import com.item.finance.bean.SubjectPurchaseRecord;
import com.item.finance.dao.Ss_member_accountDao;

@Service
@Transactional
public class Ss_member_accountService implements ItemServiceImpl<MemberAccount> {
	
	@Autowired
	private Ss_member_accountDao ss_member_accountDao;

	@Override
	public MemberAccount selectGetById(String id) {
		MemberAccount memberAccount=ss_member_accountDao.getByID(id);
		return memberAccount;
	}

	@Override
	public List<MemberAccount> list() {
		// TODO Auto-generated method stub
		return this.ss_member_accountDao.listMemberAccount();
	}
	public Member selectGetBy(String id) {
		Member member=ss_member_accountDao.getId(id);
		return member;
	}
	

	//资金详情id
		public MemberAccount getById(String id){
			return ss_member_accountDao.getmemberaccount(id);
		}
		
		//理财师id
		public FinancialPlanner getBYid(String id){
			return ss_member_accountDao.getFinancialplanner(id);
		}
		
		//投资记录id
		
		public List<SubjectPurchaseRecord> getlistspr(String id){
			return this.ss_member_accountDao.listSubjectpur(id);
		}
		
		
		
		
		//提现记录  id
		public List<MemberWithdrawRecord> getByIdwith(String id){
			return this.ss_member_accountDao.getmemberwithdraw(id);
			
		}
		//充值记录id
		public List<MemberDepositRecord> getbyIddeposit(String id){
			return this.ss_member_accountDao.getmemberdeposit(id);
		}
		//钱包交易记录 id
		public List<MemberTradeRecord> getbyIdtrade(String id){
			return this.ss_member_accountDao.getmemberTrade(id);
		}
		
	@Override
	public void save(MemberAccount t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MemberAccount t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MemberAccount t) {
		// TODO Auto-generated method stub
		
	}
	

}
