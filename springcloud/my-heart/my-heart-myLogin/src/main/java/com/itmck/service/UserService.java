package com.itmck.service;

import com.itmck.api.pojo.User;

public interface UserService {


	User checkLogin(String userName, String password);

}
