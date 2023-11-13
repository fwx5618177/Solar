package com.moxi.solar.solarservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SolarServiceApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(SolarServiceApplication.class, args);
    }
}
