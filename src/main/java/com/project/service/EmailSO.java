package com.project.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.amazonaws.services.simpleemail.model.Body;
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
		return String.format(
				"""
						<!DOCTYPE html>
						<html lang="en">
						<head>
						    <meta charset="UTF-8">
						    <meta name="viewport" content="width=device-width, initial-scale=1.0">
						    <title>Email Verification</title>
						    <link rel="stylesheet" as="style" crossorigin href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
						    <style>
								%s
						    </style>
						</head>
						<body>
						    <div class="container">
						        <div class="logo">CHECK</div>
						        <h1>이메일 인증을 완료하세요</h1>
						        <p class="verification-code">인증코드: <span id="code">%s</span></p>
						    </div>
						</body>
						</html>
						""",
				this.setStyle(), code);
	}

	public String createCode(String email) {
		String code = this.generateCode();
		int res = emailDAO.createAuth(email, code);

		return res > 0 ? code : null;
	}

	public String generateCode() {
		Random random = new Random();
		int code = random.nextInt(900000) + 100000; // 100000 ~ 999999 범위의 숫자 생성
		return String.valueOf(code);
	}

	public boolean verifyCode(String email, String code) {
		return emailDAO.checkAuth(email, code) > 0;
	}

	public boolean checkIfEmailExists(String email) {
		return emailDAO.checkAuth(email) > 0;
	}

	public String setStyle() {
		return """
				body {
				    display: flex;
				    justify-content: center;
				    align-items: center;
				    height: 100vh;
				    background: linear-gradient(135deg, #f5f7fa, #c3cfe2);
				    margin: 0;
				}

				.container {
				    font-family: 'Pretendard' !important;
				    text-align: center;
				    background-color: white;
				    padding: 30px;
				    border-radius: 10px;
				    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
				}

				.logo {
				    font-size: 28px;
				    font-weight: bold;
				    color: #87C791;
				    margin-bottom: 20px;
				}

				h1 {
				    font-size: 24px;
				    color: #333;
				    margin-bottom: 20px;
				}

				.verification-code {
				    font-size: 16px;
				    color: #666;
				}

				.verification-code span {
				    font-weight: bold;
				    color: #87C791;
				    background-color: #f0f0f0;
				    padding: 5px 10px;
				    border-radius: 5px;
				}

				button {
				    padding: 10px 20px;
				    background-color: #b7b7b7;
				    color: white;
				    border: none;
				    border-radius: 4px;
				    cursor: pointer;
				}

				button:hover {
				    background-color: #88b98e;
				}
				""";
	}
}
