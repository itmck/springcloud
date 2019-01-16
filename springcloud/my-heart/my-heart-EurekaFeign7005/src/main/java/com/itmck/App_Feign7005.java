package com.itmck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringBootApplication
@EnableEurekaClient	
@EnableFeignClients //开启feign
public class App_Feign7005 {

	public static void main(String[] args) {
		SpringApplication.run(App_Feign7005.class, args);
	}
}
