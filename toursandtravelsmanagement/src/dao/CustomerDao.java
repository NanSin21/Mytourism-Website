package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pojo.Customer;
import util.TourUtil;

public class CustomerDao {
	
	
	
	public static Customer loginCustomer(String email,String password)
	{

		Customer c = new Customer();
		try {
		 Connection con = TourUtil.getConnection();
		 PreparedStatement ps=con.prepareStatement(  
				    "select * from customer where email=? and password=?");  
				  
				ps.setString(1,email);  
				ps.setString(2,password);  
				              
				ResultSet rs=ps.executeQuery(); 
				if(rs.next()) 
				{
					c.setCust_id(rs.getInt(1));
					c.setFirstname(rs.getString(2));
					c.setLastname(rs.getString(3));
					c.setEmail(rs.getString(4));
					c.setGender(rs.getString(5));
					c.setMb_no(rs.getLong(6));
					c.setDob(rs.getDate(7));
					c.setPassword(rs.getString(8));
				}
				 
				              
				}catch(Exception e){System.out.println(e);}  
				  
				return c;  
			
	}

	public int saveCustomer(Customer cs) {
		
		int status = 0;
		try {
			 Connection con = TourUtil.getConnection();
			 PreparedStatement ps=con.prepareStatement("insert into customer(firstname, lastname, email, gender, mb_no, dob, password) values(?, ?, ?, ?, ?, ?, ?)");
			 ps.setString(1, cs.getFirstname());
			 ps.setString(2, cs.getLastname());
			 ps.setString(3, cs.getEmail());
			 ps.setString(4, cs.getGender());
			 ps.setLong(5, cs.getMb_no());
			 ps.setDate(6, cs.getDob());
			 ps.setString(7, cs.getPassword());
			 status = ps.executeUpdate();
		}
		catch(Exception ex) {}
		return status;
	}

	public static void update(Customer cs){  
	    /*int status=0;  */
	    try{  
	        Connection con=TourUtil.getConnection();  
	        PreparedStatement ps=con.prepareStatement("update customer set firstname=?, lastname=?, email=?, gender=?, mb_no=?, dob=?, password=? where cust_id=?");  
	        ps.setString(1, cs.getFirstname());
			 ps.setString(2, cs.getLastname());
			 ps.setString(3, cs.getEmail());
			 ps.setString(4, cs.getGender());
			 ps.setLong(5, cs.getMb_no());
			 ps.setDate(6, cs.getDob());
			 ps.setString(7, cs.getPassword());
			 ps.setInt(8, cs.getCust_id());
	        ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	   /* return status; */ 
	}  
	
	public static Customer getRecordById(int cust_id){  
	    Customer cs=null;  
	    try{  
	        Connection con=TourUtil.getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from customer where cust_id=?");  
	        ps.setInt(1,cust_id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            cs= new Customer();  
	            cs.setCust_id(rs.getInt("cust_id"));
	            cs.setFirstname(rs.getString("firstname"));  
	            cs.setLastname(rs.getString("lastname"));
	            cs.setEmail(rs.getString("email"));  
	            cs.setGender(rs.getString("gender"));  
	            cs.setMb_no(rs.getLong("mb_no"));
	            cs.setDob(rs.getDate("dob"));
	            cs.setPassword(rs.getString("password"));
	            
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return cs;  
	}  
}
