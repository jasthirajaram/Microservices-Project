package com.motivtiy.hotel.service;

import java.util.List;

import com.motivtiy.hotel.entities.Hotel;

public interface HotelService {

	Hotel createHotel(Hotel hotel);
	
	List<Hotel> getAll();
	
	Hotel getHotel(String id);
	
}
