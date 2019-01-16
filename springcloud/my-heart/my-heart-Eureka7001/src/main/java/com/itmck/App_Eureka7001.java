package com.itmck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class App_Eureka7001 {

	public static void main(String[] args) {
		SpringApplication.run(App_Eureka7001.class, args);
	}
}
