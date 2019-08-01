package com.revature.transaction.api.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.transaction.api.domain.Transaction;

/**
 * MovieDao
 */
public class TransactionDao implements Dao<Transaction> {
    Connection connection;
    
    public TransactionDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Transaction transaction) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("insert into transactions(username, cost) values(?, ?)");
            pStatement.setInt(1, transaction.getUsername());
            pStatement.setInt(2, transaction.getCost());
            pStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public List<Transaction> getAll() {
        Transaction transaction;
        List<Transaction> transactions = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from transactions");
            while (resultSet.next()) {
                transaction = new Transaction();
                transaction.setUsername(resultSet.getInt("username"));
                transaction.setCost(resultSet.getInt("cost"));
                transaction.setPicture(resultSet.getString("picture"));
                transactions.add(transaction);
            }
        } catch (SQLException e) {

        }
        return transactions;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}