package com.microsvs.user.excepetion;

public class UserAlreadyExists extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyExists(String message) {
		super(message);

	}

}
