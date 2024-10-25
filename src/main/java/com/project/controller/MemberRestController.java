package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.MemberSO;
import com.project.model.response.LoginResponse;

import jakarta.servlet.http.HttpSession;

@RestController
public class MemberRestController {
	
	@Autowired
	private MemberSO memberSo;

	@GetMapping("/checkM_acctidDuplicate")
	public ResponseEntity<Boolean> checkM_acctidDuplicate(@RequestParam("m_acctid") String m_acctid) {
		boolean isAvaliable = memberSo.isM_acctidDuplicate(m_acctid);
		return ResponseEntity.ok(isAvaliable);
	}
	
	@GetMapping("/checkM_emailDuplicate")
	public ResponseEntity<Boolean> checkM_emailDuplicate(@RequestParam("m_email") String m_email) {
		boolean isAvaliable = memberSo.isM_emailDuplicate(m_email);
		return ResponseEntity.ok(isAvaliable);
	}
	
	@GetMapping("/getUserInfo")
	public ResponseEntity<Object> getUserInfo(HttpSession infoSession) {
		LoginResponse userInfo = (LoginResponse)infoSession.getAttribute("auth");
		
		if(userInfo != null) {
			return ResponseEntity.status(HttpStatus.FOUND).body(userInfo);
		}
		
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
