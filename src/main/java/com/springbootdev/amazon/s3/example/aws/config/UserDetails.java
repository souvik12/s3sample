package com.springbootdev.amazon.s3.example.aws.config;

public class UserDetails {
	private Integer id;
	private String username, password;
	private String role;
	
	public UserDetails() {
		
	}
	
	public UserDetails(String username, String password) {
		this.id = 1;
		this.username = username;
		this.password = password;
		this.role = "ADMIN";
	}
	
	public UserDetails(Integer id, String username, String password, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	

}
