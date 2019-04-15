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

import dao.TrainDao;
import pojo.Customer;
import pojo.Train_Book;


@WebServlet("/tbookservlet")
public class tbookservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
        String c = request.getParameter("t_class");
        
        Train_Book tb = new Train_Book();
        tb.setFrom_loc(f);
        tb.setTo_loc(t);
        tb.setNo_passengers(nop);
        tb.setCust_id(cc.getCust_id());
        tb.setT_class(c);
        try {
        	java.util.Date prs = dep.parse(d);
     	   java.sql.Date sql= new java.sql.Date(prs.getTime());
     	   tb.setDeparture_date(sql);; 
        }
        catch(Exception ex) {
        	System.out.println("error in manufacture date");
            ex.printStackTrace();
        }
        
        TrainDao cd = new TrainDao();
        int status = cd.saveTrainbook(tb);
        
        if(status>0) {
       	pw.println("<script type=\"text/javascript\">");
			pw.println("alert('You have successfully booked a train, Thank You for choosing our website!');");
			pw.println("location='profile.jsp';");
			pw.println("</script>");
        }else{
			 pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Booking error, please try once more');");
			pw.println("location='tbook.jsp';");
			pw.println("</script>");
	}
	pw.close();
        
	}

}
