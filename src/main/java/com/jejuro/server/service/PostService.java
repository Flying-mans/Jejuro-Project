package com.jejuro.server.service;

import java.util.List;

import com.jejuro.server.entity.Post;

public interface PostService {
	List<Post> getPost();

	List<Post> getPost(int page);

	void regPost(String title, String content);

	Post get(int id);

	
	void delPost(int id);

	void viewAdd(int id);


}
