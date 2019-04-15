package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojo.Train_Book;
import util.TourUtil;

public class TrainDao {

	public int saveTrainbook(Train_Book tb) {
		int status = 0;
		try {
			Connection con = TourUtil.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into train_book(from_loc, to_loc, departure_date, no_passengers, class, customer_id) values(?, ?, ?, ?, ?, ?)");
			 ps.setString(1, tb.getFrom_loc());
			 ps.setString(2, tb.getTo_loc());
			 ps.setDate(3, tb.getDeparture_date());
			 ps.setInt(4, tb.getNo_passengers());
			 ps.setString(5, tb.getT_class());
			 ps.setInt(6, tb.getCust_id());
			 status = ps.executeUpdate();
		}
		catch(Exception ex) {}
		return status;
	}

	public static List<Train_Book> getbycustid(int cust_id) {
		List<Train_Book> list_t = new ArrayList<Train_Book>();
		try {
			 Connection con = TourUtil.getConnection();
			 PreparedStatement ps=con.prepareStatement(  
					    "select * from train_book where customer_id=?");
			 ps.setInt(1,cust_id);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()) 
			 {
				 Train_Book tb = new Train_Book();
				 tb.setTbook_id(rs.getInt(1));
				 tb.setFrom_loc(rs.getString(2));
				 tb.setTo_loc(rs.getString(3));
				 tb.setDeparture_date(rs.getDate(4));
				 tb.setNo_passengers(rs.getInt(5));
				 tb.setT_class(rs.getString(6));
				 tb.setCust_id(rs.getInt(7));
				 
				 list_t.add(tb);
			 }
			 
			 
		}catch (Exception e) {System.out.println(e);}
		return list_t;
		
	}

	public static int delete(int id) {
		int status=0;
		try {
			Connection con = TourUtil.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from train_book where tbook_id=?");
			 ps.setInt(1,id);
			
			 status = ps.executeUpdate();
		}
		catch(Exception ex) {}
		return status;
	}

}
