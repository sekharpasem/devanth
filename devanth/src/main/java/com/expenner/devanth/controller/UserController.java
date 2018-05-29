package com.expenner.devanth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenner.devanth.bean.Login;
import com.expenner.devanth.bean.RegisterUser;
import com.expenner.devanth.exception.UserAlreadyExist;
import com.expenner.devanth.model.User;
import com.expenner.devanth.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping
	public void register(RegisterUser regUser) throws UserAlreadyExist {
		if (regUser != null) {
			User user = userService.register(regUser);
		}
	}

	@PostMapping("/login")
	public void login(Login login) {
		if (login != null) {
			// User user = userService.authenticate(login);
		}
	}
}
