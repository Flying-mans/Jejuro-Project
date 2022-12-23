package com.jejuro.server.entity;

public class Member {
	private int memberId;
	
	private String email;
	private String password;
	private String nickName;
	private String phoneNum;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String email) {
		this.email = email;
	}

	public Member(String email, String password, String nickName, String phoneNum) {
		super();
		this.email = email;
		this.password = password;
		this.nickName = nickName;
		this.phoneNum = phoneNum;
	}
	
	public Member(int memberId, String email, String password, String nickName, String phoneNum) {
		super();
		this.memberId = memberId;
		this.email = email;
		this.password = password;
		this.nickName = nickName;
		this.phoneNum = phoneNum;
	}


	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", email=" + email + ", password=" + password + ", nickName=" + nickName
				+ ", phoneNum=" + phoneNum + "]";
	}
	
	
}
