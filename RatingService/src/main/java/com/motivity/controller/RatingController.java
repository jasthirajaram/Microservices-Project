package com.motivity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motivity.model.Rating;
import com.motivity.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/save")
	ResponseEntity<Rating> saveRating(@RequestBody Rating rating){
		return new ResponseEntity<Rating>(ratingService.createRating(rating), HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	ResponseEntity<List<Rating>> getAll(){
		return new ResponseEntity<List<Rating>>(ratingService.getRatings(), HttpStatus.OK);
	}
	
	@GetMapping("/getByUserId/{userId}")
	ResponseEntity<List<Rating>> getByUserId(@PathVariable String userId){
		return new ResponseEntity<List<Rating>>(ratingService.getByUserId(userId), HttpStatus.OK);
	}
	
	@GetMapping("/getByHotelId/{hotelId}")
	ResponseEntity<List<Rating>> getByHotelId(@PathVariable String hotelId){
		return new ResponseEntity<List<Rating>>(ratingService.getByHotelId(hotelId), HttpStatus.OK);
	}

}
