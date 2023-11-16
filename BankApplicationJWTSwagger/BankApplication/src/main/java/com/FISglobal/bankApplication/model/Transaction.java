//name of package
package com.FISglobal.bankApplication.model;
//importing date
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "transaction_info")
//class use for tranasction purpose
public class Transaction {
	@Id
	@GeneratedValue
	//variables use for tranasction purpose
	private int transId;
	private long accNoFrom;
	private long accNoTo;
	@Positive(message = "amount must be positive")
	private double amount;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfTrans = LocalDate.now();
	@NotBlank(message = "acc type cannot be null or whitespace")
	private String transType;
	@PositiveOrZero(message = "balance must be positive or zero.")
	private double balance;
//getter & setters
	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public long getAccNoFrom() {
		return accNoFrom;
	}

	public void setAccNoFrom(long accNoFrom) {
		this.accNoFrom = accNoFrom;
	}

	public long getAccNoTo() {
		return accNoTo;
	}

	public void setAccNoTo(long accNoTo) {
		this.accNoTo = accNoTo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDateOfTrans() {
		return dateOfTrans;
	}

	public void setDateOfTrans(LocalDate dateOfTrans) {
		this.dateOfTrans = dateOfTrans;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
//parameterized constructor
	public Transaction(int transId, long accNoFrom, long accNoTo, double amount, LocalDate dateOfTrans,
			String transType, double balance) {
		super();
		this.transId = transId;
		this.accNoFrom = accNoFrom;
		this.accNoTo = accNoTo;
		this.amount = amount;
		this.dateOfTrans = dateOfTrans;
		this.transType = transType;
		this.balance = balance;
	}

	public Transaction() {
	}

	@Override
	public String toString() {
		return "Transaction [ accNoFrom=" + accNoFrom + ", accNoTo=" + accNoTo + ", amount=" + amount + ", dateOfTrans="
				+ dateOfTrans + ", transType=" + transType + ", balance=" + balance + "]";
	}

}
