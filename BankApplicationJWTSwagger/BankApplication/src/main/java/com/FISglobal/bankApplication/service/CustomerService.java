//name of pkg
package com.FISglobal.bankApplication.service;
//importing files
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FISglobal.bankApplication.exceptions.AccountNotFound;
import com.FISglobal.bankApplication.exceptions.PasswordIncorrect;
import com.FISglobal.bankApplication.model.Customer;
import com.FISglobal.bankApplication.repo.CustomerRepo;
//interface class with abstract methods
public interface CustomerService {

	public abstract String createUser(Customer customer);

	public abstract boolean Login(String email, String password) throws AccountNotFound, PasswordIncorrect;
	
	public abstract String deleteUser(int id, String password)  throws PasswordIncorrect;

	public abstract String updateUser(Customer customer);
}

@Service
@Transactional
