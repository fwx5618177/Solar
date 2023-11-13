package com.moxi.solar.emailservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moxi.solar.emailservice.model.EmailDetails;
import com.moxi.solar.emailservice.service.EmailService;

@RestController
@RequestMapping("/api/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(EmailDetails details) {
        emailService.sendEmail(details);

        return ResponseEntity.ok("Email sent successfully!");
    }
}
