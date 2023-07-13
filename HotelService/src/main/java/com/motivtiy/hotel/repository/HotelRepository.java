package com.motivtiy.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.motivtiy.hotel.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
