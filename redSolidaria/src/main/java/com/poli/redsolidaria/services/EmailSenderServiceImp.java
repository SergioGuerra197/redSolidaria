package com.poli.redsolidaria.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImp implements EmailServiceService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("$(redsolidaria.mailmaster)")
    private String fromMail;

    public void sendEmail(String toEmail, String subject, String body){
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setFrom(fromMail);
            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setText(body, true); // Configura el contenido del correo electrónico como HTML

            mailSender.send(mimeMessage);
            System.out.println("Correo electrónico enviado exitosamente.");
        } catch (MessagingException e) {
            System.err.println("Error al enviar el correo electrónico: " + e.getMessage());
        }
    }
}
