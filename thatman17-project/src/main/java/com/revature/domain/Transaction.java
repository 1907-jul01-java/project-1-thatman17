package com.revature.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Transaction {
	private String username;
	private double cost;
	private String picture;
	private int validate;

	public Transaction() {
	
	};
	
	public Transaction(String username, double cost, String picture, int validate) {
		this.username = username;
		this.cost = cost;
		this.picture = picture;
		this.validate = validate;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public int getValidate() {
		return validate;
	}
	public void setValidate(int validate) {
		this.validate = validate;
	}
	
	@Override
	public String toString() {
		return "Transaction [username=" + username + ", cost=" + cost + ", reason=" + picture + ", validate=" + validate +"]";
	}
	
}
