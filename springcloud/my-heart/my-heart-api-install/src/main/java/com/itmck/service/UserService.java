package com.itmck.service;

import com.itmck.api.pojo.User;

public interface UserService {

	// 查询
	User getUser(Long id);

	// 添加
	int insertUser(User user);

	// 删除
	int deleteUser(Long id);

	// 更新
	int updateUser(User user);

}
