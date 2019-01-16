package com.itmck.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.itmck.api.pojo.User;

@Mapper
public interface UserMapper {
	/**
	 * login
	 * @param username
	 * @param password
	 * @return
	 */
	User checkLogin(@Param("userName") String userName, @Param("password") String password);
}