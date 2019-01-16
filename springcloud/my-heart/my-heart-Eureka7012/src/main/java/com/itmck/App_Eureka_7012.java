package com.itmck;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class App_Eureka_7012 {

	public static void main(String[] args) {
		SpringApplication.run(App_Eureka_7012.class, args);
	}
	
	@Value("${server.port}")
	String port;
	@Value("${eureka.instance.instance-id}")
	String name;

	@RequestMapping("hi")
	public String sayHello() {

		return "my instance name is: " + name + " my port is :" + port;
	}
}
