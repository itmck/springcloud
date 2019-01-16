package com.itmck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class App_Ribbon7004 {

	public static void main(String[] args) {
		SpringApplication.run(App_Ribbon7004.class, args);
	}

	/**
	 * 
	 * 	注入RestTemplate模板 
	 * 	微服务:根据业务拆分成一个个小的系统,然而在使用过程中,我们可能根据需要将单个小服务进行集群部署,来保证高可用.这时就可以使用这种方法
	 * 
	 * @return
	 */
	@Bean
	@LoadBalanced//开启负载均衡
	public RestTemplate restTemplate() {

		return new RestTemplate();
	}
	
	@RequestMapping(value = "hi")
	public String sayHello() {
		System.out.println("hello");
		return restTemplate().getForObject("http://myheart/hi", String.class);
	}

}
