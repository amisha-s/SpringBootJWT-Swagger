//name of package
package com.FISglobal.bankApplication.configuration;
//importing 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//JWT
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Web extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationJWT authenticationJWT;

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private RequestJWT requestJWT;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// configure AuthenticationManager so that it knows from where to load user for matching credentials
		
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// We don't need CSRF for this example
		httpSecurity.csrf().disable()
				// dont authenticate this particular request
				.authorizeRequests().antMatchers("/authenticate", "/register", "/h2-console/**",  "/",
	                    "/v2/api-docs",           // swagger
	                    "/webjars/**",            // swagger-ui webjars
	                    "/swagger-resources/**",  // swagger-ui resources
	                    "/configuration/**",      // swagger configuration
	                    "/*.html").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().
				// all other requests need to be authenticated
				anyRequest().authenticated().and().
				// make sure we use stateless session; session won't be used to
				// store user's state.
				exceptionHandling().authenticationEntryPoint(authenticationJWT).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// added this extra here
		httpSecurity.headers().frameOptions().sameOrigin();

		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(requestJWT, UsernamePasswordAuthenticationFilter.class);

	}
}