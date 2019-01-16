package com.itmck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class App_RestTemplate {

	public static void main(String[] args) {

		SpringApplication.run(App_RestTemplate.class, args);
	}
	
	/**
	 * 
	 * 	注入RestTemplate
	 * @return
	 */
	@Bean
	public  RestTemplate getRestTemplate() {
		
		return new RestTemplate();
	}
}
