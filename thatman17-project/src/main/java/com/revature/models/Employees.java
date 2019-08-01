package com.revature.models;

public class Employees {
	private String username, password, address;
	
	public Employees() {}
	
	public Employees(String username, String password, String address) {
		this.username = username;
		this.password = password;
		this.address = address;
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
    
    public String getAddress() {
    	return address;
    }
    
    public void setAddress(String address) {
    	this.address = address;
    }
}
