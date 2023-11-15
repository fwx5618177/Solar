package com.moxi.solar.emailservice.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.moxi.solar.emailservice.model.EmailDetails;
import com.moxi.solar.emailservice.service.EmailService;

@Component
public class EmailMessageListener {
    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "blog.email.queue")
    public void receiveMessage(String emailMessage) {
        String[] parts = emailMessage.split(":");

        if (parts.length == 3) {
            EmailDetails details = new EmailDetails();

            details.setRecipient(parts[0]);
            details.setSubject(parts[1]);
            details.setBody(parts[2]);

            emailService.sendEmail(details);
        }
    }
}
