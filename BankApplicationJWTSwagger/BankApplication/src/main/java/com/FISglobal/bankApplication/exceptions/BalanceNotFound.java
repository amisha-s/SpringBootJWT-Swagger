package com.FISglobal.bankApplication.exceptions;

@SuppressWarnings("serial")
// exception shows balance not found
public class BalanceNotFound extends RuntimeException {
	
	public BalanceNotFound(String message) {
		super(message);
	}

}
