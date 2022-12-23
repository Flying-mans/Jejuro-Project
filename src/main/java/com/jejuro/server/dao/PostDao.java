package com.jejuro.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jejuro.server.entity.Post;

@Mapper
public interface PostDao {

	List<Post> getPost();

	List<Post> getPost1(int offset, int size);

	void regPost(Post post);

	Post get(int id);

	void delPost(int id);

	void viewAdd(int id);


}
