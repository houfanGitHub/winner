package com.item.finance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.finance.bean.Member;
import com.item.finance.dao.MemberDao;

@Service
@Transactional
public class MemberService implements ItemServiceImpl<Member> {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public Member selectGetById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Member member) {
		// TODO Auto-generated method stub
		memberDao.save(member);
	}

	@Override
	public void update(Member member) {
		// TODO Auto-generated method stub
		memberDao.update(member);
	}

	@Override
	public void delete(Member t) {
		// TODO Auto-generated method stub
		
	}

	public Member selectGetByName(String name) {
		// TODO Auto-generated method stub
		Member member =memberDao.selectGetByName(name);
		return member;
	}

}
