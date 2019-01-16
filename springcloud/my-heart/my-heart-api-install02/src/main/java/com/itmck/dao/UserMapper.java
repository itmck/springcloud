package com.itmck.dao;

import org.apache.ibatis.annotations.Mapper;

import com.itmck.api.commons.BaseMapper;
import com.itmck.api.pojo.User;

@Mapper
public interface UserMapper extends BaseMapper<User, Long> {

	int insertUser(User user);

	int deleteUser(Long id);

	int updateUser(User user);

}
