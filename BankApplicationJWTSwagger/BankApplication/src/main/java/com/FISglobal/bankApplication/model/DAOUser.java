//name of package
package com.FISglobal.bankApplication.model;
//importing annotations and persistence
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
//class DAO
@Entity
@Table(name = "user_table")
public class DAOUser {
//variable
	@Id
	@GeneratedValue
	private long id;
	@Column
	private String username;
	@Column
	@JsonIgnore
	private String password;
	private String role;
//getter and setter
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}