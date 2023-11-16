package com.fis.bankingapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;




import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.FISglobal.bankApplication.exceptions.*;
import com.FISglobal.bankApplication.model.Account;
import com.FISglobal.bankApplication.service.AccountService;

@SpringBootTest
class AccountTests {
	
	@Autowired
	AccountService service;
	
	@Test	
	public void testCreateAccount() {
		Account acc = new Account(1l, "savings", "pune", 100d, "xyz");
		String msg = service.createAccount(acc);
		assertEquals("Account Created Sucessfully", msg);
	}
	
	@Test
	public void testValidate() {
		Boolean flag= null;
		try {
			flag = service.validate(1l, "xyz");
		} catch (AccountNotFound | PasswordIncorrect e) {
			flag = false;
		}
		assertTrue(flag);
	}
	
	
	@Test
	public void testDeposit() {
		Account acc ;
		try {
			acc = service.deposit(1l, 100);
			assertNotNull(acc);
		} catch (AccountNotFound e) {
			acc = null;
			assertNull(acc);
		}
		
	}
	
	@Test
	public void testWithdraw() {
		Account acc ;
		try {
			acc = service.withdraw(1l, 10);
			assertNotNull(acc);
		} catch (AccountNotFound e) {
			acc = null;
			assertNull(acc);
		}
		
	}
	
	
	@Test
	public void testUpdatePassword() {
		String msg = service.updatePassword(1l, "xyz", "xyz");
		assertEquals("Password Updated Succesfully", msg);
	}
	
}
