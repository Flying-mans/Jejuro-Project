package com.jejuro.server.dao;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.jejuro.server.entity.Member;

@Mapper
public interface MemberDao {
	// 회원가입
	void signUp(Member member);

	// 회원 정보 가져오기
	Member get(int id);

	// 회원 삭제
	void delete(int id);

	// 회원 수정
	void update(Member member);

	// 회원 ID 정보 가져오기
	int getId(Member member);

	// 회원 email 가져오기
	Member getByEmail(String email);

	// nickname으로 회원 정보 가져오기
	Member getByNickname(String username);

	// 소셜 가입자 providerId로 가져오기
	Optional<Member> findByProviderId(String providerId);

}
