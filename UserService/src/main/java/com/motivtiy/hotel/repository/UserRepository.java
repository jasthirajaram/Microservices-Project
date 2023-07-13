package com.motivtiy.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.motivtiy.hotel.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

}
