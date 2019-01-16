package com.itmck.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itmck.service.UserService;

@RestController
public class ActionController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/hi")
	public String say() {

		return userService.say();
	}
}
