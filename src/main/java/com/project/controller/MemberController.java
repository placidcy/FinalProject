package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MemberController {
	
	@GetMapping("/login")
	public String loginHandler() {
		return "login";
	}
	
	@GetMapping("/mypage")
	public String mypageHandler() {
		return "mypage";
	}
	
	
}
