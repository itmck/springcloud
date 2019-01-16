package com.itmck.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ActionController {
	
	private static final String address="http://localhost:8001/login";

	@Autowired
	private RestTemplate restTemplate;

	
	@RequestMapping("/get/{name}/{password}")
	public String getTest(@PathVariable("name")String name,@PathVariable("password")String password) {

		return restTemplate.getForObject(address+"?name="+name+"&password="+password, java.lang.String.class);
	}

}
