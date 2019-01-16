package com.itmck.api.commons;

import java.io.Serializable;

/**
 * 	
 * 		继承此类增删改查Mapper接口不用写,只需写对应mapper.xml
 * 
 * @author 34745
 * @param <E> 实体类类型 如  User
 * @param <PK> 主键类型 如:  Long  int  
 */
public interface BaseMapper<E,PK extends Serializable> {

	/**
	* 根据id获取对象
	* @param id 对象id
	* @return Object  返回对象
	*/
	E selectByPrimaryKey(PK id);

	/**
	* 根据id删除对象
	* @param id 对象id
	*
	*/
	Integer deleteByPrimaryKey(PK id);

	/**
	* 保存对象所有信息
	* @param entity 对象实体类
	*
	*/
	Integer insert(E entity);
	
	/**
	* 只保存对象不为空信息
	* @param entity 对象实体类
	*
	*/
	Integer insertSelective(E entity);

	/**
	* 更新对象信息且只更新不为空的属性
	* @param entity 实体类
	*
	*/
	Integer updateByPrimaryKeySelective(E entity);
	
	/**
	 * 更新对象所有属性
	 * @param entity
	 * @return
	 */
	Integer updateByPrimaryKey(E entity);
	
}
