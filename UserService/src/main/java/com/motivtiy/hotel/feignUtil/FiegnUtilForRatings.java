package com.motivtiy.hotel.feignUtil;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.motivtiy.hotel.entities.Rating;


@FeignClient(name = "RATING-SERVICE/rating")
public interface FiegnUtilForRatings {
	
	@GetMapping("/getByUserId/{userId}")
	List<Rating> getByUserId(@PathVariable String userId);

}
