package com.vroomCar.Vroomcar.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.vroomCar.Vroomcar.beans.Ride;


@Component
public interface IRideService {
	 List<Ride> getAllRides();
     Ride getRideById(long rideId);
     boolean addRide(Ride ride);
     Ride updateRide(Ride ride);
     boolean deleteRide(long rideId);
     List<Ride> getByRideSourceAndDestination(String source,String destination);
	
}
