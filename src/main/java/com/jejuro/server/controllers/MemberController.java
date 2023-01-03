package com.jejuro.server.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jejuro.server.entity.Member;
import com.jejuro.server.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {

	public MemberController() {

	}

	@Autowired
	private MemberService service;

	// 마이페이지 기능 확인을 위한 로그인 테스트 페이지
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("member", new Member());
		return "html/sign-up/sign-up";
	}

	// 내 정보 확인
	@GetMapping("/myinfo")
	public String goMyinfo(Model model, Principal principal) {

		String username = principal.getName();
		System.out.println("username : "+username);
		// 이메일로 member id 가져오기
		Member member = service.getMemberByEmail(username);

		String result = "redirect:/member/myinfo/" + member.getMember_id();
		return result;
	}

	// 내 정보 확인
	@PostMapping("/myinfo")
	public String goMyinfo(Member member, Principal principal) {
		service.add(member);
		String result = "redirect:/member/myinfo/" + member.getMember_id();
		return result;
	}

	// 내 정보 확인
	@GetMapping("/myinfo/{id}")
	public String displayMyinfo(@PathVariable("id") int id,
			Model model) {
		Member member = service.get(id);
		model.addAttribute("member", member);
		return "html/myinfo/myinfo";
	}

	// 내 정보 확인을 위한 테스트
	@PostMapping("/myinfo/{id}")
	public String displayMyinfo(@PathVariable("id") int id) {
		service.get(id);
		return "html/myinfo/myinfo";
	}

	// 내 정보 삭제
	@PostMapping("/myinfo/delete")
	public String deleteMember(@RequestParam("id") int id) {
		service.delete(id);
		return "redirect:/member/register";
	}

	// 내 정보 수정하기
	@GetMapping("/myinfo/update/{id}")
	public String updateMember(@PathVariable("id") int id,
			Model model	) {

		Member member = service.get(id);
		model.addAttribute("member", new Member(id, member.getEmail(), null, null, null));
		return "html/myinfo/update";
	}

	// 내 정보 수정 완료
	@PostMapping("/myinfo/update/complete")
	public String updateComplete(Member member) {
		int id = service.update(member);
		String result = "redirect:/member/myinfo/" + id;
		return result;
	}

	// 로그인 테스트
	@GetMapping("login")
	public String login() {
		return "html/login/login";
	}

	@PostMapping("login")
	public String login(String email, String password, String returnURL, HttpSession session) {
		Member member = service.getMemberByEmail(email);

		if (member == null)
			return "redirect:login?error";
		else if (!member.getPassword().equals(password))
			return "redirect:login?error";

		session.setAttribute("email", member.getEmail());

		if (returnURL != null && returnURL.equals(""))
			return "reditect:" + returnURL;

		return "redirect:/index";
	}
}
