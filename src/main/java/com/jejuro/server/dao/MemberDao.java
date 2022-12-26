package com.jejuro.server.dao;

import org.apache.ibatis.annotations.Mapper;

import com.jejuro.server.entity.Member;

@Mapper
public interface MemberDao {
	//회원가입
	void signUp(Member member);

	//회원 정보 가져오기
	Member get(int id);

	//회원 삭제
	void delete(int id);

	//회원 수정
	void update(Member member);

	//회원 ID 정보 가져오기
    int getId(Member member);


}
