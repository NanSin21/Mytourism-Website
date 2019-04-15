package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojo.Package_book;
import util.TourUtil;

public class PackageDao {

	public int savePackagebook(Package_book pb) {
		int status = 0;
		try {
			Connection con = TourUtil.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into package_book(package_name, package_price, customer_id) values(?, ?, ?)");
			 ps.setString(1, pb.getPackage_name());
			 ps.setFloat(2, pb.getPrice());
			 ps.setInt(3, pb.getCust_id());
			
			 status = ps.executeUpdate();
		}
		catch(Exception ex) {System.out.println(ex);}
		return status;
	}

	public static List<Package_book> getbycustid(int cust_id) {
		List<Package_book> list_p = new ArrayList<Package_book>();
		try {
			 Connection con = TourUtil.getConnection();
			 PreparedStatement ps=con.prepareStatement(  
					    "select * from package_book where customer_id=?");
			 ps.setInt(1,cust_id);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()) 
			 {
				 Package_book pb = new Package_book();
				 pb.setPbook_id(rs.getInt(1));
				 pb.setPackage_name(rs.getString(2));
				 pb.setPrice(rs.getFloat(3));
				 pb.setCust_id(rs.getInt(4));
				 
				 list_p.add(pb);
			 }
			 
			 
		}catch (Exception e) {System.out.println(e);}
		return list_p;
		
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = TourUtil.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from package_book where pbook_id=?");
			 ps.setInt(1,id);
			
			 status = ps.executeUpdate();
		}
		catch(Exception ex) {}// TODO Auto-generated method stub
		return status;
	}
}
