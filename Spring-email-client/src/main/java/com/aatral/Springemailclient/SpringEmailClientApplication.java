package com.aatral.Springemailclient;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.beans.factory.annotation.Autowired;


import com.aatral.Springemailclient.service.EmailSenderService;

import jakarta.mail.MessagingException;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringEmailClientApplication {

    @Autowired
    private EmailSenderService service;

    public static void main(String[] args) {
        SpringApplication.run(SpringEmailClientApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() throws MessagingException {
        List<String> recipients = new ArrayList<>();
        recipients.add("debasmitarath06@gmail.com");
        recipients.add("dibyashreedash222@gmail.com");

        String interviewLink = "https://youtu.be/vap9ACtc_tU?si=xAN2LV0sRqr0-V2t";

       
        for (String recipient : recipients) {
        	service.sendEmailWithAttachmentAndLink(recipient,
                    "This is Email Body with Attachment...",
                    "This email has attachment",
                    "C:\\Users\\Aatral\\Pictures\\Camera Roll\\WIN_20230811_14_38_38_Pro.jpg",
                    interviewLink);
        }
    }
}


