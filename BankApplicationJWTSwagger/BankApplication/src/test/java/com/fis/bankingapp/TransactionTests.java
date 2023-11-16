package com.fis.bankingapp;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.FISglobal.bankApplication.model.Transaction;
import com.FISglobal.bankApplication.service.TransactionService;


@SpringBootTest
class TransactionTests {
	
	@Autowired
	TransactionService service;
	
	@Test
	public void testAddTransaction(){
		Transaction tr= new Transaction(1, 1l, 1l, 10d, LocalDate.now(), "deposit", 10d);
		String msg = service.addTransaction(tr);
		assertEquals("Transaction saved sucessfully", msg);
	}
	
	@Test
	public void testGetAllTransaction() {
		Boolean flag = service.getAllTransaction().isEmpty();
		assertTrue(flag);
	}
	
	@Test
	public void testGetAllTransactionByAccNo() {
		Boolean flag = service.getAllTransactionByAccNo(1l).isEmpty();
		assertTrue(flag);
	}

	@Test
	public void testGetAllTransactionByDate() {
		Boolean flag = service.getAllTransactionByDate("2023-10-10", "2023-12-12").isEmpty();
		assertTrue(flag);
	}

	
}
