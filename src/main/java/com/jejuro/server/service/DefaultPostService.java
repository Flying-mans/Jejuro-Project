package com.jejuro.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jejuro.server.dao.PostDao;
import com.jejuro.server.entity.Post;

@Service
public class DefaultPostService implements PostService{

	@Autowired
	private PostDao dao;
	
	@Override
	public List<Post> getPost() {

		return getPost(1);
	}
	
	@Override
	public List<Post> getPost(int page) {
		int size=5;
		int offset = (page-1)*size;
		
		return dao.getPost(offset, size);
	}

	@Override
	public void regPost(String title, String content) {
		
		Post post = new Post(title, content);
		dao.regPost(post);
	}

	@Override
	public Post get(int id) {
		dao.viewAdd(id);
		return dao.get(id);
	}
	@Override
	public void delPost(int id) {
		dao.delPost(id);
	}


	@Override
	public void modPost(int id, String title, String content) {
		dao.modPost(id,title,content);
	}





	
}
