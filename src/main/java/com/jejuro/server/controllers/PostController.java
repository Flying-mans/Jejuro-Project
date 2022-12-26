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
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService service;
	
	
	//DB상 POST 게시글
	@GetMapping("")
	public String getPost(
			@RequestParam(defaultValue="1", name="p") int page,
			Model model) {
		
		List<Post> post = service.getPost(page);
		
		model.addAttribute("post", post);
		System.out.println(model);
		return "html/post/post";
	}

	//클릭한 글 상세페이지로 이동
	@GetMapping("/{id}")
	public String detail(
			@PathVariable("id")int id,
			Model model) {

		Post post = service.get(id);
		model.addAttribute("post",post);

		return "html/post/mod";
	}

	//url 맵핑
	@GetMapping("/write")
	public String postDetail() {
		return "html/post/write";
	}
	

	//게시글 등록
	@PostMapping("/write")
	public String postReg(
			@RequestParam("title")String title,
			@RequestParam("content")String content) {
		
		service.regPost(title, content);
		return "redirect:/post";
	}

	//게시글 수정
	@PostMapping("/modify")
	public String postModify(
			@RequestParam("id") int id,
			@RequestParam("title")String title,
			@RequestParam("content")String content){
		service.modPost(id,title,content);
		return "redirect:/post";
	}
	
	//게시글 삭제
	@PostMapping("/delete")
	public String postDelete(
			@RequestParam("id") int id) {
		service.delPost(id);
		return "redirect:/post";
	}
	
	
	

	
	
	

}
