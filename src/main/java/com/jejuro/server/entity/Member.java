package com.jejuro.server.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	public Member(String email2, String nickName2, String password2, String phoneNum2) {
	}
	public Member(int id, String email2, Object object, Object object2, Object object3) {
    }
    private int member_id;
	private String email;
	private String password;
	private String passwordCK;
	private String nickName;
	private String phoneNum;
	private String role; // ROLE_USER, ROLE_ADMIN
	// OAuth를 위해 구성한 추가 필드 2개
	private String provider;
	private String providerId;

	private boolean isPresent;

}
