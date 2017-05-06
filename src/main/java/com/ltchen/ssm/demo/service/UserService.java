package com.ltchen.ssm.demo.service;

import java.util.List;

import com.ltchen.ssm.demo.bean.User;

public interface UserService {
	
      List<User> userList();
      
      void addUser(User user);
}

