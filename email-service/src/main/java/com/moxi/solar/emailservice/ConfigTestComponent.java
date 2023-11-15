package com.moxi.solar.emailservice;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigTestComponent {
    @Value("${spring.mail.username}")
    private String configProperty;

    @Value("${spring.profiles.active}")
    private String configActive;

    @Value("${spring.cloud.config.uri}")
    private String configServerUri;

    @PostConstruct
    public void PostConstruct() {
        System.out.println("Loaded config property: " + configProperty);
        System.out.println("Remote config server uri: " + configServerUri);
        System.out.println("Active: " + configActive);
    }
}
