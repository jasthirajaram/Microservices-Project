package com.motivity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.motivity.model.Rating;

public interface RatingRepositoy extends JpaRepository<Rating, String> {

	List<Rating> findByUserId(String userId);
	
	List<Rating> findByHotelId(String hotelId);
	
}
