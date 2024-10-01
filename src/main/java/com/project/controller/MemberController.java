package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.model.*;

import jakarta.servlet.http.HttpSession;


@Controller
public class MemberController {
	
	MemberDAO memberDao;
	
	@GetMapping("/login")
	public String loginHandler() {
		return "login";
	}
	
//	@PostMapping("/loginProcess")
//	public String loginProcessHandler(HttpSession session, MemberDO m_acctid, MemberDO m_acctpw) {
//
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
