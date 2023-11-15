package com.moxi.solar.emailservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;


@ConfigurationProperties(prefix = "some.fwx")
@RefreshScope
@Configuration
public class ConfigInfoProperties { 
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
