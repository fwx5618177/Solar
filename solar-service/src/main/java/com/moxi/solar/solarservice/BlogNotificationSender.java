package com.moxi.solar.solarservice;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogNotificationSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendEmailNotification(String message) {
        rabbitTemplate.convertAndSend("blog.email.exchange", "blog.email.routingKey", message);
    }
}
