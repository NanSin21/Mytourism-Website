package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PackageDao;
import pojo.Customer;
import pojo.Package_book;


@WebServlet("/pbookservlet")
public class pbookservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        
    	HttpSession session=request.getSession(false);
		 Customer cc=(Customer)session.getAttribute("customer");		
	
        
        String n= request.getParameter("pkg_name");
        String p= request.getParameter("pkg_price");
        float pr= Float.parseFloat(p);
       
        Package_book pb = new Package_book();
        pb.setPackage_name(n);
        pb.setPrice(pr);
        pb.setCust_id(cc.getCust_id());
       
        PackageDao cd = new PackageDao();
        int status = cd.savePackagebook(pb);
        
        if(status>0) {
       	pw.println("<script type=\"text/javascript\">");
			pw.println("alert('You have successfully booked a package, Thank You for choosing our website!');");
			pw.println("location='profile.jsp';");
			pw.println("</script>");
        }else{
			 pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Booking error, please try once more');");
			pw.println("location='pbook.jsp';");
			pw.println("</script>");
	}
	pw.close();
	}

}
