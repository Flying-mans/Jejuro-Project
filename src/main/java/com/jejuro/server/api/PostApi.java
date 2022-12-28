package com.jejuro.server.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jejuro.server.entity.Post;
import com.jejuro.server.service.PostService;

@RestController
@RequestMapping("/api")
public class PostApi {

	@Autowired
	private PostService service;
	
	@GetMapping("posts/{page}")
	public List<Post> getPost(
			@PathVariable("page") int page) {
		
		List<Post> post = service.getPost(page);
		
		return post;
	}
	
//	@GetMapping("post/{id}")
//	public String detail(
//			@PathVariable("id")int id,
//			Model model) {
//
//		Post post = service.get(id);
//		model.addAttribute("post",post);
//
//		return "html/post/mod";
//	}
}
