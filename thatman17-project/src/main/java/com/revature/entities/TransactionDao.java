package com.revature.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Transaction;

public class TransactionDao implements Dao2<Transaction> {
	Connection connection;
	
	public TransactionDao(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public List<Transaction> getAll(){
		Transaction transaction;
		List<Transaction> transactions = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from transactions");
			while (resultSet.next()) {
				transaction = new Transaction();
				transaction.setUsername(resultSet.getString("username"));
				transaction.setCost(resultSet.getDouble("cost"));
				transaction.setPicture(resultSet.getString("picture"));
				transaction.setValidate(resultSet.getInt("validate"));
				transactions.add(transaction);
			}
		}catch (SQLException e) {
			
		}
		return transactions;
	}
	
	@Override
	public void insert(Transaction transaction) {
		
	}

}