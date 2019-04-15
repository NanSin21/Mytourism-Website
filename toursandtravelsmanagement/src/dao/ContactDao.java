package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import pojo.ContactInfo;
import util.TourUtil;

public class ContactDao {

	public int contactAdmin(ContactInfo cinfo) {
		int status = 0;
		try {
			Connection con = TourUtil.getConnection();
			 PreparedStatement ps=con.prepareStatement("insert into contact(name, email_id, phone_no, message) values(?, ?, ?, ?)");
			 ps.setString(1, cinfo.getName());
 			 ps.setString(2, cinfo.getEmail_id());
			 ps.setLong(3, cinfo.getPhone_no());
			 ps.setString(4, cinfo.getMessage());
			 status = ps.executeUpdate();
		}
		catch(Exception e) {}
		return status;
	}
	}
