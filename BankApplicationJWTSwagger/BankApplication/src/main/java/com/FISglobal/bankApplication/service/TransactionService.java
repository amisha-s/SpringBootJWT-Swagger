package com.FISglobal.bankApplication.service;

import java.util.List;

import com.FISglobal.bankApplication.model.Transaction;
//interface class with abstract methods
public interface TransactionService {
	public abstract String addTransaction(Transaction transaction);

	public abstract List<Transaction> getAllTransaction();

	public abstract List<Transaction> getAllTransactionByAccNo(long accNo);

	public abstract List<Transaction> getAllTransactionByDate(String startDate, String endDate);

}
