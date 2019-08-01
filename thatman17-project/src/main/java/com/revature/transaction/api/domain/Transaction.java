package com.revature.transaction.api.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Movie
 */
@XmlRootElement
public class Transaction {
    private int username;
    private int cost;
    private String picture;

    public Transaction() {
    };

    public Transaction(int username, int cost, String picture) {
        this.username = username;
        this.cost = cost;
        this.picture = picture;
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(int id) {
        this.username = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Transaction [username=" + username + ", cost=" + cost + ", picture=" + picture + "]";
    }
    
}