package com.itmck.service.impl;

import org.springframework.stereotype.Component;

import com.itmck.service.UserService;

@Component
public class UserServicehystrix implements UserService {

	@Override
	public String say() {
		return "sorry";
	}

}
