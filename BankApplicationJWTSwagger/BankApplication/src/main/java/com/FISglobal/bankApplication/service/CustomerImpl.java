package com.FISglobal.bankApplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.FISglobal.bankApplication.exceptions.AccountNotFound;
import com.FISglobal.bankApplication.exceptions.PasswordIncorrect;
import com.FISglobal.bankApplication.model.Customer;
import com.FISglobal.bankApplication.repo.CustomerRepo;

public class CustomerImpl implements CustomerService {

	@Autowired
	CustomerRepo dao;

	//This function calls save method to create customer
	@Override
	public String createUser(Customer customer) {
		dao.save(customer);
		return "Customer Saved Sucessfully";
	}

	
	//This function will validate customer by email and password
	@Override
	public boolean Login(String email, String password) throws AccountNotFound, PasswordIncorrect {
		Optional<Customer> cus= dao.findByEmail(email);
		if(cus.isEmpty())
			throw new AccountNotFound("Customer Account not Found");
		else if(!cus.get().getPassword().equals(password))
			throw new PasswordIncorrect("Password Incorrect");
			
		else 
			return true;
	}
// this func will delete user
	
	@Override
	public String deleteUser(int id, String password)  throws PasswordIncorrect {
		if(dao.deleteUser(id, password) ==0) {
			throw new PasswordIncorrect("Incorrect pass ");
		};
		return "Customer Deleted Successfully";
	}
// this func will update user
	@Override
	public String updateUser(Customer customer) {
		dao.save(customer);
		return "Customer Updated Succesfully";
	}
	
	
}

