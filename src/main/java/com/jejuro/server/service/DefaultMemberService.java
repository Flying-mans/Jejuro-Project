package com.jejuro.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jejuro.server.dao.MemberDao;
import com.jejuro.server.entity.Member;

@Service
public class DefaultMemberService implements MemberService{

	@Autowired
	private MemberDao dao;
	
	//회원 추가
	@Override
	public void add(Member member) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		member.setRole("ROLE_USER");
		member.setPresent(true);
		dao.signUp(member);
	}

	//회원 정보 가져오기
	@Override
	public Member get(int id) {
		return dao.get(id);
	}

	//회원 삭제
	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	//회원 수정
	@Override
	public int update(Member member) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		dao.update(member);
		return dao.getId(member);
	}

	// 회원 이메일 가져오기
	@Override
	public Member getByEmail(String email) {
		return dao.getByEmail(email);
	}

	// nickname으로 회원 정보 가져오기
	@Override
	public Member getByNickname(String username) {
		return dao.getByNickname(username);
	}


}
