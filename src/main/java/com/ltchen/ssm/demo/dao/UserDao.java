package com.ltchen.ssm.demo.dao;

import java.util.List;

import com.ltchen.ssm.demo.bean.User;

public interface UserDao {
	
      List<User> selectAll();
      
      void insert(User user);
}

