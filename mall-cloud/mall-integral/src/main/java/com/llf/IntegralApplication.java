package com.llf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class IntegralApplication
{
    public static void main( String[] args )
    {
    	SpringApplication.run(IntegralApplication.class, args);
    	
    	log.info("\n IntegralApplication 启动成功");
    }
}
