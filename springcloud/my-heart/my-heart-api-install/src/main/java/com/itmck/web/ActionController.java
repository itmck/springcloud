package com.itmck.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itmck.api.pojo.User;
import com.itmck.service.UserService;

@RestController
public class ActionController {

	@Autowired
	private UserService uservice;

	@RequestMapping(value = "getUser")
	public User getUser(Long id) {

		return uservice.getUser(id);

	}

	@RequestMapping(value = "deleteUser")
	public int deleteUser(Long id) {

		return uservice.deleteUser(id);

	}

	@RequestMapping(value = "updateUser")
	public int updateUser(User user) {

		return uservice.updateUser(user);

	}

	@RequestMapping(value = "insertUser")
	public int insertUser(User user) {

		return uservice.insertUser(user);

	}

}
