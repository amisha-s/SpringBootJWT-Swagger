package com.FISglobal.bankApplication.service;

import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FISglobal.bankApplication.exceptions.AccountNotFound;
import com.FISglobal.bankApplication.exceptions.BalanceNotFound;
import com.FISglobal.bankApplication.exceptions.PasswordIncorrect;
import com.FISglobal.bankApplication.model.Account;
import com.FISglobal.bankApplication.repo.AccountRepo;

//This is used to call AccountRepo.


@Service
@Transactional
public class AccountImpl implements AccountService {

	@Autowired
	AccountRepo dao;

	//This function calls save method to create account
	@Override
	public String createAccount(Account account) {
		dao.save(account);
		return "Account Created Sucessfully";
	}
	
	//This fucntion uses find by Id to validate the Account.

	@Override
	public boolean validate(long accNo, String password) throws AccountNotFound, PasswordIncorrect {
		Optional<Account> acc = dao.findById(accNo);
		if (acc.isEmpty())
			throw new AccountNotFound("Account not Found");
		else if (!acc.get().getPassword().equals(password))
			throw new PasswordIncorrect("Password Incorrect");

		else
			return true;
	}

	//This method will deposit the said amount into account.
	@Override
	public Account deposit(long accNo, double amt) throws AccountNotFound {
		dao.deposit(accNo, amt);
		return(dao.findByAccNo(accNo));
	}
	
	
	
// This method will withdraw the amount from Account if it is less than equal to balance
	@Override
	public Account withdraw(long accNo, double amt) throws AccountNotFound, BalanceNotFound {
		Account acc = dao.findByAccNo(accNo);
		if(acc== null)
			throw new AccountNotFound("No Account !!!");
		if(acc.getBalance()<amt)
			throw new BalanceNotFound("Low Balance !!!");
		dao.withdraw(accNo, amt);
		return(dao.findByAccNo(accNo));
	}

	//Update the Account Password
	@Override
	public String updatePassword(long accNo, String newPassword, String rePassword) {
		if (newPassword.equals(rePassword)) {
			dao.updatePassword(accNo, newPassword);
			return "Password Updated Succesfully";
		}

		else
			return "Does not match";

	}

}
