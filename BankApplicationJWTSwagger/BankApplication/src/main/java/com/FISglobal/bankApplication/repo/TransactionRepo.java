package com.FISglobal.bankApplication.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FISglobal.bankApplication.model.Transaction;
//Transactions with date
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
	public abstract List<Transaction> findByDateOfTransBetween(LocalDate startDate, LocalDate endDate);

	public abstract List<Transaction> findAllByAccNoTo(long accNo);
}
