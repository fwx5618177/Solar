package com.moxi.solar.emailservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue queue() {
        return new Queue("email_queue", false);
    }

    // 这里可以根据需要添加交换机和绑定
}
