package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.MemberSO;
import com.project.model.request.LoginRequest;
import com.project.model.request.SignupRequest;
import com.project.model.response.LoginResponse;

import jakarta.servlet.http.HttpSession;


@Controller
public class MemberController {
	
	@Autowired
	private MemberSO memberSo;
	
	public MemberController(MemberSO memberSo) {
		this.memberSo = memberSo;
	}
	
	@GetMapping("/login")
	public String loginHandler() {
		return "login";
	}
	
	@PostMapping("/loginProcess")
	public String loginProcessHandler(LoginRequest req, HttpSession session) {
		try {
			LoginResponse auth = memberSo.login(req.getM_acctid(), req.getM_acctpwd());
			
			if(auth != null) {
				session.setAttribute("auth", auth);
				
				int m_role = memberSo.checkM_role(auth.getMember_id());
				
				switch(m_role) {
					case 1:
						return "redirect:/mypage";
					case 2:
						return "redirect:/instructHome";
					default:
						return "redirect:/adminHome";
				}
			}
			else {
				session.setAttribute("loginFailMsg", "로그인에 실패했습니다.");
				return "redirect:/login";
			}
		}
		catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			session.setAttribute("loginFailMsg", "일치하는 정보가 없습니다.");
			return "redirect:/login";
		}
	}
	
	@GetMapping("logout")
	public String logoutHandler(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
	@GetMapping("/agreement")
	public String agreementHandler() {
		return "agreement";
	}
	
	@PostMapping("/agreementForm")
	public String checkAgreementHandler(
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
	
	@GetMapping("/findpwd")
	public String findPwdHandler() {
		return "findpw";
	}
	
//	@PostMapping("/findidProcess")
//	public String findProcessHandler() {
//		
//	}
//	@PostMapping("/findpwdProcess")
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
