package com.fis.bankingapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.FISglobal.bankApplication.exceptions.*;
import com.FISglobal.bankApplication.model.Customer;
import com.FISglobal.bankApplication.service.CustomerService;

@SpringBootTest
class CustomerTests {
	
	@Autowired
	CustomerService service;
	
	@Test
	public void testcreateUser() {
		Customer cus = new Customer(123, "Kriti", 9915199799l, "x@gmail.com", 233423432342l, LocalDate.ofYearDay(2002, 12) ,(short)21, "pune", "pune", "xyz123");
		String msg = service.createUser(cus);
		assertEquals("Customer Saved Sucessfully", msg);
	}
	
	@Test
	public void testLogin() {
		//Optional<Customer> op = null;
		//Mockito.doReturn(op).when(repo).findByEmail("x@gmail.com");
		Boolean flag= null;
		try {
			flag = service.Login("x@gmail.com", "xyz123");
		} catch (AccountNotFound | PasswordIncorrect e) {
			flag = false;
		}
		assertEquals(true, flag);
		
	}
	
	
	@Test
	public void testdeleteUser() {
		String msg = null;
		try{
			msg = service.deleteUser(123, "xyz123");
			assertEquals("Customer Deleted Successfully", msg);
		}catch(PasswordIncorrect e) {
			assertEquals(null, msg);
		}
		
	}
	
	@Test
	public void testupdateUser() {
		Customer cus = new Customer(123, "Kriti", 9915199799l, "x@gmail.com", 233423432342l, LocalDate.ofYearDay(2002, 12) ,(short)21, "pune", "pune", "xyz123");
		String msg = service.updateUser(cus);
		assertEquals("Customer Updated Succesfully", msg);
	}
	
}
