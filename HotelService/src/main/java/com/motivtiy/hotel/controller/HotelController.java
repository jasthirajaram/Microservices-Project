package com.motivtiy.hotel.controller;

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

import com.motivtiy.hotel.entities.Hotel;
import com.motivtiy.hotel.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/saveHotel")
	ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
		return new ResponseEntity<Hotel>(hotelService.createHotel(hotel), HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	ResponseEntity<List<Hotel>> getAll(){
		return new ResponseEntity<List<Hotel>>(hotelService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	ResponseEntity<Hotel> getById(@PathVariable String id){
		return new ResponseEntity<Hotel>(hotelService.getHotel(id), HttpStatus.OK);
	}

}
