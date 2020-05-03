/**
 * 
 */
package com.vroomcar.VroomCar.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vroomcar.VroomCar.beans.Ride;

import come.vroomcar.VroomCar.service.IRideService;

/**
 * @author swatibawankule
 * Service class to implement Ride related logics
 *
 */
@Component
public class RideService implements IRideService{
	
	ArrayList<Ride> rideList = new ArrayList<Ride>();
	

	
	

	@Override
	public List<Ride> getAllRides() {
		// TODO Auto-generated method stub
		Ride ride1 =  new Ride(1, 27, "swati", "Pune", "Mumbai", 1);
		Ride ride2 =  new Ride(1, 22, "Neha", "Mumbai", "pune", 1);
		rideList.add(ride1);
		rideList.add(ride2);
		
		return rideList;
		
		
	}

	@Override
	public Ride getRideById(long rideId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addRide(Ride ride) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateRide(Ride ride) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRide(int rideId) {
		// TODO Auto-generated method stub
		
	}


}
