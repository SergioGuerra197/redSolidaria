package com.poli.redsolidaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImp implements EmailServiceService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("$(spring.mail.username)")
    private String fromMail;

    public void sendEmail(String toEmail, String subject, String body){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromMail);
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send((message));
        System.out.println("Mail Sent");
    }
}
