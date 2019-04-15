package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDao;
import pojo.ContactInfo;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		
		String n = request.getParameter("name");
		String e = request.getParameter("email");
		String p = request.getParameter("phone");
		long phn = Long.parseLong(p);
		String msg = request.getParameter("feedback");
		
		ContactInfo cinfo = new ContactInfo();
		cinfo.setName(n);
		cinfo.setEmail_id(e);
		cinfo.setPhone_no(phn);
		cinfo.setMessage(msg);
		
		ContactDao cd = new ContactDao();
		int status = cd.contactAdmin(cinfo);
		
		if(status>0) {
        	pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Thank you for contacting us!');");
				pw.println("location='index.jsp';");
				pw.println("</script>");
         }else{
			 pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Contact details error');");
				pw.println("location='contact.jsp';");
				pw.println("</script>");
		}
		pw.close();
	}

}
