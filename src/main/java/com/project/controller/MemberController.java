package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MemberController {
	
	@GetMapping("/login")
	public String loginHandler() {
		return "login";
	}
	
}
