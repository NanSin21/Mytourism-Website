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


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        String sid=request.getParameter("cust_id");  
	        int cid=Integer.parseInt(sid);  
	        String fn=request.getParameter("firstname");  
	        String ln=request.getParameter("lastname");
	        String pwd=request.getParameter("password");  
	        String el=request.getParameter("email");  
	        String gr=request.getParameter("gender"); 
	        String m=request.getParameter("mb_no"); 
	        long mb_no = Long.parseLong(m);
	        String d=request.getParameter("dob");
	        SimpleDateFormat dob1 = new SimpleDateFormat("yyyy-MM-dd");
	        Customer cs= new Customer();
	        cs.setCust_id(cid);
            cs.setFirstname(fn);
            cs.setLastname(ln);
            cs.setEmail(el);
            cs.setGender(gr);
            cs.setMb_no(mb_no);
            cs.setPassword(pwd); 
	        try {
         	   
         	   java.util.Date parsed = dob1.parse(d);
         	   java.sql.Date sqlmfd= new java.sql.Date(parsed.getTime());
         	   cs.setDob(sqlmfd);            	   
            }
            catch(Exception ex) {
         	   System.out.println("error in manufacture date");
                    ex.printStackTrace();
            }
             
	        /*int status=*/
	       CustomerDao.update(cs);
	        request.getRequestDispatcher("profile.jsp").forward(request, response);
	       /* if(status>0){  
	          
	          out.println("<script type=\"text/javascript\">");
				out.println("alert('you are successfully logged in, Thank You');");
				out.println("location='profile.jsp';");
				out.println("</script>");
	        }else{  
	        	 out.println("<script type=\"text/javascript\">");
					out.println("alert('Profile not updated');");
					out.println("location='profile.jsp';");
					out.println("</script>"); 
	        }  */
	          
	       
	    }  
	}

