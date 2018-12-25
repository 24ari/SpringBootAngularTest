package com.globomatics.bike.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globomatics.bike.models.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long> { //Bike entity and Long bc that's the type of our key
	
}
