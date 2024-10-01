package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.model.*;


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
	
	@GetMapping("/findcheck")
	public String findHandler() {
		return "findcheck";
	}
	
	@GetMapping("/findid")
	public String findIdHandler() {
		return "findid";
	}
	
	@GetMapping("/findpw")
	public String findPwHandler() {
		return "findpw";
	}
	
//	@PostMapping("/findProcess")
//	public String findProcessHandler() {
//		
//	}
	
	@GetMapping("/changepw")
	public String changePw() {
		return "changepw";
	}
	
//	@PostMapping("/changepwProcess")
//	public String changePwProcess() {
//		
//	}
 	
	@GetMapping("/mypage")
	public String mypageHandler() {
		return "mypage";
	}
	
	
}
