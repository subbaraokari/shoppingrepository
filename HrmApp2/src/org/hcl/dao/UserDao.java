package org.hcl.dao;

import java.util.Optional;

import org.hcl.model.User;

public interface UserDao {
	public boolean insert(User user);
	public boolean validate(User user);
	public Optional<User> getUserByUserName(String userName);
}
