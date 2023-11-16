//name of package
package com.FISglobal.bankApplication.configuration;
//imposting exception
import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


//class AuthenticationJWT use inheritance
@Component
public class AuthenticationJWT implements AuthenticationEntryPoint, Serializable {
// declaring variable
	private static final long serialVersionUID = -7858869558953243875L;
// starting servlet and throw Input Output Exception
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {

	   //error in case of wrong credentials	
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}
}