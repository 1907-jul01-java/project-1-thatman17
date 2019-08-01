package com.revature.transaction.api.resources.transactions;

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

import com.revature.transaction.api.ConnectionUtil;
import com.revature.transaction.api.domain.Transaction;
import com.revature.transaction.api.domain.TransactionService;
import com.revature.transaction.api.entities.TransactionDao;

/**
 * MovieController
 * 
 */
@Path(value = "transactions")
public class TransactionController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Transaction> getAllTransactionsJSON() {
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

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public void insertTransaction(@FormParam("id") String id, @FormParam("title") String title, @FormParam("year") int year,
			@Context HttpServletResponse resp) throws IOException {
		try (Connection connection = new ConnectionUtil().getConnection()) {
			TransactionDao dao = new TransactionDao(connection);
			TransactionService service = new TransactionService(dao);
			service.insert(new Transaction(1, year, title));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		resp.sendRedirect("/transaction-api");
	}
}