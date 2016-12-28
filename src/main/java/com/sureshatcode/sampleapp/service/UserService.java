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

	public List<User> doGetUserData() {
		List<User> user = null;
		try {
			user = userDao.getUserData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
