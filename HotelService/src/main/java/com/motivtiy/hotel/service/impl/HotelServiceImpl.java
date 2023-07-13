package com.motivtiy.hotel.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motivtiy.hotel.entities.Hotel;
import com.motivtiy.hotel.exception.HotelNotFoundException;
import com.motivtiy.hotel.repository.HotelRepository;
import com.motivtiy.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository  repository;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		String id = UUID.randomUUID().toString();
		hotel.setId(id);
		return repository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return repository.findAll();
	}

	@Override
	public Hotel getHotel(String id) {
		return repository.findById(id).orElseThrow(() ->  new HotelNotFoundException());	
	}

}
