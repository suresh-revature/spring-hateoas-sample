package com.sureshatcode.sampleapp.dao;

import java.util.List;

import com.sureshatcode.sampleapp.model.User;

public interface UserDao {
	public List<User> getUsers();

	public User getUserByUserId(Long userId);

	public User saveUser(User user);

	public User updateUser(User user);

	public Boolean deleteUserByUserId(Long userId);
}
