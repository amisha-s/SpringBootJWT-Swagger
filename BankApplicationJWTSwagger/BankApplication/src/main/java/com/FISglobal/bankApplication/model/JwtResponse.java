//name of package
package com.FISglobal.bankApplication.model;
//import serealization
import java.io.Serializable;
//class JwtResponse
public class JwtResponse implements Serializable {

	private final String jwttoken;
//parameterized constrctor
	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}
//returning token
	public String getToken() {
		return this.jwttoken;
	}
}