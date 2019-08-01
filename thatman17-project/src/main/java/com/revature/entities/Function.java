package com.revature.entities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.*;

public class Function implements Dao<Employees> {
	Connection connection;
	
	@Override
	public boolean validate(String username, String password) {
		try {
			PreparedStatement pt = connection.prepareStatement("select username, password from employees where username =?");
			pt.setString(1, username);
			ResultSet rs = pt.executeQuery();
			String vName = "", vPass = "";
			while (rs.next()) {
				vName = rs.getString("username");
				vPass = rs.getString("password");
			}
			if (vName.equals(username) && (vPass.equals(password))) {
				return true;
			} else {
				return false;
			}
	} catch (SQLException e) {
		
	}
		return false;
	}
	public Function(Connection connection) {
        this.connection = connection;
    }
}
