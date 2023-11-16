package com.FISglobal.bankApplication.service;

import com.FISglobal.bankApplication.exceptions.AccountNotFound;
import com.FISglobal.bankApplication.exceptions.BalanceNotFound;
import com.FISglobal.bankApplication.exceptions.PasswordIncorrect;
import com.FISglobal.bankApplication.model.Account;
// interface class with abstract methods
public interface AccountService {
	public abstract String createAccount(Account account);

	public abstract boolean validate(long accNo, String password) throws AccountNotFound, PasswordIncorrect;

	public abstract Account deposit(long accNo, double amt) throws AccountNotFound;

	public abstract Account withdraw(long accNo, double amt) throws AccountNotFound, BalanceNotFound;

	public abstract String updatePassword(long accNo, String newPassword, String rePassword);

}
