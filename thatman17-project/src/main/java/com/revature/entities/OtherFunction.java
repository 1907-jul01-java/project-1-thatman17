package com.revature.entities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.*;

import com.revature.models.DarkTransaction;

public class OtherFunction implements BadDao<DarkTransaction> {
	Connection connection;
	
	@Override
	public List<DarkTransaction> getEmployee(String username) {
		DarkTransaction dt;
		List<DarkTransaction> dts = new ArrayList<>();
		try {
			PreparedStatement pt = connection.prepareStatement("select * from transactions where username =? and validate = 0");
			pt.setString(1, username);
			ResultSet resultSet = pt.executeQuery();
			while (resultSet.next()) {
				dt = new DarkTransaction();
				dt.setUsername(resultSet.getString("username"));
				dt.setCost(resultSet.getDouble("cost"));
				dt.setPicture(resultSet.getString("picture"));
				dts.add(dt);
			}
		}catch (SQLException e) {} return dts;
	}
	public OtherFunction(Connection connection) {
        this.connection = connection;
    }
}
