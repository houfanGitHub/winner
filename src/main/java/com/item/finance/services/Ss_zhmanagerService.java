package com.item.finance.services;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.BbinInfo;
import com.item.finance.bean.FinancialPlanner;
import com.item.finance.bean.Member;
import com.item.finance.bean.MemberAccount;
import com.item.finance.bean.MemberDepositRecord;
import com.item.finance.bean.MemberProfitRecord;
import com.item.finance.bean.MemberTradeRecord;
import com.item.finance.bean.MemberWithdrawRecord;
import com.item.finance.bean.Ss_suminvest;
import com.item.finance.bean.Ss_sumorder;
import com.item.finance.bean.Subject;
import com.item.finance.bean.SubjectBbinPurchaseRecord;
import com.item.finance.bean.SubjectOrderRecord;
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
/*
//资金详情id
	public MemberAccount getById(String id){
		return Ss_zhManangerDao.getmemberaccount(id);
	}*/
	
	public List<MemberAccount>getmemberaccountid(String id){
		return Ss_zhManangerDao.getmemberaccount(id);
	}
	/*
	//理财师id
	public FinancialPlanner getBYid(String id){
		return Ss_zhManangerDao.getFinancialplanner(id);
	}*/
	
	public List<FinancialPlanner>getfinaid(String id){
		return Ss_zhManangerDao.getFinancialplanner(id);
	}
	
	//投资记录id  （后台 前台）
	public List<SubjectPurchaseRecord> getlistspr(String id){
		return this.Ss_zhManangerDao.listSubjectpur(id);
	}
	//投资几笔记录
	public Ss_suminvest selectinvestgetbyid(String id){
		return this.Ss_zhManangerDao.listinvest(id);
	}
	
	
	
	//提现记录  id  （后台 前台）
	public List<MemberWithdrawRecord> getByIdwith(String id){
		return this.Ss_zhManangerDao.getmemberwithdraw(id);
		
	}
	//充值记录id  （后台  前台）
	public List<MemberDepositRecord> getbyIddeposit(String id){
		return this.Ss_zhManangerDao.getmemberdeposit(id);
	}
	//钱包交易记录 id
	public List<MemberTradeRecord> getbyIdtrade(String id){
		return this.Ss_zhManangerDao.getmemberTrade(id);
	}
	
	//前台个人查询收益记录  成员利润记录
	public List<MemberProfitRecord> getmeberpro(String id){
		return this.Ss_zhManangerDao.getmemberprofit(id);
	}
	
	/*//查询体验金
	public List<BbinInfo>listgetbbin(){
		return this.Ss_zhManangerDao.listbbin();
	}*/
	
	//前台个人预约记录
	public List<SubjectOrderRecord>listorder(String id){
		return this.Ss_zhManangerDao.getsubjectorder(id);
	}
	
	//预约记录 几笔数据
	public Ss_sumorder getlistorder(String id){
		return this.Ss_zhManangerDao.listsubjectorder(id);
	}
	//体验金记录信息
	public BbinInfo getbbin(String id){
		return this.Ss_zhManangerDao.getbb(id);
	}
	
	/*
	//SubjectBbinPurchaseRecord  //体验金购买标 的表
	public List<SubjectBbinPurchaseRecord>listbb(String id){
		return this.Ss_zhManangerDao.listsubjectbb(id);
	}
*/
	
	//SubjectBbinPurchaseRecord  //体验金购买标 的表
	public SubjectBbinPurchaseRecord getsubjectbbinpurBYid(String id){
	return Ss_zhManangerDao.getsubjectbinre(id);
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
