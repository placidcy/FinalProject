package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.MemberSO;
import com.project.model.MessageItem;
import com.project.model.request.SignupRequest;
import com.project.service.EmailSO;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmailAuthController {
	@Autowired
	private EmailSO emailSO;
	@Autowired
	private MemberSO memberSO;

	@RequestMapping("/email")
	public String testEmail() {
		return "signupform_email";
	}

	@ResponseBody
	@RequestMapping("/api/signup/sendEmail")
	public MessageItem sendEmail(@RequestParam(name = "email", required = true) String email) {
		MessageItem messageItem = new MessageItem();

		if (emailSO.checkIfEmailExists(email)) {
			messageItem.setRes(false);
			messageItem.setMsg("동일한 이메일로 인증 코드가 발송되었습니다. 3분 뒤에 다시 시도하세요.");

			return messageItem;
		}

		try {
			emailSO.sendEmail(email);
			messageItem.setRes(true);
			messageItem.setMsg("이메일이 발송되었습니다! 메일함을 확인하세요.");
		} catch (Exception e) {
			messageItem.setRes(false);
			messageItem.setMsg("이메일이 발송 과정에서 오류가 발생하였습니다. 다시 시도하세요.");
		}

		return messageItem;
	}

	@ResponseBody
	@RequestMapping("/api/signup/verifyCode")
	public MessageItem verifyCode(@RequestParam(name = "email", required = true) String email,
			@RequestParam(name = "code", required = true) String code, HttpSession session) {
		MessageItem messageItem = new MessageItem();

		if (emailSO.verifyCode(email, code)) {
			messageItem.setRes(true);
			messageItem.setMsg("이메일 인증에 성공하였습니다!");
			session.setAttribute("verifiedEmail", email);
		} else {
			messageItem.setRes(false);
			messageItem.setMsg("이메일 인증에 실패하였습니다. 인증코드를 다시 확인하세요.");
		}

		return messageItem;
	}

	@PostMapping("/signUpProcess2")
	public String signupProcessHandler(SignupRequest req, HttpSession session) {
		try {
			if (req.getM_email().equals((String) session.getAttribute("verifiedEmail"))) {
				memberSO.signupStudent(req);
				return "redirect:/login";
			} else {
				return "redirect:/signupform?error=signupFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/signupform?error=signupFailed";
		}
	}
}
