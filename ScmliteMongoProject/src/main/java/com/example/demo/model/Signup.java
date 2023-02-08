package com.example.demo.model;

import javax.persistence.Entity;

import org.springframework.data.mongodb.core.mapping.Document;
@Entity
@Document(collection="register")
public class Signup {

	private String username;
	private String email;
	private String password;
    private String role;
    private boolean enabled = true;
	
	public Signup() {
		super();

	}
	public String getUsername() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		System.out.println("role"+role);
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
