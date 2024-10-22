package com.project.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.project.model.dao.EmailDAO;

@Service
public class EmailSO {
	@Autowired
	private AmazonSimpleEmailService amazonSimpleEmailService;
	@Autowired
	private EmailDAO emailDAO;

	public void sendVerificationEmail(String to, String subject, String body) {
		SendEmailRequest request = new SendEmailRequest().withDestination(new Destination().withToAddresses(to))
				.withMessage(new Message().withSubject(new Content().withData(subject))
						.withBody(new Body().withHtml(new Content().withData(body))))
				.withSource("no-reply@app-check.shop");
		amazonSimpleEmailService.sendEmail(request);
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
