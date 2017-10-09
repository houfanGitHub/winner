package com.item.finance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.Member;
import com.item.finance.bean.MemberAccount;
import com.item.finance.bean.MemberBankcard;
import com.item.finance.bean.MemberProfitRecord;
import com.item.finance.bean.MemberTally;
import com.item.finance.bean.MemberTradeRecord;
import com.item.finance.bean.Subject;
import com.item.finance.bean.SubjectPurchaseRecord;
import com.item.finance.dao.FrontDao;

@Service
@Transactional
public class FrontService {
	@Autowired
	private FrontDao frontDao;
	
	public List<MemberBankcard> listbankcards(){
		return frontDao.listbankcards();
	}
	
	public void savebankcards(MemberBankcard member_bankcards){
		this.frontDao.savebankcards(member_bankcards);
	}
	
	public MemberBankcard getBankcardsById(String member_id){
		return this.frontDao.getBankcardsById(member_id);
	}
	
	public List<Member> listmember(){
		return this.frontDao.listMember();
	}
	
	public Member getMemberById(int member_id){
		return this.frontDao.getMemberById(member_id);
	}
	
	public MemberAccount memberAccount(String member_id){
		return this.frontDao.memberAccount(member_id);
	}
	
	public Subject getSubjectById(int subject_id){
		return this.frontDao.getSubjectById(subject_id);
	}
	
	public void updatesubject(Subject subject){
		this.frontDao.updatesubject(subject);
	}
	
	public void updateaccount(MemberAccount member_account){
		this.frontDao.updateaccount(member_account);
	}

	public void savetraderecord(MemberTradeRecord member_trade_record){
		this.frontDao.savetraderecord(member_trade_record);
	}

	public void saveprofit(MemberProfitRecord member_profit_record){
		this.frontDao.saveprofit(member_profit_record);
	}

	public void savetally(MemberTally member_tally){
		this.frontDao.savetally(member_tally);
	}

	public void savepurchaserecord(SubjectPurchaseRecord subject_purchase_record){
		this.frontDao.savepurchaserecord(subject_purchase_record);
	}

	public List<SubjectPurchaseRecord> listpurchase(int subject_id){
		return this.frontDao.listpurchase(subject_id);
	}

	public List<SubjectPurchaseRecord> listallpurchase(){
		return this.frontDao.listallpurchase();
	}
}
