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

import com.jejuro.server.entity.Member;
import com.jejuro.server.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	public MemberController() {

	}
	@Autowired
	private MemberService service;

	//마이페이지 기능 확인을 위한 로그인 페이지
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("member", new Member());
		return "html/sign-up/sign-up";
	}
	
	//내 정보 확인
	@PostMapping("/myinfo")
	public String result(Member member) {
		service.add(member);
		String result = "redirect:/member/myinfo/"+member.getEmail();
		return result;
	}

	//email로 내 정보 확인을 위한 테스트
	@GetMapping("/myinfo/{email}")
	public String myinfo(@PathVariable("email") String email,
						Model model) {
		Member member = service.get(email);
		model.addAttribute("member", member);
		return "html/myinfo/myinfo";
	}
	
	//email로 내 정보 확인
	@PostMapping("/myinfo/{email}")
	public String Displaymyinfo(@PathVariable("email") String email) {
		service.get(email);
		return "html/myinfo/myinfo";
	}
	
	//내 정보 삭제
	@PostMapping("/myinfo/delete")
	public String delete(@RequestParam("email") String email) {
		service.delete(email);
		return "redirect:/member/register";
	}
	
	//내 정보 수정 
	@GetMapping("/myinfo/update/{email}")
	public String updatePage(@PathVariable("email") String email,
							Model model) {
		model.addAttribute("member", new Member(email));
		return "html/myinfo/update";
	}
	
	//내 정보 수정 완료
	@PostMapping("/myinfo/update")
	public String update(Member member) {
		service.update(member);
		String result = "redirect:/member/myinfo/"+member.getEmail();
		return result;
	}
}
