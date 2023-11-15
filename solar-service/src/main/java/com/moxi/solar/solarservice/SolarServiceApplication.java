package com.moxi.solar.solarservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SolarServiceApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(SolarServiceApplication.class, args);
    }
}
