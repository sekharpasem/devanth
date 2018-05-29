package com.expenner.devanth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenner.devanth.bean.RegisterUser;
import com.expenner.devanth.dao.UserDao;
import com.expenner.devanth.exception.UserAlreadyExist;
import com.expenner.devanth.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	@Override
	public User register(RegisterUser regUser) throws UserAlreadyExist {
		User user = null;
		if (regUser != null) {
			if (userDao.isAlreadyRegisterUser(regUser.getUsername()))
				throw new UserAlreadyExist("User already exists with username " + regUser.getUsername());
			else
				return registerUser(regUser);

		}
		return user;
	}

	private User registerUser(RegisterUser regUser) {
		User user = new User(regUser.getName(), regUser.getUsername(), regUser.getPassword());
		return userDao.save(user);
	}

}
