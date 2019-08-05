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
			ResultSet resultSet = statement.executeQuery("select * from transactions where validate = 0");
			while (resultSet.next()) {
				transaction = new Transaction();
				transaction.setId(resultSet.getInt("id"));
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
	public List<Transaction> getApproved(){
		Transaction transaction;
		List<Transaction> transactions = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from transactions where validate = 1");
			while (resultSet.next()) {
				transaction = new Transaction();
				transaction.setId(resultSet.getInt("id"));
				transaction.setUsername(resultSet.getString("username"));
				transaction.setCost(resultSet.getDouble("cost"));
				transaction.setPicture(resultSet.getString("picture"));
				transaction.setValidate(resultSet.getInt("validate"));
				transaction.setManager(resultSet.getString("manager"));
				transactions.add(transaction);
			}
		}catch (SQLException e) {
			
		}
		return transactions;
	}
	
	@Override
	public void insert(Transaction transaction) {
		try {
			PreparedStatement pt = connection.prepareStatement("insert into transactions(username, cost, picture, validate) values (?, ?, ?, 0)");
			pt.setString(1, transaction.getUsername());
			pt.setDouble(2, transaction.getCost());
			pt.setString(3, transaction.getPicture());
			pt.executeUpdate();
		}catch (SQLException e) {}
	}
	
	@Override
	public void approve(int id, int approval, String manager) {
		try {
			PreparedStatement pt = connection.prepareStatement("update transactions set validate = ?, manager = ? where id = ?");
			pt.setString(2, manager);
			pt.setInt(3, id);
			pt.setInt(1, approval);
			pt.executeUpdate();
		}catch (SQLException e) {}
	}
}
