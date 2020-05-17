package com.vroomCar.Vroomcar.Exception;

public class NoRidePresentException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoRidePresentException()
	{
		super("No ride is there in List");
	}
}
