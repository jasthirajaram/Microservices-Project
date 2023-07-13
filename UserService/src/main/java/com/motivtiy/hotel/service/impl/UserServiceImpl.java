package com.motivtiy.hotel.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motivtiy.hotel.entities.Hotel;
import com.motivtiy.hotel.entities.Rating;
import com.motivtiy.hotel.entities.User;
import com.motivtiy.hotel.exception.UserNotFoundException;
import com.motivtiy.hotel.feignUtil.FeignUtilForHotel;
import com.motivtiy.hotel.feignUtil.FiegnUtilForRatings;
import com.motivtiy.hotel.repository.UserRepository;
import com.motivtiy.hotel.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FiegnUtilForRatings fiegnUtilForRatings;
	
	@Autowired
	private FeignUtilForHotel feignUtilForHotel;

	@Override
	public User saveUser(User user) {
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = userRepository.findAll();
		for (User user : users) {
			List<Rating> ratings =  fiegnUtilForRatings.getByUserId(user.getUserId());
			for (Rating ratingList : ratings) {
				Hotel hotel = feignUtilForHotel.getById(ratingList.getHotelId());
				ratingList.setHotel(hotel);
			}
			user.setRatings(ratings);
		}
		return users;
	}

	@Override
	public User getUser(String userId) {
		User user =  userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException());
		List<Rating> ratings =  fiegnUtilForRatings.getByUserId(userId);
		for (Rating rating : ratings) {
			Hotel hotel = feignUtilForHotel.getById(rating.getHotelId());
			rating.setHotel(hotel);
		}
		user.setRatings(ratings);
		return user;
	}

	@Override
	public User updateUser(String userId, User user) {
		User user2 = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException());
		user2.setName(user.getName());
		user2.setEmail(user.getEmail());
		user2.setAbout(user.getAbout());
		return userRepository.save(user2);
	}

	@Override
	public String deleteUser(String userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException());
		userRepository.deleteById(userId);
		return "successfully deleted";
	}

}
