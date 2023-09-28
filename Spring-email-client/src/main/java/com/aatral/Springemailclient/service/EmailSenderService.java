package com.aatral.Springemailclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendSimpleEmail(String toEmail, String body, String subject) {

	}

	public void sendEmailWithAttachmentAndLink(String toEmail, String body, String subject, String attachment,
			String interviewLink) throws MessagingException {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

		mimeMessageHelper.setFrom("debasmitarath06@gmail.com");
		mimeMessageHelper.setTo(toEmail);

		// Append the interview link to the email body
		body += "\n\nInterview Link: " + interviewLink;

		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(subject);

		FileSystemResource fileSystem = new FileSystemResource(new File(attachment));

		mimeMessageHelper.addAttachment(fileSystem.getFilename(), fileSystem);

		mailSender.send(mimeMessage);
		System.out.println("Mail Send...");
	}

}
