package com.item.finance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.MemberAccount;
import com.item.finance.dao.MemberAccountDao;

@Service
@Transactional
public class MemberAccountService implements ItemServiceImpl<MemberAccount> {
	
	@Autowired
	private MemberAccountDao memberAccountDao;

	@Override
	public MemberAccount selectGetById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberAccount> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(MemberAccount memberAccount) {
		// TODO Auto-generated method stub
		memberAccountDao.save(memberAccount);
	}

	@Override
	public void update(MemberAccount memberAccount) {
		// TODO Auto-generated method stub
		memberAccountDao.update(memberAccount);
	}

	@Override
	public void delete(MemberAccount t) {
		// TODO Auto-generated method stub
		
	}

	public MemberAccount selectGetByMemberId(String id) {
		// TODO Auto-generated method stub
		MemberAccount memberAccount = memberAccountDao.selectGetByMemberId(id);
		return memberAccount;
	}

}
