package com.revature.transaction.api.domain;

import java.util.List;

import com.revature.transaction.api.entities.Dao;

/**
 * MovieService
 */
public class TransactionService implements Service<Transaction> {
    private Dao<Transaction> dao;

    public TransactionService(Dao<Transaction> dao) {
        this.dao = dao;
    }

    @Override
    public void insert(Transaction transaction) {
        this.dao.insert(transaction);
    }

    @Override
    public List<Transaction> getAll() {
        return dao.getAll();
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {
		
    }

}