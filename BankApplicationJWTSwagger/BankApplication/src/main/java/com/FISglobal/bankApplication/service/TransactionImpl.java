package com.FISglobal.bankApplication.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FISglobal.bankApplication.model.Transaction;
import com.FISglobal.bankApplication.repo.TransactionRepo;

// This is used to call TransactionRepo.

@Service
@Transactional
public class TransactionImpl implements TransactionService {
	@Autowired
	TransactionRepo dao;

	
	// This method will call save to add the Transaction
	@Override
	public String addTransaction(Transaction transaction) {
		dao.save(transaction);
		return "Transaction saved sucessfully";
	}
	
	//All the Transaction for all the Accounts
	@Override
	public List<Transaction> getAllTransaction() {
		return dao.findAll();
	}
	
	//By AccNo

	@Override
	public List<Transaction> getAllTransactionByAccNo(long accNo) {
		return dao.findAllByAccNoTo(accNo);
	}

	//Between Dates will get the transaction, uses localDate
	@Override
	public List<Transaction> getAllTransactionByDate(String startDate, String endDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startDatestr = LocalDate.parse(startDate, formatter);
		LocalDate endDatestr = LocalDate.parse(endDate, formatter);
		return dao.findByDateOfTransBetween(startDatestr, endDatestr);
	}

}
