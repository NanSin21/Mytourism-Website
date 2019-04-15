package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import pojo.Customer;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out  = response.getWriter();
		String email=request.getParameter("email");  
		String password=request.getParameter("password");
		
		Customer customer = CustomerDao.loginCustomer(email, password);
		
		if(customer.getEmail()!=null && customer.getPassword()!=null) 
		{
			HttpSession session=request.getSession(true);
			 session.setAttribute("customer", customer);		
			 //response.sendRedirect("home.jsp");
			    out.println("<script type=\"text/javascript\">");
				out.println("alert('you are successfully logged in, Thank You');");
				out.println("location='CustomerHome.jsp';");
				out.println("</script>");
		}
		else 
		{
			 out.println("<script type=\"text/javascript\">");
				out.println("alert('username or password incorrect, please try different');");
				out.println("location='login.jsp';");
				out.println("</script>");
		}
		out.close();
		    
	}

}
