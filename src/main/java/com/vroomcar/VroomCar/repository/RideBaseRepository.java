package com.vroomCar.Vroomcar.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.vroomCar.Vroomcar.beans.Ride;

@org.springframework.stereotype.Repository
public interface RideBaseRepository 
extends CrudRepository<Ride ,Long > {
	
List <Ride> findBySourceAndDestination(String source,String destination);
}
