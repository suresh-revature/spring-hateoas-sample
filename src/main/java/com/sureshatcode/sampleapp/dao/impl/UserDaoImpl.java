package com.sureshatcode.sampleapp.dao.impl;

import java.util.List;

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
	public List<User> getUserData() {
		List<User> users = null;
		try {
			users = getSession().createQuery("from User").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
}
