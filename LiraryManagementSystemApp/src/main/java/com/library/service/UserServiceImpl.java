package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.models.User;
import com.library.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long userId) {
		
		return userRepository.findById(userId).orElse(null);
	}

}
