package com.globomatics.bike.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.globomatics.bike.models.Bike;
import com.globomatics.bike.repositories.BikeRepository;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController { //Spring MVC controller
	
	@Autowired //injecting the bikerepository into the controller 
	private BikeRepository bikeRepository;
	
	@GetMapping
	public List<Bike> list() { //List collection type in Java
		
		//List<Bike>bikes = new ArrayList<>(); //before injection
		//return bikes; //this API endpoint returns a list of bikes...before injection
	
		return bikeRepository.findAll(); //we didnt implement this, Spring Data JPA created this method for us 
	}
	
	@PostMapping //this create method will respond to a post to our base URL
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Bike bike) {
		bikeRepository.save(bike);
	}
	
	@GetMapping("/{id}")
	public Bike get(@PathVariable("id")long id) {
		//return new Bike();
		return bikeRepository.getOne(id);
	
	}
	
}
