package com.wellfound.service;

import com.wellfound.entity.User;

public interface UserService {

	public User addUser(User user);

	public User findUserById(Long id);

	public User findByName(String username);

}
