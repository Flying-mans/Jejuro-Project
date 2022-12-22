package com.jejuro.server.dao;

import org.apache.ibatis.annotations.Mapper;

import com.jejuro.server.entities.Member;

@Mapper
public interface MemberDao {
	void insert(Member member);

	Member get(String email);

	void delete(String email);

	void update(Member member);
}
