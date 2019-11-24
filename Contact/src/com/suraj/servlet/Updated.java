package com.suraj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suraj.beans.Contact;
import com.suraj.dao.ContactDao;

public class Updated extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Updated() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Contact contact = new Contact();
		int id = Integer.parseInt(request.getParameter("id"));
		String name =request.getParameter("name");
		String mobno =request.getParameter("mobno");
		String email =request.getParameter("email");
		
		contact.setId(id);
		contact.setName(name);
		contact.setMobno(mobno);
		contact.setEmail(email);
		
		
		
		ContactDao cd = new ContactDao();
		cd.update(contact);
		
		PrintWriter pw = response.getWriter();
		pw.write("<h1> Contact delete successfully</h1>");
		pw.write("<a href='Index.html'>Welcome</a>");
		
		response.sendRedirect("AllContact");
		
	}


}
