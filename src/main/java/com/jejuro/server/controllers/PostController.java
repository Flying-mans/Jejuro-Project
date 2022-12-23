package com.jejuro.server.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jejuro.server.entity.Post;
import com.jejuro.server.service.PostService;

@Controller
@RequestMapping("/")
public class PostController {

	@Autowired
	private PostService service;
	
	@GetMapping("post1")
	public String post1(Model model) {
		service.getPost();
//		System.out.println(model);
		
		return "html/post/post";
	}
	
	@GetMapping("post")
	public String post(
			@RequestParam(defaultValue="1", name="p") int page,
			Model model) {
		List<Post> post = service.getPost(page);
		model.addAttribute("post", post);
		model.addAttribute("page", page);

		System.out.println(model);
		return "html/post/post";
	}
	
	@GetMapping("post/{id}")
	public String detail(
			@PathVariable("id")int id,
			Model model) {
		
		service.viewAdd(id);
		
		
		Post post = service.get(id);
		model.addAttribute("post",post);
//		System.out.println(post);
		return "html/post/post-detail-mod";
	}
	
	
	
	@GetMapping("post/post-detail")
	public String postDetail() {
		return "html/post/post-detail";
	}
	
	@GetMapping("post/post-detail-mod")
	public String postIndexMode() {
		return "html/post/post-detail-mod";
	}

	
	@PostMapping("post/post-detail")
	public String postReg(
			@RequestParam("title")String title,
			@RequestParam("content")String content) {
		
		service.regPost(title, content);
		return "redirect:/post";
	}
	//---test---
	
//	@GetMapping("post/delete/{id}")
//	public String postDelete(
//			@PathVariable("id")int id){
//		
//		service.delPost(id);
//		
//		return "html/post/post";
//	}
	@PostMapping("post/delete")
	public String postDelete(
			@RequestParam("id") int id) {
		service.delPost(id);
		return "redirect:/post";
	}
	

	

	
	
	

}
