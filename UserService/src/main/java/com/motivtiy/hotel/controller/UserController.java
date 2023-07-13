package com.motivtiy.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motivtiy.hotel.entities.User;
import com.motivtiy.hotel.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/saveUser")
	ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<User>(service.saveUser(user), HttpStatus.OK);
	}
	
	@GetMapping("/getUsers")
	ResponseEntity<List<User>> getAll(){
		return new ResponseEntity<List<User>>(service.getAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/getUser/{userId}")
	ResponseEntity<User> getUserById(@PathVariable String userId){
		return new ResponseEntity<User>(service.getUser(userId), HttpStatus.OK);
	}
	
	@PutMapping("/update/{userId}")
	ResponseEntity<User> updatUser(@PathVariable String userId,@RequestBody User user){
		return new ResponseEntity<User>(service.updateUser(userId, user), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{userID}")
	ResponseEntity<String> deleteById(@PathVariable String userID){
		return new ResponseEntity<String>(service.deleteUser(userID), HttpStatus.OK);
	}
}
