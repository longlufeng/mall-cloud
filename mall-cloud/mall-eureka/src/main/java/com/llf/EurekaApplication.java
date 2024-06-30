package com.llf;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.net.UnknownHostException;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaServer //标明是一个server
public class EurekaApplication {
	static Logger log = LoggerFactory.getLogger("EurekaApplication.class");

    public static void main(String[] args) throws UnknownHostException {
    	SpringApplication.run(EurekaApplication.class, args);
    	 
        System.out.println("---服务监控访问地址"+"http://localhost:8761");
    }

}