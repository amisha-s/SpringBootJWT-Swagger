//package name
package com.FISglobal.bankApplication.repo;
//importing java frameworks
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.FISglobal.bankApplication.exceptions.AccountNotFound;
import com.FISglobal.bankApplication.exceptions.BalanceNotFound;
import com.FISglobal.bankApplication.model.Account;
//interface AccountRepo
public interface AccountRepo extends JpaRepository<Account, Long> {

	public abstract Account findByAccNoAndPassword(long accNo, String password);
	//Queries 
	@Modifying
	@Query("Update Account a set a.balance = a.balance + ?2 where a.accNo = ?1")
	public abstract int deposit(long accNo, double amt) throws AccountNotFound;
	
	@Modifying
	@Query("Update Account a set a.balance = a.balance - ?2 where a.accNo = ?1")
	public abstract  int withdraw(long accNo, double amt) throws AccountNotFound, BalanceNotFound;

	@Modifying 
	@Query("Update Account a set a.password = ?2 where a.accNo = ?1")
	public abstract int updatePassword(long accNo, String newPassword);

	public abstract Account findByAccNo(long accNo);

}
