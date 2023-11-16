package com.FISglobal.bankApplication.exceptions;

@SuppressWarnings("serial")
public class PasswordIncorrect extends RuntimeException {
	// this exception comes when password is incorrect 
	public PasswordIncorrect(String message) {
		super(message);
	}

}
