package com.jejuro.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jejuro.server.entities.Member;
import com.jejuro.server.dao.MemberDao;

@Service
public class DefaultMemberService implements MemberService{

	@Autowired
	private MemberDao dao;
	
	@Override
	public void add(Member member) {
		dao.insert(member);
		
	}

	@Override
	public Member get(String email) {
		return dao.get(email);
	}


	@Override
	public void delete(String email) {
		dao.delete(email);
	}

	@Override
	public void update(Member member) {
		dao.update(member);
	}

}
