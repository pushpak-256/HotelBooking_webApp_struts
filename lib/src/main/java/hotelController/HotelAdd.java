package hotelController;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.opensymphony.xwork2.ActionSupport;

import DBservices.DbConnector;

public class HotelAdd extends ActionSupport {

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getWifi() {
		return wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	public String getDinner() {
		return dinner;
	}

	public void setDinner(String dinner) {
		this.dinner = dinner;
	}

	public String getLunch() {
		return lunch;
	}

	public void setLunch(String lunch) {
		this.lunch = lunch;
	}

	public String getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getRooms() {
		return Rooms;
	}

	public void setRooms(String rooms) {
		Rooms = rooms;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	private String hotelName, city, wifi, dinner, lunch, breakfast, error, Rooms, Price, hotelRegNo;

	public String getHotelRegNo() {
		return hotelRegNo;
	}

	public void setHotelRegNo(String hotelRegNo) {
		this.hotelRegNo = hotelRegNo;
	}

	DbConnector connector = new DbConnector();
	PreparedStatement insertstatement;
	Connection con;
	Statement st;

	@Override
	public String execute() throws Exception {
		if (isHotelNameAvailable()) {
			if (addHotel()) {
				hotelNo();
				return SUCCESS;
			} else {
				setError("database error , try adding again");
				return ERROR;
			}
		} else
			return ERROR;
	}

	public void hotelNo() {
		try {

			con = connector.getConnection();
			st = con.createStatement();

			ResultSet rs = st.executeQuery(
					"select hotelNo from hotels_list where city='" + city + "' and hotelName='" + hotelName + "'  ");

			if (rs.next()) {
				setHotelRegNo(String.valueOf(rs.getInt(1)));
			} else
				setError("DB error");

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private boolean isHotelNameAvailable() {
		boolean res = false;
		try {
			con = connector.getConnection();
			st = con.createStatement();

			ResultSet rs = st.executeQuery(
					"select * from hotels_list where city='" + city + "' and hotelName='" + hotelName + "'  ");

			if (rs.next()) {
				setError("Hotel Name " + hotelName + " Not available for city " + city);
			} else {
				res = true;
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	private boolean addHotel() throws SQLException {
		int res = 0;
		String sqlQuery = "INSERT INTO hotels_list (hotelName, city, wifi, price, dinner, lunch , brakfast , rooms )values(?,?,?,?,?,?,?,?)";

		con = connector.getConnection();
		insertstatement = con.prepareStatement(sqlQuery);

		insertstatement.setString(1, hotelName);
		insertstatement.setString(2, city);
		insertstatement.setString(3, wifi);
		insertstatement.setDouble(4, Double.parseDouble(Price));
		insertstatement.setString(5, dinner);
		insertstatement.setString(6, lunch);
		insertstatement.setString(7, breakfast);
		insertstatement.setInt(8, Integer.parseInt(Rooms));

		res = insertstatement.executeUpdate();
		con.close();
		System.out.println(sqlQuery);
		return (res == 0) ? false : true;
	}

}
