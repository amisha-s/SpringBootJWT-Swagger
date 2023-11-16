package com.FISglobal.bankApplication.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.FISglobal.bankApplication.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	public abstract Optional<Customer> findByEmail(String email);
	//deleting account
	@Modifying
	@Query("Delete Customer c where c.custId = ?1 and c.password = ?2")
	public abstract int deleteUser(int id, String password);

}
