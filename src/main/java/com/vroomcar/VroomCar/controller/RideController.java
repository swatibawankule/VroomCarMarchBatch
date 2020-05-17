package com.vroomCar.Vroomcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vroomCar.Vroomcar.Exception.ConflictException;
//import com.vroomCar.Vroomcar.Exception.ConstraintViolationException;
import com.vroomCar.Vroomcar.Exception.CustomErrorResponse;
import com.vroomCar.Vroomcar.Exception.NoRidePresentException;
import com.vroomCar.Vroomcar.Exception.RideNotPresentException;

import com.vroomCar.Vroomcar.Service.IRideService;
import com.vroomCar.Vroomcar.beans.Ride;
import com.vroomCar.Vroomcar.beans.SmsApi;
import com.vroomCar.Vroomcar.serviceImpl.RideService;
@Validated
@RestController 
@RequestMapping("Rest/VroomCar") //Root for every Request
public class RideController {
	@Autowired
	IRideService rideService ;
	@GetMapping (value ="/allRides", produces= { MediaType.APPLICATION_JSON_VALUE })
	
	public ResponseEntity<List<Ride>> getRideDetail() {
		//method written to get all rides
		
		List<Ride> ride=rideService.getAllRides();
		if (ride.isEmpty())
		{
			throw new  NoRidePresentException();
		}
		
		return  new ResponseEntity<List<Ride>>(ride,HttpStatus.FOUND) ;
	}
	
	@GetMapping (value="/Rides/{id}")
	public ResponseEntity<Ride> findRideByRideId( @PathVariable("id") @Min(value=5,message="should be greater than 5")
	@Max (value=101,message ="it should be less than 100") Long rideId) throws Exception{
		//Method written to find rides depending on rideid

		Ride ride = rideService.getRideById(rideId);

		if(ride == null)
		{
		//give user generic message by handelling exception
			throw new RideNotPresentException();

		}
		return new ResponseEntity <Ride> (ride,HttpStatus.FOUND) ;

		}
	@GetMapping (value="/RidesSearch/{sourceP}/{destinationP}")
	public ResponseEntity <List<Ride>> findRideByRideSourceAndDestination(@PathVariable("sourceP")
	@NotEmpty(message ="Source must be filled")  String source, @PathVariable("destinationP") 
	@NotEmpty(message ="Dest must be filled")String destination) throws Exception{
		//Method written to find rides between source and destination
		List<Ride>ride = rideService.getByRideSourceAndDestination(source,destination);
		/*if((destination == null) || (source == null) || (source == "") || (destination =="") )
		{
			throw new ConstraintViolationException();
		}*/
		
		
		if(ride == null) {
			//give user generic message by handelling exception
			throw new RideNotPresentException();

		}
		return new ResponseEntity <List<Ride>> (ride,HttpStatus.FOUND) ;
		}
	
	@PostMapping(value ="/loadRide" ,produces= { MediaType.APPLICATION_JSON_VALUE }) 
	  public ResponseEntity<Ride> load( @Valid @RequestBody Ride ride ) {
		 boolean flag =false;
		 
		//validate Ride Object if Req contains null values then return 400 bad request.
			
	   flag = rideService.addRide(ride);
		
			/*catch (TransactionSystemException e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("Transaction");
				System.out.println(e);
				throw new TransactionSystemException();
			}*/
			/*catch(Exception t) {
				t.printStackTrace();
				System.out.println("exception");
				return new ResponseEntity<Ride>(ride,HttpStatus.INTERNAL_SERVER_ERROR);
			}*/
		

	  if (flag == false) {
		//give user generic message by handelling exception
    throw new ConflictException();
		
}			  
return new ResponseEntity<Ride>(ride,HttpStatus.CREATED);
	   
	}
	
	@PutMapping(value="/UpdateRide",produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Ride> updateRide(@Valid @RequestBody Ride ride){
		//method to update parameter in existing ride
		Ride rideUpdated=rideService.updateRide(ride);
		if(rideUpdated == null) {
			//give user generic message by handelling exception
			throw new RideNotPresentException();
		}
		return new ResponseEntity<Ride>(HttpStatus.OK);
	}

	
	@DeleteMapping(value ="/Rides/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Ride> deleteRideByRideId( @PathVariable("id") long rideId){
		//method to delete ride depending on rideid
		boolean flag;
		flag = rideService.deleteRide(rideId);
	if (flag)
	{
		
		return new ResponseEntity<Ride>(HttpStatus.OK);

		
	}
	//give user generic message by handelling exception
	throw new RideNotPresentException();
	}
	
	@GetMapping(value="/sendingSms/{mobileNumber}" , produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<CustomErrorResponse> sendSmsToMobileNumber(@PathVariable("mobileNumber")
	@Pattern(regexp = "^((\\+){1}91){1}[1-9]{1}[0-9]{9}$" ,message="should start with 91 and 10 digit should be there")String MobileNumber)
	{
		//consumed 3rd party api for sending sms
		//also used custom validation on mobile number
		SmsApi smsApi= new SmsApi();
		smsApi.senSMS(MobileNumber);
		return new ResponseEntity<CustomErrorResponse>(HttpStatus.OK);
		
	}

}
