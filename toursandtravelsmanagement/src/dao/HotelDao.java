package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojo.Hotel_book;
import util.TourUtil;

public class HotelDao {

	public int saveHotelbook(Hotel_book hb) {
		int status = 0;
		try {
			Connection con = TourUtil.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into hotel_book(hotel_name, city, room_type, hotel_type, no_room, customer_id) values(?, ?, ?, ?, ?, ?)");
			 ps.setString(1, hb.getHotel_name());
			 ps.setString(2, hb.getCity());
			 ps.setString(3, hb.getRoom_type());
			 ps.setString(4, hb.getHotel_type());
			 ps.setInt(5, hb.getNo_of_rooms());
			 ps.setInt(6, hb.getCust_id());
			 status = ps.executeUpdate();
		}
		catch(Exception ex) {}
		return status;

	}
	
	public static List<Hotel_book> getbycustid(int cust_id) {
		List<Hotel_book> list_h = new ArrayList<Hotel_book>();
		try {
			 Connection con = TourUtil.getConnection();
			 PreparedStatement ps=con.prepareStatement(  
					    "select * from hotel_book where customer_id=?");
			 ps.setInt(1,cust_id);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()) 
			 {
				 Hotel_book hb = new Hotel_book();
				 hb.setHbook_id(rs.getInt(1));
				 hb.setHotel_name(rs.getString(2));
				 hb.setCity(rs.getString(3));
				 hb.setRoom_type(rs.getString(4));
				 hb.setHotel_type(rs.getString(5));
				 hb.setNo_of_rooms(rs.getInt(6));
				 hb.setCust_id(rs.getInt(7));
				 
				 list_h.add(hb);
			 }
			 
			 
		}catch (Exception e) {System.out.println(e);}
		return list_h;
		
	}

	public static int delete(int id) {
		int status=0;
		try {
			Connection con = TourUtil.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from hotel_book where hbook_id=?");
			 ps.setInt(1,id);
			
			 status = ps.executeUpdate();
		}
		catch(Exception ex) {}
		return status;
	}

}
