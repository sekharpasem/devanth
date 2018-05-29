package com.expenner.devanth.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.expenner.devanth.model.User;
import com.expenner.devanth.repo.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	UserRepository userRepository;

	@Override
	public boolean isAlreadyRegisterUser(String username) {
		if (username != null) {
			User user = userRepository.findByUsernameAndDeleted(username, false);
			if (user != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public User save(User user) {
		if (user != null) {
			return userRepository.save(user);
		}
		return null;
	}

}
