package booking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

import DBservices.DbConnector;

public class SearchAction extends ActionSupport {


	List <Hotel> hotelsFound = new ArrayList<>(); 
	
	public List<Hotel> getHotelsFound() {
		return hotelsFound;
	}

	public void setHotelsFound(List<Hotel> hotelsFound) {
		this.hotelsFound = hotelsFound;
	}


	private List<String> food;
	private String wifi, city, price, rooms;
	private String breakfast, lunch, dinner;
	
	public String getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}

	public String getLunch() {
		return lunch;
	}

	public void setLunch(String lunch) {
		this.lunch = lunch;
	}

	public String getDinner() {
		return dinner;
	}

	public void setDinner(String dinner) {
		this.dinner = dinner;
	}


	 DbConnector connector = new DbConnector();
	 Statement st;
	 Connection con;
  
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRooms() {
		return rooms;
	}

	public void setRooms(String rooms) {
		this.rooms = rooms;
	}

	public String getWifi() {
		return wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<String> getFood() {
		return food;
	}

	public void setFood(List<String> food) {
		this.food = food;
	}

	@Override
	public String execute() throws Exception {
		meals(food);
		
		applyFilter();
      
		return SUCCESS;
	}

	// fetching meal times
	private void meals(List<String> food) {

		this.lunch = (food.contains("lunch")) ? "'yes'": "lunch";
		this.dinner = (food.contains("dinner")) ? "'yes'": "dinner";
		this.breakfast = (food.contains("breakfast")) ? "'yes'": "brakfast";

	}

	private String createSQL_Query() {
		String roomTemp;
		
		if(!rooms.equals("available")) {roomTemp=">0";}
		else roomTemp="=rooms";
		
		String q=
        "select * from hotels_list where city='"+city+"' and price " +price+" and wifi='"+wifi+"' and rooms"+roomTemp+" and brakfast="+breakfast+" and lunch="+lunch+" and dinner="+dinner+"  ";
		System.out.println(q);
		return q;
	}
	
   private void applyFilter() throws SQLException {
		
	 	String sqlQuery=createSQL_Query();
		con=connector.getConnection();
		st = con.createStatement();
        ResultSet rs = st.executeQuery(sqlQuery);
        
        while (rs.next()) {
        	Hotel hotel = new Hotel();
 
          hotel.setName(rs.getString(1));
          hotel.setCity(rs.getString(2));
          hotel.setWifi(rs.getString(3));
          hotel.setPricee( String.valueOf(rs.getDouble(4)) );
          hotel.setBreakfast(rs.getString(7));
          hotel.setDinner(rs.getString(5));
          hotel.setLunch(rs.getString(6));
          hotel.setWifi(wifi);	
          hotel.setCity(city);
         
          hotel.setRooms( String.valueOf(rs.getInt(8)));
          hotel.setHotelNo( String.valueOf( rs.getInt(9) ));
          
        	hotelsFound.add(hotel);
        }
      con.close();

	}

}
