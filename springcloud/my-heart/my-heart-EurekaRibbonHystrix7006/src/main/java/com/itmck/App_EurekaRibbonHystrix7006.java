package com.itmck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker//启动断路器  对hystrixR熔断机制的支持   
public class App_EurekaRibbonHystrix7006 {

	public static void main(String[] args) {
		SpringApplication.run(App_EurekaRibbonHystrix7006.class, args);
	}

	@Bean
	@LoadBalanced // 开启负载均衡
	public RestTemplate getRestTemplate() {

		return new RestTemplate();
	}

	@RequestMapping(value = "hi")
	@HystrixCommand(fallbackMethod = "hiError")//一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
	public String sayHello() {
		System.out.println("hello");
		return getRestTemplate().getForObject("http://myheart/hi", String.class);
	}

	public String hiError() {
		return "sorry,error!";
	}

}
