package com.revature.entities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.*;

public class Function implements Dao<Employees> {
	Connection connection;
	
	@Override
	public int validate(String username, String password) {
		int checker = 0;
		try {
			PreparedStatement pt = connection.prepareStatement("select username, password, permission from employees where username =?");
			pt.setString(1, username);
			ResultSet rs = pt.executeQuery();
			String vName = "", vPass = "";
			boolean vPerm = false;
			while (rs.next()) {
				vName = rs.getString("username");
				vPass = rs.getString("password");
				vPerm = rs.getBoolean("permission");
			}
			if (vName.equals(username) && (vPass.equals(password) && vPerm)) {
				checker = 2;
			} else if (vName.equals(username) && (vPass.equals(password))) {
				checker = 1;
			} else {
				
			}
	} catch (SQLException e) {
		
	}
		return checker;
	}
	public Function(Connection connection) {
        this.connection = connection;
    }
}
