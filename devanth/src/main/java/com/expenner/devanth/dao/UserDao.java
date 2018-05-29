package com.expenner.devanth.dao;

import com.expenner.devanth.model.User;

public interface UserDao {

	boolean isAlreadyRegisterUser(String username);

	User save(User user);

}
