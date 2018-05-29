package com.expenner.devanth.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.expenner.devanth.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByUsernameAndDeleted(String username, boolean deleted);

}
