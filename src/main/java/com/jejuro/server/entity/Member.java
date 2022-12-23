package com.jejuro.server.entity;

public class Member {
	private int member_id;
	
	private String email;
	private String password;
	private String nickName;
	private String phoneNum;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(int id) {
		this.member_id = id;
	}

	public Member(String email, String password, String nickName, String phoneNum) {
		super();
		this.email = email;
		this.password = password;
		this.nickName = nickName;
		this.phoneNum = phoneNum;
	}
	

	public Member(int member_id, String email, String password, String nickName, String phoneNum) {
		this.member_id = member_id;
		this.email = email;
		this.password = password;
		this.nickName = nickName;
		this.phoneNum = phoneNum;
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
		return "Member [member_id=" + member_id + ", email=" + email + ", password=" + password + ", nickName="
				+ nickName + ", phoneNum=" + phoneNum + "]";
	}

	public int getMember_id() {
		return member_id;
	}

	
	
}
