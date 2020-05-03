package com.vroomcar.VroomCar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vroomcar.VroomCar.beans.Ride;

import come.vroomcar.VroomCar.service.IRideService;


@RestController
@RequestMapping("Rest/VroomCar")
public class RideController {

	@Autowired
	IRideService rideService;
	
	
	@GetMapping(value ="/allRides", produces= { MediaType.APPLICATION_JSON_VALUE })
//	public ResponseEntity<List<Ride>> findAll(){
	public ResponseEntity<List<Ride>> findAll(){
		
		List<Ride>	list= rideService.getAllRides();
		
		

//		
		return new ResponseEntity<List<Ride>>(list, HttpStatus.CREATED);
//		
	}
}
