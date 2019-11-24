package com.suraj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suraj.beans.Contact;
import com.suraj.dao.ContactDao;

public class DeleteContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteContact() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		int id =Integer.parseInt(request.getParameter("id"));
		
		Contact contact = new Contact();
		contact.setId(id);
		
		ContactDao cd = new ContactDao();
		cd.delete(contact);
		
		PrintWriter pw = response.getWriter();
		pw.write("<h1> Contact delete successfully</h1>");
		pw.write("<a href='Index.html'>Welcome</a>");
		
		response.sendRedirect("AllContact");
		
	}

}
