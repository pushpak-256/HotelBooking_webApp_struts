package DBservices;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserTable {
	DbConnector connector= new DbConnector();
	private Statement st;
	private Connection con;
 public boolean registerUser() {
        	
	        try {
	        	con =connector.getConnection();
				st=con.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	 if (1==1) {return true;}
	 else return false;
 }
}
