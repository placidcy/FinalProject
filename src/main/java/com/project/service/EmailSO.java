package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;

@Service
public class EmailSO {
	@Autowired
	private AmazonSimpleEmailService amazonSimpleEmailService;

	public void sendVerificationEmail(String to, String subject, String body) {
		SendEmailRequest request = new SendEmailRequest().withDestination(new Destination().withToAddresses(to))
				.withMessage(new Message().withSubject(new Content().withData(subject))
						.withBody(new Body().withHtml(new Content().withData(body))))
				.withSource("no-reply@app-check.shop");
		amazonSimpleEmailService.sendEmail(request);
	}
}
