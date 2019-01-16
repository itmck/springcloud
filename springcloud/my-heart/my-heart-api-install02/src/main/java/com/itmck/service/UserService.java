package com.itmck.service;

import com.itmck.api.pojo.User;

public interface UserService {

	/**
	 * 
	 * @param id
	 * @return 返回查询的user对象
	 * 
	 */
	User getUser(Long id);

	/**
	 * 
	 * 
	 * @param user
	 * @return 添加成功返回数据
	 */
	int insertUser(User user);

	/**
	 * 
	 * 
	 * @param id
	 * @return 删除
	 */
	int deleteUser(Long id);

	/**
	 * 
	 * 
	 * @param user
	 * @return 更新
	 */
	int updateUser(User user);

}
