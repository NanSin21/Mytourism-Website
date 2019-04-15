package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FlightDao;
import pojo.Customer;
import pojo.FlightBook;

/**
 * Servlet implementation class fbookservlet
 */
@WebServlet("/fbookservlet")
public class fbookservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        
    	HttpSession session=request.getSession(false);
		 Customer cc=(Customer)session.getAttribute("customer");		
	
        
        String f= request.getParameter("from_loc");
        String t= request.getParameter("to_loc");
        String n= request.getParameter("no_passengers");
        int nop= Integer.parseInt(n);
        String d=request.getParameter("depart");
        SimpleDateFormat dep = new SimpleDateFormat("dd/mm/yyyy");
        String c = request.getParameter("f_class");
       
        FlightBook fb = new FlightBook();
        fb.setFrom_loc(f);
        fb.setTo_loc(t);
        fb.setNo_passengers(nop);
        fb.setCust_id(cc.getCust_id());
        fb.setF_class(c);
        try {
        	java.util.Date prs = dep.parse(d);
     	   java.sql.Date sql= new java.sql.Date(prs.getTime());
     	   fb.setDeparture_date(sql);; 
        }
        catch(Exception ex) {
        	System.out.println("error in manufacture date");
            ex.printStackTrace();
        }
        
        FlightDao cd = new FlightDao();
        int status = cd.saveFlightbook(fb);
        
        if(status>0) {
       	pw.println("<script type=\"text/javascript\">");
			pw.println("alert('You have successfully booked a flight, Thank You for choosing our website!');");
			pw.println("location='profile.jsp';");
			pw.println("</script>");
        }else{
			 pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Booking error, please try once more');");
			pw.println("location='fbook.jsp';");
			pw.println("</script>");
	}
	pw.close();
	}

}
