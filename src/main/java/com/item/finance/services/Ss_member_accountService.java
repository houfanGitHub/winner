package com.item.finance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.MemberAccount;
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
