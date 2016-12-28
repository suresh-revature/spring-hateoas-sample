package com.sureshatcode.sampleapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sureshatcode.sampleapp.model.User;
import com.sureshatcode.sampleapp.service.UserService;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/")
	public String index() {
		return "Application started running";
	}

	@GetMapping(value = "/getuser")
	public HttpEntity<List<User>> getUserData() {
		List<User> users = null;
		try {
			users = userService.doGetUserData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
}