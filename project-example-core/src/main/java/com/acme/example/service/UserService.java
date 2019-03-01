package com.acme.example.service;

import java.util.List;

import com.acme.example.entity.User;

public interface UserService {

	 List<User> findAllUsers();
	 
	 User findUser(Long id);
	
	 void saveUser(User user);
	 
	 void updateUser(User user);
	 
	 void deleteUser(User user);
	 
}
