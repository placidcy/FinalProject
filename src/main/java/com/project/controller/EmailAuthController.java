package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.MessageItem;
import com.project.service.EmailSO;

@Controller
public class EmailAuthController {
	@Autowired
	private EmailSO emailSO;

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
			messageItem.setMsg("검증 코드가 이미 발송되었습니다. 이메일을 확인하세요.");

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
}
