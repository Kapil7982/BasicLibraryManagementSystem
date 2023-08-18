package com.library.service;

import com.library.models.User;

public interface UserService {

	public User createUser(User user); 
	
	public User getUserById(Long userId);
}
