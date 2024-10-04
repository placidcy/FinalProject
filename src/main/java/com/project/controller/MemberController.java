package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.MemberSO;
import com.project.model.request.LoginRequest;
import com.project.model.request.SignupRequest;

import jakarta.servlet.http.HttpSession;


@Controller
public class MemberController {
	
	private MemberSO memberSo;
	
	public MemberController(MemberSO memberSo) {
		this.memberSo = memberSo;
	}
	
	@GetMapping("/login")
	public String loginHandler() {
		return "login";
	}
	
//	@PostMapping("/loginProcess")
//	public String loginProcessHandler(LoginRequest req, HttpSession session) {
//		try {
//			session.setAttribute("session", session);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		
////		if(m_role=1) {
////			return "/";
////		}
////		else if(m_role=2){
////			return "/";
////		}
////		else if(m_role=0) {
////			return "/";
////		}
//	}
	
	@GetMapping("/agreement")
	public String agreementHandler() {
		return "agreement";
	}
	
	@PostMapping("/agreementForm")
	public String checkAgreement(
			@RequestParam(value = "allagree", required = false) boolean allagree,
			@RequestParam(value = "memberagree", required = true) boolean memberagree,
			@RequestParam(value = "personalagree", required = true) boolean personalagree) {
		if(memberagree && personalagree) {
			return "/signupform";
		}
		else {
			return "redirect:/agreement";
		}
	}
	
	@GetMapping("/signupform")
	public String signupHandler() {
		return "signupform";
	}
	
	@PostMapping("/signupProcess")
	public String signupProcessHandler(SignupRequest req) {
		try {
			memberSo.signupStudent(req);
			return "redirect:/login";
		}
		catch(Exception e) {
			e.printStackTrace();
			return "redirect:/signupform?error=signupFailed";
		}
	}
	
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
	public String changePwdHandler() {
		return "changepw";
	}
	
//	@PostMapping("/changepwProcess")
//	public String changePwdProcessHandler() {
//		
//	}
 	
	@GetMapping("/mypage")
	public String mypageHandler() {
		return "mypage";
	}
	
	
}
