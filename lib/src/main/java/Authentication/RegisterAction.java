package Authentication;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

import DBservices.DbConnector;

public class RegisterAction extends ActionSupport {
	
	DbConnector connector= new DbConnector();
	private Statement st;
	private Connection con;

	private String name, password ,mobile , email , error;
    private final String admin="USER";
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void validate() {
	
	}



	public String execute() {
		if (register()) return SUCCESS;
		else return ERROR;
	}

	public boolean register() {
		boolean result=false;
		 try {
	        	con =connector.getConnection();
				st=con.createStatement();
		    ResultSet rs= st.executeQuery( "select*from register where mobile='"+mobile+"'");	
				
		    if(!rs.next()) {
		    	
		           
		         PreparedStatement insertstatement = con.prepareStatement
				   ("INSERT INTO register (name, password ,mobile , email,admin) values(?,?,?,?,?)");					

		               	insertstatement.setString(1, name);
						insertstatement.setString(2, password);
						insertstatement.setString(3, mobile);
						insertstatement.setString(4, email);
						insertstatement.setString(5, admin);
						
						int i = insertstatement.executeUpdate();

						if (i <= 0) System.out.println("Something went Wrong In DB registration");
						else {     result=true;}
		    }
		    else setError("already register with phoneNo -"+mobile); 
		    con.close();
		 }
		 catch (SQLException e) {e.printStackTrace();} 
		 
		
		return result;
				
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	


}