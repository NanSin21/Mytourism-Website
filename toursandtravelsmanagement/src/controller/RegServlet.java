package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import pojo.Customer;


@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        
        String f=request.getParameter("Firstname");  
        String l=request.getParameter("Lastname");  
        String e=request.getParameter("Email");  
        String g=request.getParameter("gender"); 
        String m=request.getParameter("mb_no"); 
        long mb_no = Long.parseLong(m);
        String d=request.getParameter("dob");
        SimpleDateFormat dob = new SimpleDateFormat("yyyy-MM-dd");
        String p=request.getParameter("password");
        String r=request.getParameter("repwd");
        if(p.equals(r)) {
        	 Customer cs= new Customer();
             cs.setFirstname(f);
             cs.setLastname(l);
             cs.setEmail(e);
             cs.setGender(g);
             cs.setMb_no(mb_no);
             cs.setPassword(p);
              
             try {
            	   
            	   java.util.Date parsed = dob.parse(d);
            	   java.sql.Date sqlmfd= new java.sql.Date(parsed.getTime());
            	   cs.setDob(sqlmfd);            	   
               }
               catch(Exception ex) {
            	   System.out.println("error in manufacture date");
                       ex.printStackTrace();
               }
               
               
             CustomerDao cd = new CustomerDao();
             int status = cd.saveCustomer(cs);
             
             if(status>0) {
            	pw.println("<script type=\"text/javascript\">");
 				pw.println("alert('you are successfully registered, Thank You');");
 				pw.println("location='login.jsp';");
 				pw.println("</script>");
             }else{
    			 pw.println("<script type=\"text/javascript\">");
 				pw.println("alert('Registration error, please try once more');");
 				pw.println("location='registration.jsp';");
 				pw.println("</script>");
 		}
 		pw.close();
             
                       }
        
       
        
        
        
        
	}
}


