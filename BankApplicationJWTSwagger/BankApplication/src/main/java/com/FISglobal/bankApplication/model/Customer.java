//name of package
package com.FISglobal.bankApplication.model;

//importing date
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "customer_info")
public class Customer {
	@Id
	@GeneratedValue
	//variables used for customer info
	private int custId;
	//validation
	@Size(min = 3, max = 15, message = "Name length must be between 3-15")
	@NotBlank(message = "Name cannot be null or whitespace")
	private String custName;
	//validation
	@Digits(fraction = 0, integer = 10, message  = "Phone number should be 10 digits.")
	private long mobile;
	//validation
	@Email(message = "Email format should have @ and .")
	private String email;
	//validation
	@Digits(fraction = 0, integer = 12 , message = "Aadhar Number should be 12 digits.")
	private long aadharNo;
	//validation
	@Past(message = "Date of Birth cannot be current date.")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private LocalDate dob;
	//validation
	@Positive
	@Min(value = 18, message ="Must be atleast 18 to open an account.")
	private short age;
	//validation
	@NotEmpty(message = "This field cannot be empty.")
	private String rAddress;
	//validation
	@NotEmpty(message = "This field cannot be empty.")
	private String pAddress;
	//validation
	@Size(min = 3, max = 15, message = "password length must be between 3-15")
	@NotBlank(message = "password cannot be null or whitespace")
	private String password;
	
	
//getters and setters
	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public String getrAddress() {
		return rAddress;
	}

	public void setrAddress(String rAddress) {
		this.rAddress = rAddress;
	}

	public String getpAddress() {
		return pAddress;
	}

	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [custName=" + custName + ", mobile=" + mobile + ", email=" + email + ", aadharNo=" + aadharNo
				+ ", dob=" + dob + ", age=" + age + ", rAddress=" + rAddress + ", pAddress=" + pAddress + "]";
	}

// validations and entries

	public Customer(int custId,
			@Size(min = 3, max = 15, message = "Name length must be between 3-15") @NotBlank(message = "Name cannot be null or whitespace") String custName,
			@Digits(fraction = 0, integer = 10, message = "Phone number should be 10 digits.") long mobile,
			@Email(message = "Email format should have @ and .") String email,
			@Digits(fraction = 0, integer = 12, message = "Aadhar Number should be 12 digits.") long aadharNo,
			@Past(message = "Date of Birth cannot be current date.") LocalDate dob,
			@Positive @Min(value = 18, message = "Must be atleast 18 to open an account.") short age,
			@NotEmpty(message = "This field cannot be empty.") String rAddress,
			@NotEmpty(message = "This field cannot be empty.") String pAddress,
			@Size(min = 3, max = 15, message = "password length must be between 3-15") @NotBlank(message = "password cannot be null or whitespace") String password) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.mobile = mobile;
		this.email = email;
		this.aadharNo = aadharNo;
		this.dob = dob;
		this.age = age;
		this.rAddress = rAddress;
		this.pAddress = pAddress;
		this.password = password;
	}
	
	
	

}
