package com.motivtiy.hotel.feignUtil;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.motivtiy.hotel.entities.Hotel;

@FeignClient(name = "HOTEL-SERVICE/hotel")
public interface FeignUtilForHotel {
	
	@GetMapping("/get/{id}")
	Hotel getById(@PathVariable String id);
	
	

}
