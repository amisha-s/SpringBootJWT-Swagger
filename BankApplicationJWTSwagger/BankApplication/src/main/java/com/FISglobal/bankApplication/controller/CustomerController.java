//name of package
package com.FISglobal.bankApplication.controller;
//importing 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FISglobal.bankApplication.exceptions.AccountNotFound;
import com.FISglobal.bankApplication.exceptions.PasswordIncorrect;
import com.FISglobal.bankApplication.model.Customer;
import com.FISglobal.bankApplication.service.CustomerService;


//class
@RestController
@RequestMapping("/HomePage")
public class CustomerController {
	@Autowired
	CustomerService service;
// for registering
	@PostMapping("/Register") 
	public String register(@RequestBody Customer customer) {
		return service.createUser(customer);
	}
// for login
	@GetMapping("/Log/{email}/{password}") 
	public String Log(@PathVariable("email") String email, @PathVariable("password") String password) {
		try {
			service.Login(email, password);
			return "redirect:/CustomerAccount";
		} catch (AccountNotFound | PasswordIncorrect e) {
			System.out.println("Exception Found " + e );
		}
		return "redirect:/Register";

	}
	// for updating details
	@PutMapping("/UpdateCustomer")
	public String customer(@RequestBody Customer customer) {
		return service.updateUser(customer);
	}

	// delete account
	@DeleteMapping("/DeleteAccount/{id}/{password}") 
	public String Delete(@PathVariable("id") int id, @PathVariable("password") String password) {
		try{
			return service.deleteUser(id, password);		
		}catch(PasswordIncorrect p) {
			return "Incorrect Password";
		}
	}

}
