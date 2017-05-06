package com.ltchen.ssm.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ltchen.ssm.demo.bean.User;
import com.ltchen.ssm.demo.dao.UserDao;
import com.ltchen.ssm.demo.service.UserService;

@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> userList() {
		return userDao.selectAll();
	}

	@Override
	public void addUser(User user) {
		userDao.insert(user);
	}
}
