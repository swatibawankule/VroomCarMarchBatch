package com.vroomCar.Vroomcar.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vroomCar.Vroomcar.Service.IRideService;
import com.vroomCar.Vroomcar.beans.Ride;
import com.vroomCar.Vroomcar.repository.RideBaseRepository;

@Service 
public class RideService implements IRideService{

	@Autowired
	
	RideBaseRepository rideBaseRepository;
	List <Ride> ride =new ArrayList<Ride>();
	
	@Override
	public List<Ride> getAllRides() {
		
		ride = (List<Ride>) rideBaseRepository.findAll();
		return ride;
	
	}
	@Override
	public Ride getRideById(long rideId) {
		// TODO Auto-generated method stub
		if(rideBaseRepository.existsById(rideId))
		{
		 Ride rideMatch = rideBaseRepository.findById(rideId).get();
		 return rideMatch;
		}
		 
		return null;
	}

	@Override
	public boolean addRide(Ride ride) {
		// TODO Auto-generated method stub
		if (rideBaseRepository.existsById(ride.getRideid()))
		{
			return false;
		}
		rideBaseRepository.save(ride);
		return true;
	}

	@Override
	public Ride updateRide(Ride ride) {
		// TODO Auto-generated method stub
		boolean flag;
		flag=rideBaseRepository.existsById(ride.getRideid());
		if(flag)
		{
			Ride UpdatedRide=rideBaseRepository.save(ride);
			return UpdatedRide;
		}
			return null;
	}

	@Override
	public boolean deleteRide(long rideId) {
		// TODO Auto-generated method stub
		if(rideBaseRepository.existsById(rideId))
		{
		Ride toDelete = rideBaseRepository.findById(rideId).get();
		rideBaseRepository.delete(toDelete);
		return true;
		}
		return false;
	}

	@Override
	public List<Ride> getByRideSourceAndDestination(String source, String destination) {
		// TODO Auto-generated method stub
		ride=rideBaseRepository.findBySourceAndDestination(source, destination);
		if(ride.isEmpty())
		{return null;
		}
		return ride;
	}

}
