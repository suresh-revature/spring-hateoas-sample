package com.sureshatcode.sampleapp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sureshatcode.sampleapp.dao.UserDao;
import com.sureshatcode.sampleapp.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		List<User> users = null;
		try {
			users = getSession().createQuery("from User").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByUserId(Long userId) {
		List<User> users = null;
		try {
			Query query = getSession().createQuery("from User as u where u.id=:userId");
			query.setParameter("userId", userId);
			users = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users.get(0);
	}

	@Override
	public User saveUser(User user) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User updateUser(User user) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Boolean deleteUserByUserId(Long userId) {
		Boolean isDeleted = false;
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
