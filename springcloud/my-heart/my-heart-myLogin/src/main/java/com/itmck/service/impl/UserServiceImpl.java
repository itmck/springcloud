package com.itmck.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itmck.api.pojo.User;
import com.itmck.dao.UserMapper;
import com.itmck.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User checkLogin(String userName, String password) {
		
		return userMapper.checkLogin(userName,password);
	}

}
