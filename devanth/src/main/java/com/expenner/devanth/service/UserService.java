package com.expenner.devanth.service;

import com.expenner.devanth.bean.RegisterUser;
import com.expenner.devanth.exception.UserAlreadyExist;
import com.expenner.devanth.model.User;

public interface UserService {

	User register(RegisterUser regUser) throws UserAlreadyExist;

}
