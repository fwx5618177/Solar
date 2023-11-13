package com.moxi.solar.emailservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.moxi.solar.emailservice.model.EmailDetails;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.from}")
    private String fromAddress;

    public void sendEmail(EmailDetails details) {
        // 这里是发送邮件的逻辑
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(fromAddress);
        message.setTo(details.getRecipient());
        message.setSubject(details.getSubject());
        message.setText(details.getBody());
        mailSender.send(message);
    }
}
