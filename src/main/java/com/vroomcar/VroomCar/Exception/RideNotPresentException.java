package com.vroomCar.Vroomcar.Exception;

public class RideNotPresentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  RideNotPresentException() {
		super("Ride Not Present");
	}
}
