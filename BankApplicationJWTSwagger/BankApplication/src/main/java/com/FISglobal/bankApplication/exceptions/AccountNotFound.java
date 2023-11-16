package com.FISglobal.bankApplication.exceptions;

@SuppressWarnings("serial")
public class AccountNotFound extends Exception {
	
	// This exception shows up when account number does not match
	public AccountNotFound(String message) {
		super(message);
	}

}
