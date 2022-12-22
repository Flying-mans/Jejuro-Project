package com.jejuro.server.services;

import com.jejuro.server.entities.Member;

public interface MemberService {
	void add(Member member);

	Member get(String email);

	void delete(String email);

	void update(Member member);
}
