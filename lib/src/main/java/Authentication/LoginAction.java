package Authentication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

import DBservices.DbConnector;

public class LoginAction extends ActionSupport {


	DbConnector connector= new DbConnector();
	private Statement st;
	private Connection con;
	
	private String mobile, password,error;
	
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String execute() throws Exception {
		if (loginValidation()) return SUCCESS;
			else return ERROR;
	}
	
	public boolean loginValidation() {
		boolean result=false;
		 try {
			 
			 String sql="select password from register where mobile='"+mobile+"'";
	        	con =connector.getConnection();
				st=con.createStatement();
		    ResultSet rs= st.executeQuery( sql);	

		    
		    if(rs.next() )             
		    	if(password.equals(rs.getString(1)))result=true;
			    else setError(" PASSWORD IS INCORRECT, login again");
		    	
			      
		    
		    else setError("please register first with your "+mobile);
		   
		    con.close();
		 }
		 catch (SQLException e) {e.printStackTrace();} 
		 
		 
		return result;
	}
	
}
