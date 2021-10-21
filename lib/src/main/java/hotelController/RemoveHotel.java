package hotelController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import DBservices.DbConnector;

public class RemoveHotel extends ActionSupport {
	
	private String hotelName,hotelRegNo,error;
	
	DbConnector connector = new DbConnector();
	PreparedStatement insertstatement;
	Connection con;
	
	public String getHotelRegNo() {
		return hotelRegNo;
	}

	public void setHotelRegNo(String hotelRegNo) {
		this.hotelRegNo = hotelRegNo;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}


	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	@Override
	public String execute() throws Exception {
		if (removeHotel())
			return SUCCESS;
		else {
			setError("invalid hotel name or registration Number");
			return ERROR;
		}
	}
	
	
	private boolean removeHotel() throws SQLException {
		int res = 0;
		String sqlQuery = "delete from hotels_list where hotelNo=? and hotelName=?";
		
		con = connector.getConnection();
		insertstatement = con.prepareStatement(sqlQuery);

		insertstatement.setString(1, hotelRegNo);
		insertstatement.setString(2, hotelName);

		res = insertstatement.executeUpdate();
		con.close();

		return (res == 0) ? false : true;
	}
	
}
