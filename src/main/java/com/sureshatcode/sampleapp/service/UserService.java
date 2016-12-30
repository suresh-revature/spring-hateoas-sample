package com.sureshatcode.sampleapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sureshatcode.sampleapp.dao.UserDao;
import com.sureshatcode.sampleapp.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public List<User> doGetUsers() {
		List<User> user = null;
		try {
			user = userDao.getUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public User doGetUserByUserId(Long userId) {
		User user = null;
		try {
			user = userDao.getUserByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
