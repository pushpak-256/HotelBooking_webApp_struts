package booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import com.opensymphony.xwork2.ActionSupport;

import DBservices.DbConnector;

public class BookAction extends ActionSupport {
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

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

	public String getRooms() {
		return "1";
	}

	public void setRooms(String rooms) {
		this.rooms = rooms;
	}

	public String getHotelNo() {
		return hotelNo;
	}

	public void setHotelNo(String hotelNo) {
		this.hotelNo = hotelNo;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	private String mobile, url, userName, hotelName, city, wifi, dinner, lunch, breakfast, rooms, hotelNo, error;
      private double price;
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	DbConnector connector = new DbConnector();
	PreparedStatement insertstatement;
	Connection con;
	Statement st;

	private void filterUrl() {
		String[] arr = url.split(",");
		setMobile(arr[0]);
		setHotelName(arr[1]);
		setCity(arr[2]);
	
	}

	private boolean bookHotel_DB() throws SQLException {

		fetch_Var_values();

		String sql = "insert into bookedHotels values('" + userName + "','" + mobile + "','" + hotelName + "','" + city
				+ "','" + hotelNo + "')";

		con = connector.getConnection();
		st = con.createStatement();

		int result = st.executeUpdate(sql);

		con.close();

		if (result > 0)
			return true; // added

		else
			return false;

	}

	public void fetch_Var_values() {
		try {
           String sql="select * from hotels_list where city='" + city + "' and hotelName='" + hotelName + "'";
			con = connector.getConnection();
			st = con.createStatement();

			ResultSet rs = st.executeQuery(sql);
			System.out.println(sql);
			if (rs.next()) {
				setWifi(rs.getString(3));
				setDinner(rs.getString(5));
				setLunch(rs.getString(6));
				setBreakfast(rs.getString(7));
				setHotelNo(String.valueOf(rs.getInt(9)));
				setPrice((rs.getDouble(4)));
				System.out.println(rs.getDouble(4)+"-prive");
				}
			 else
				setError("DB error");
			
            st=null;
			st=con.createStatement();
		    rs= st.executeQuery( "select name from register where mobile='"+mobile+"' ");	
			 if (rs.next()) {
				 setUserName(rs.getString(1));
			 }
			 else setError("User Name not found in db");
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void updateAvailableRooms() throws SQLException {

		String sql = "UPDATE hotels_list set rooms = rooms - 1 WHERE hotelNo = " + hotelNo + " ";
       
		con = connector.getConnection();
		st = con.createStatement();

		int result = st.executeUpdate(sql);

		con.close();

		if (result > 0)
			System.out.println("rooms Updated"); // added

		else
			System.out.println("error while room updating");

	}

	@Override
	public String execute() throws Exception {
		filterUrl();
		if (bookHotel_DB()) {
			updateAvailableRooms();
			return "BOOKED";
		} else
			return ERROR;

	}

}
