package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HotelDao;
import pojo.Customer;
import pojo.Hotel_book;

@WebServlet("/hbookservlet")
public class hbookservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        
        HttpSession session=request.getSession(false);
		 Customer cc=(Customer)session.getAttribute("customer");
        
        String hn= request.getParameter("hotel_name");
        String ct= request.getParameter("city");
        String no= request.getParameter("no of rooms");
        int nor= Integer.parseInt(no);
        String rt = request.getParameter("room type");
        String ht = request.getParameter("hotel type");
        
        Hotel_book hb = new Hotel_book();
        hb.setHotel_name(hn);;
        hb.setCity(ct);
        hb.setHotel_type(ht);
        hb.setRoom_type(rt);
        hb.setNo_of_rooms(nor);
        hb.setCust_id(cc.getCust_id());
                      
        HotelDao cd = new HotelDao();
        int status = cd.saveHotelbook(hb);
        
        if(status>0) {
       	pw.println("<script type=\"text/javascript\">");
			pw.println("alert('You have successfully booked a hotel, Thank You for choosing our website');");
			pw.println("location='profile.jsp';");
			pw.println("</script>");
        }else{
			 pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Boking error, please try once more');");
			pw.println("location='hbook.jsp';");
			pw.println("</script>");
	}
	pw.close();
        
	}

}
