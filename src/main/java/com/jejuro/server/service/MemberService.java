package com.jejuro.server.service;

import java.util.List;

import com.jejuro.server.entity.Member;

public interface MemberService {
	//회원 추가
	void add(Member member);

	//회원 정보 가져오기
	Member get(String email);

	//회원 삭제
	void delete(String email);

	//회원 수정
	void update(Member member);
}
