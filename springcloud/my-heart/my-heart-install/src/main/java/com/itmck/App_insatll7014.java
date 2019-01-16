package com.itmck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itmck.api.pojo.User;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class App_insatll7014 {

	public static void main(String[] args) {

		SpringApplication.run(App_insatll7014.class, args);
	}

	@RequestMapping("ins")
	public User getMsg() {

		User user = new User();
		user.setUsername("mck");

		return user;
	}
}
