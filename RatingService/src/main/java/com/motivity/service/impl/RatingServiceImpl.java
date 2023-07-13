package com.motivity.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motivity.model.Rating;
import com.motivity.repository.RatingRepositoy;
import com.motivity.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepositoy ratingRepositoy; 
	
	@Override
	public Rating createRating(Rating rating) {
		String ratingId = UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		return ratingRepositoy.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		return ratingRepositoy.findAll();
	}

	@Override
	public List<Rating> getByUserId(String userId) {
		return ratingRepositoy.findByUserId(userId);
	}

	@Override
	public List<Rating> getByHotelId(String hotelId) {
		return ratingRepositoy.findByHotelId(hotelId);
	}

}
