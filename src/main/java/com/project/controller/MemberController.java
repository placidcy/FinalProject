package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.model.MemberSO;


@Controller
public class MemberController {
	
	MemberSO memberSO;
	
	@GetMapping("/login")
	public String loginHandler() {
		return "login";
	}
	
//	@PostMapping
//	public String loginProcessHandler() {
//		
//	}
	
	@GetMapping("/mypage")
	public String mypageHandler() {
		return "mypage";
	}
	
	
}
