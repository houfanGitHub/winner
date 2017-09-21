package com.item.finance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.MemberBankcard;
import com.item.finance.dao.MemberBankcardDao;

@Service
@Transactional
public class MemberBankcardService implements ItemServiceImpl<MemberBankcard> {

	@Autowired
	private MemberBankcardDao memberBankcardDao;
	
	@Override
	public MemberBankcard selectGetById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberBankcard> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(MemberBankcard memberBankcard) {
		// TODO Auto-generated method stub
		memberBankcardDao.save(memberBankcard);
	}

	@Override
	public void update(MemberBankcard t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MemberBankcard t) {
		// TODO Auto-generated method stub
		
	}
	
	
}
