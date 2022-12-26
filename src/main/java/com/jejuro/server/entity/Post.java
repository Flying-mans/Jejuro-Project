package com.jejuro.server.entity;

public class Post {
	private int post_id;
	private int member_id;
	private String title;
	private String content;
	private int view_count;
	private String reg_date;

	public Post() {
	}
	public Post(String title) {
		this.title = title;
	}
	public Post(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	public Post(int post_id, int member_id, String title, String content) {
		this.post_id = post_id;
		this.member_id = member_id;
		this.title = title;
		this.content = content;
	}
	
	
	public Post(int post_id, int member_id, String title, String content, int view_count) {
		this.post_id = post_id;
		this.member_id = member_id;
		this.title = title;
		this.content = content;
		this.view_count = view_count;
	}
	
	public Post(int post_id, int member_id, String title, String content, int view_count, String reg_date) {
		super();
		this.post_id = post_id;
		this.member_id = member_id;
		this.title = title;
		this.content = content;
		this.view_count = view_count;
		this.reg_date = reg_date;
	}
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPostId() {
		return post_id;
	}
	public void setPostId(int post_id) {
		this.post_id = post_id;
	}
	public int getMemberId() {
		return member_id;
	}
	public void setMemberId(int memberId) {
		this.member_id = memberId;
	}
	public String getReg_date() {
		return reg_date;
	}
	
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", member_id=" + member_id + ", title=" + title + ", content=" + content
				+ ", view_count=" + view_count + ", reg_date=" + reg_date + "]";
	}
	
	
	




}
