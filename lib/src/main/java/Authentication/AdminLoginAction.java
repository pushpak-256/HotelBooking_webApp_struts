package Authentication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

import DBservices.DbConnector;

public class AdminLoginAction extends ActionSupport{


	DbConnector connector= new DbConnector();
	private Statement st;
	private Connection con;
	
	private String mobile, password,error,admin;
	
	
	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

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
			 System.out.println("insi loginvald");
			 if (!admin.equals("Admin")){setError("user please register with user sign up "); return false;}
	        	con =connector.getConnection();
				st=con.createStatement();
		    ResultSet rs= st.executeQuery( "select password from register where mobile='"+mobile+"' and admin='Admin'");	
//                 System.out.println("select password from register where mobile='"+mobile+"' and admin='Admin'");

		    if(rs.next() )             
		    	if(password.equals(rs.getString(1)))result=true;
			    else setError(" PASSWORD IS INCORRECT, login again");
		    	
			      
		    
		    else setError("NO record found,please register ADMIN with Phone -  "+mobile);
		   
		    con.close();
		 }
		 catch (SQLException e) {e.printStackTrace();} 
		 
		 
		return result;
	}
	
}
