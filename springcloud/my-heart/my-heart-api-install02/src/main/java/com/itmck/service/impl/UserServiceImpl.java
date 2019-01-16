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
	public User getUser(Long id) {

		//这里使用的就是通用mapper里面的方法
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insertUser(User user) {
		
		return userMapper.insertUser(user);
	}

	@Override
	public int deleteUser(Long id) {

		return userMapper.deleteUser(id);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(user);
	}

}
