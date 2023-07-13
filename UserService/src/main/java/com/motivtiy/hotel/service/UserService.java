package com.motivtiy.hotel.service;

import java.util.List;

import com.motivtiy.hotel.entities.User;

public interface UserService {

	User saveUser(User user);
	
	List<User> getAllUsers();
	
	User getUser(String userId);
	
	User updateUser(String userId , User user);
	
	String deleteUser(String userId);
	
}
