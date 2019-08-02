package com.revature.resources;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.revature.util.ConnectionUtil;
import com.revature.domain.Transaction;
import com.revature.domain.TransactionService;
import com.revature.entities.TransactionDao;

@Path(value = "transactions")
public class TransactionController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Transaction> getAllTransactionsJSON(){
		List<Transaction> transactions = null;
		
		try (Connection connection = new ConnectionUtil().getConnection()) {
			TransactionDao dao = new TransactionDao(connection);
			TransactionService service = new TransactionService(dao);
			transactions = service.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactions;
	}
}
