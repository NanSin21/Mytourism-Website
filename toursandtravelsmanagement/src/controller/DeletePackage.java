package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PackageDao;

/**
 * Servlet implementation class DeletePackage
 */
@WebServlet("/DeletePackage")
public class DeletePackage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out  = response.getWriter();
		 String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	        int status= PackageDao.delete(id);  
	        if(status>0) {
	        	 out.println("<script type=\"text/javascript\">");
					out.println("alert('Your package has been cancelled!');");
					out.println("location='profile.jsp';");
					out.println("</script>");
	        }
	        else 
			{
				 out.println("<script type=\"text/javascript\">");
					out.println("alert('Your package has not been cancelled!');");
					out.println("location='profile.jsp';");
					out.println("</script>");
			}
	}

}
