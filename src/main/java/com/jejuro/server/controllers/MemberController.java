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

import com.jejuro.server.entity.Alarm;
import com.jejuro.server.entity.Member;
import com.jejuro.server.service.AlarmService;
import com.jejuro.server.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	public MemberController() {

	}

	@Autowired
	private MemberService service;

	@Autowired
	private AlarmService alarmService;

	// 마이페이지 기능 확인을 위한 로그인 테스트 페이지
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("member", new Member());
		return "html/sign-up/sign-up";
	}

	// 내 정보 확인 테스트 페이지
	@PostMapping("/register")
	public String register(@RequestParam("email") String email,
						@RequestParam("nickname") String nickName,
						@RequestParam("password") String password,
						@RequestParam("phoneNum") String phoneNum) {
		Member member = new Member(email, nickName, password, phoneNum);
		service.add(member);
		Member getMember = service.getByEmail(email);
		String result = "redirect:/member/myinfo/" + getMember.getMember_id();
		return result;
	}

	// 내 정보 확인
	@GetMapping("/myinfo/{id}")
	public String myinfo2(@PathVariable("id") int id,
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
			Model model) {
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



	// 알람 설정===========================================

		// 내 정보 수정하기
		// @GetMapping("/myinfo/update/{id}")
		// public String updateMember(@PathVariable("id") int id,
		// 		Model model) {
		// 	Member member = service.get(id);
		// 	model.addAttribute("member", new Member(id, member.getEmail(), null, null, null));	
		// 	return "html/myinfo/update";
		// }

	// 알람 출력
	@GetMapping("/myinfo/alarm/{id}")
	public String displayAlarm(@PathVariable("id") int id, Model model) {

		List<Alarm> alarm = alarmService.getList(id);
		model.addAttribute("alarm", alarm);

		return "html/myinfo/alarm";

	}

	// 알람 삭제
	@PostMapping("/myinfo/alarm/delete")
	public String deleteAlarm(@RequestParam("id") int id, Model model) {

		model.addAttribute("id", id);
		int mid = alarmService.getMemberId(id);
		alarmService.delete(id);
		return "redirect:/member/myinfo/alarm/"+mid;
	}
}
