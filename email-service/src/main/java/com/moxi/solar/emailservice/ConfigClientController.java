package com.moxi.solar.emailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moxi.solar.emailservice.config.ConfigInfoProperties;

@RequestMapping("configClient")
@RestController
public class ConfigClientController {
    @Autowired
    private ConfigInfoProperties configInfoProperties;

    @GetMapping("config")
    public String getConfig(){
        System.out.println("Client: " + configInfoProperties.getUsername());
        return configInfoProperties.getUsername();
    }
}
