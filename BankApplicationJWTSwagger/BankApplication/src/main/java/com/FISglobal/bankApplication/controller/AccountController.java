//name of package
package com.FISglobal.bankApplication.controller;
//importing list
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FISglobal.bankApplication.exceptions.AccountNotFound;
import com.FISglobal.bankApplication.exceptions.BalanceNotFound;
import com.FISglobal.bankApplication.exceptions.PasswordIncorrect;
import com.FISglobal.bankApplication.model.Account;
import com.FISglobal.bankApplication.model.Transaction;
import com.FISglobal.bankApplication.service.AccountService;
import com.FISglobal.bankApplication.service.TransactionService;



//Class use for queries related to account
@RestController
@RequestMapping("/CustomerAccount")
public class AccountController {
	//creating object of AccountService & TransactionService 
	@Autowired
	AccountService service ; 
	
	@Autowired
	TransactionService tservice;
	//create acc
	@PostMapping("/CreateAccount") 
	public String create(@RequestBody Account account) {
		return service.createAccount(account);
	}
	// validating acc no and password
	@GetMapping("/Valid/{accNo}/{password}") //http://localhost:8080/CustomerAccount/Valid
	public  int valid(@PathVariable("accNo") long accNo,  @PathVariable("password") String password ) {
		//try and catch for exception handling
		try {
			service.validate(accNo, password);
			return 1;
		} catch (AccountNotFound | PasswordIncorrect e) {
			System.out.println("Exception Found !" + e );
		}
		return 0;
	}
	
	
	//deposit into acc
	@GetMapping("/Deposit/{accNo}/{amt}") 
	public String deposit(@PathVariable ("accNo") long accNo, @PathVariable("amt") double amt) {
		//try and catch for exception handling
		try{
			//details dor transaction
			Account acc =  service.deposit(accNo, amt);
			Transaction t= new Transaction();
			t.setAccNoFrom(0);
			t.setAccNoTo(accNo);
			t.setAmount(amt);
			t.setBalance(acc.getBalance());
			t.setTransType("deposit");
			
			tservice.addTransaction(t);
			
			return acc.toString() ;
			
		}catch(AccountNotFound a ) {
			//exception handling
			return "Error! account not found ";
		}
	
		
		}
	
	
	//withdraw
	@GetMapping("/Withdraw/{accNo}/{password}/{amt}") //http://localhost:8080/CustomerAccount/Withdraw
	public String withdraw(@PathVariable ("accNo") long accNo,  @PathVariable("password") String password , @PathVariable("amt") double amt) {
		if(valid(accNo, password)==1) {
			//try and catch for exception handling
			try{
				//acc details for withdraw
				Account acc =  service.withdraw(accNo, amt);
				Transaction t= new Transaction();
				t.setAccNoTo(0);
				t.setAccNoFrom(accNo);
				t.setAmount(amt);
				t.setBalance(acc.getBalance());
				t.setTransType("withdraw");
				
				tservice.addTransaction(t);
				
				return acc.toString() ;
				// exceptions
			}catch (AccountNotFound| BalanceNotFound a)
			{
				return "Exception " + a ;
			}
			
			
		}
		// returning exceptions
		return "Account /Password Incorrect. Recheck!";
			
	}
	
	//Transfer
	@GetMapping("/TransferotherBank/{accNoTo}/{accNoFrom}/{password}/{amt}") //http://localhost:8080/CustomerAccount/TransferotherBank
	public String transferotherBank(@PathVariable ("accNoTo") long accNoTo, @PathVariable ("accNoFrom") long accNoFrom,  @PathVariable("password") String password , @PathVariable("amt") double amt) {
		//validation
		int result = valid(accNoFrom, password);
		if(result == 0)
			return "Failed, accNo or password does not match ";
		else {
			//try and catch for exception handling
			try{
				Account acc =  service.withdraw(accNoFrom, amt);
			// acc details and transaction details
			Transaction t= new Transaction();
			t.setAccNoTo(accNoTo);
			t.setAccNoFrom(accNoFrom);
			t.setAmount(amt);
			t.setBalance(acc.getBalance());
			t.setTransType("transfer to diff bank");
			
			tservice.addTransaction(t);
			
			return acc.toString() ;
			}catch (AccountNotFound a)
			{
				return "Account not found ";
			}
			catch(BalanceNotFound b )
			{
				return "Not enough balance , enter a smaller amount ";
			}
			
			
			
		}
			
	}
	
	//update password
	
	@GetMapping("/UpdatePassword/{accNo}/{password}/{newpass}/{repass}")  //http://localhost:8080/CustomerAccount/UpdatePassword
	public String updatePass(@PathVariable ("accNo") long accNo,  @PathVariable("password") String password , @PathVariable("newpass") String newpass, @PathVariable("repass") String repass) {
		int result = valid(accNo, password);
		if(result == 0)
			return "Failed, accNo or password does not match ";
		else 
			return service.updatePassword(accNo, newpass, repass);
			
	}
	
	
	//all transaction
	@GetMapping("/AllTransaction") 
	public List<Transaction>  AllTransaction(){
		return tservice.getAllTransaction();
	}
	// acc no transaction
	@GetMapping("/TransactionByAccNo/{accNo}/{password}")  
	public List<Transaction>  TransactionByAccNo(@PathVariable("accNo") long accNo, @PathVariable("password") String password ){
		int result = valid(accNo, password);
		if(result == 0)
			return null;
		else 
			return tservice.getAllTransactionByAccNo(accNo);
	}
	//transaction by date
	@GetMapping("/TransactionByDate/{startdate}/{enddate}")  
	public List<Transaction> TransactionByDate( @PathVariable("startdate") String startdate, @PathVariable("enddate") String enddate  ){
		for (Transaction tr:tservice.getAllTransactionByDate(startdate, enddate)) {
			System.out.println(tr);
		}
			
			return tservice.getAllTransactionByDate(startdate, enddate);
	}
	
}
