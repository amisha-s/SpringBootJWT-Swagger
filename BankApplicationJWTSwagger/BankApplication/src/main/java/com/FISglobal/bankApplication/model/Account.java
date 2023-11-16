//name of package
package com.FISglobal.bankApplication.model;
//importing entity
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;


@Entity
@Table(name = "account_info")
public class Account {

	// variables required to create account in bank
	@Id
	@GeneratedValue
	private long accNo;
	//validation
	@NotBlank(message = "acc type cannot be null or whitespace")
	private String accType;
	//validation
	@NotBlank(message = "branch cannot be null or whitespace")
	private String branch;
	//validation
	@PositiveOrZero(message = "balance must be positive or zero.")
	private double balance;
	//validation
	@Size(min = 3, max = 15, message = "password length must be between 3-15")
	private String password;
	//getters and setters
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Account(long accNo, @NotBlank(message = "acc type cannot be null or whitespace") String accType,
			@NotBlank(message = "branch cannot be null or whitespace") String branch,
			@NotBlank(message = "balance cannot be null or whitespace.") @PositiveOrZero(message = "balance must be positive or zero.") double balance,
			@Size(min = 3, max = 15, message = "password length must be between 3-15") @NotBlank(message = "password cannot be null or whitespace") String password) {
		super();
		this.accNo = accNo;
		this.accType = accType;
		this.branch = branch;
		this.balance = balance;
		this.password = password;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", accType=" + accType + ", branch=" + branch + ", balance=" + balance
				+ ", password=" + password + "]";
	}

	

}
