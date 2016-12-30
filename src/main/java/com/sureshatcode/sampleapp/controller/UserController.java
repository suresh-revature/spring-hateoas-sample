package com.sureshatcode.sampleapp.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sureshatcode.sampleapp.model.User;
import com.sureshatcode.sampleapp.service.UserService;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "Application started running";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public HttpEntity<List<User>> getUsers() {
		List<User> users = null;
		try {
			users = userService.doGetUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public HttpEntity<User> getUserByUserId(@RequestParam(value = "userId", required = false) Long userId) {
		User user = null;
		try {
			if (userId != null) {
				user = userService.doGetUserByUserId(userId);
				if (user != null) {
					user.add(linkTo(methodOn(UserController.class).getUserByUserId(userId)).withSelfRel());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}