package com.revature.domain;

import java.util.List;

import com.revature.entities.Dao2;

public class TransactionService implements Service<Transaction>{
	private Dao2<Transaction> dao;

    public TransactionService(Dao2<Transaction> dao) {
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
    public List<Transaction> getApproved(){
    	return dao.getApproved();
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {
		
    }

}
