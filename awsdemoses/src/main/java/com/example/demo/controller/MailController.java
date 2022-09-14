package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MailService;

@RestController
public class MailController {
	@Autowired
	private MailService mailService;
	
	@GetMapping("/sendMail")
	public String sendMessage(@RequestParam String fromEmail,
			@RequestParam String toEmail,
			@RequestParam String subject,
			@RequestParam String body) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(fromEmail);
		simpleMailMessage.setTo(toEmail);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(body);
		mailService.sendMessage(simpleMailMessage);
		return "Mail Sent Successfully !";
	}
}
