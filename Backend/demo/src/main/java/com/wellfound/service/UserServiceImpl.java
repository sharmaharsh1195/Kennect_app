package com.wellfound.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellfound.Repository.UserRepository;
import com.wellfound.entity.User;


@Service
public class UserServiceImpl implements UserService{

	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		
		User localUser=userRepository.save(user);
		
		
		return localUser;
	}

	@Override
	public User findUserById(Long id) {
	    return userRepository.findById(id).orElse(null); // Provide a default value of null
	}

	@Override
	public User findByName(String username) {
		// TODO Auto-generated method stub
		
		return userRepository.findByname(username);
	}

}
