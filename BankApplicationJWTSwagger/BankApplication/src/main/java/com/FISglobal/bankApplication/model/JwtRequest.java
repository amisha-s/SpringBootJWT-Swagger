//name of package
package com.FISglobal.bankApplication.model;
//import Serializable
import java.io.Serializable;
//class JWT
public class JwtRequest implements Serializable {
//variables
	private static final long serialVersionUID = 5926468583005150707L;
	
	private String username;
	private String password;
	
	//default constructor
	public JwtRequest()
	{
		
	}
//parameterized constructor
	public JwtRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}
//getter and setters
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}