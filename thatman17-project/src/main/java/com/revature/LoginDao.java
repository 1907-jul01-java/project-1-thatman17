package com.revature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.transaction.api.domain.*;


public class LoginDao {  
	Connection connection;
	
public boolean validate(String username,String password){  
boolean status=false;   
try{   
      
PreparedStatement ps=connection.prepareStatement(  
"select * from employees where username=? and password=?");  
ps.setString(1,username);  
ps.setString(2,password);  
String vName = "", vPass = "";
      
ResultSet rs=ps.executeQuery();  
while (rs.next()) {
	vName = rs.getString("username");
	vPass = rs.getString("password");
}
if (vName.equals(username) && (vPass.equals(password))){
	status = true;
}
          
}catch(Exception e){System.out.println(e);}  
return status;  
}  
}  