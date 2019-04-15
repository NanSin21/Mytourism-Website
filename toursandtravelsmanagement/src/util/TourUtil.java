package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class TourUtil {

	static Connection con;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tourdb", "root", "");
		}
		catch(Exception e) {System.out.println(e);}
	}
public static Connection getConnection() {
	return con;
	
}

}

