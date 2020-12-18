package org.hcl.services;

import java.util.Optional;

import org.hcl.model.User;

public interface UserService {
	boolean register(User user);
	boolean validate(User user);
	Optional<User> getUserByUserName(String userName);
}
