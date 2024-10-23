package com.project.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.amazonaws.services.simpleemail.model.Body;
import com.project.model.MessageItem;
import com.project.model.dao.EmailDAO;

@Service
public class EmailSO {
	@Autowired
	private AmazonSimpleEmailService amazonSimpleEmailService;
	@Autowired
	private EmailDAO emailDAO;

	public void sendVerificationEmail(String to, String subject, String body) {
		SendEmailRequest request = new SendEmailRequest().withDestination(new Destination().withToAddresses(to))
				.withMessage(new Message().withSubject(new Content().withCharset("UTF-8").withData(subject))
						.withBody(new Body().withHtml(new Content().withCharset("UTF-8").withData(body))))
				.withSource("noreply@app-check.shop");

		amazonSimpleEmailService.sendEmail(request);
	}

	@Transactional
	public boolean sendEmail(String email) {
		boolean isSend = false;
		String code, subject, body;

		code = this.createCode(email);
		subject = this.setSubject();
		body = this.setBody(code);

		this.sendVerificationEmail(email, subject, body);
		isSend = true;

		return isSend;
	}

	public String setSubject() {
		return "CHECK: 이메일 인증을 완료하세요.";
	}

	public String setBody(String code) {
		return String.format("""
				<html>

				<body>
				    <h1>
				        이메일 인증을 완료하세요
				    </h1>
				    <table>
				        <tr>
				            <td>
				                인증코드: %s
				            </td>
				        </tr>
				    </table>
				</body>

				</html>
				""", code);
	}

	public String createCode(String email) {
		String code = UUID.randomUUID().toString();
		int res = emailDAO.createAuth(email, code);

		return res > 0 ? code : null;
	}

	public boolean verifyCode(String email, String code) {
		return emailDAO.checkAuth(email, code) > 0;
	}

	public boolean checkIfEmailExists(String email) {
		return emailDAO.checkAuth(email) > 0;
	}

}
