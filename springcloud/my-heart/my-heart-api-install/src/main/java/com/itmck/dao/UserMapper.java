package com.itmck.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itmck.api.pojo.User;

@Mapper
public interface UserMapper {

	@Select("select * from tb_user where id=#{id}")
	User getUser(Long id);

	@Insert("insert into tb_user (username,password,role) values(#{username},#{password},#{role}) ")
	int insertUser(User user);

	@Delete("delete from tb_user where id=#{id}")
	int deleteUser(Long id);

	@Update("update tb_user set username=#{username},password=#{password},role=#{role} where id=#{id} ")
	int updateUser(User user);

}
