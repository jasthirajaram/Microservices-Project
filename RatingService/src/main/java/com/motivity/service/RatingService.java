package com.motivity.service;

import java.util.List;

import com.motivity.model.Rating;

public interface RatingService {

	Rating createRating(Rating rating);
	
	List<Rating> getRatings();
	
	List<Rating> getByUserId(String userId);
	
	List<Rating> getByHotelId(String hotelId);
	
}
