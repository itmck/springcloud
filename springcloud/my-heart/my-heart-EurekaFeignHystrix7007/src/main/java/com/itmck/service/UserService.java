package com.itmck.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itmck.service.impl.UserServicehystrix;

/**
 * 	Feign是一个声明式的伪Http客户端，它使得写Http客户端变得更简单。
 * 	使用Feign，只需要创建一个接口并注解。
 * 	它具有可插拔的注解特性，可使用Feign 注解和JAX-RS注解。
 * 	Feign支持可插拔的编码器和解码器。Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。
 * 
 * @author 34745
 *
 */
@FeignClient(value = "myheart-f",fallback=UserServicehystrix.class)
public interface UserService {

	@RequestMapping(value = "/hi")
	String say();

}
