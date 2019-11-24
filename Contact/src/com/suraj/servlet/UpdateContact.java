package com.suraj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suraj.beans.Contact;
import com.suraj.dao.ContactDao;

public class UpdateContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateContact() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		int id =Integer.parseInt(request.getParameter("id"));
		
		Contact contact = new Contact();
		contact.setId(id);
		
		ContactDao cd = new ContactDao();
		cd.edit(contact);
		
		PrintWriter pw = response.getWriter();
		pw.write("Update contact");
		
		pw.write("<br><br>");
		pw.write("<form action='Updated'>");
		pw.write(" <input type='hidden' name='id' value="+contact.getId()+"><br><br>");
		pw.write("name :<input type='text' name='name' value="+contact.getName()+"><br><br>");
		pw.write("mobno :<input type='text' name='mobno' value="+contact.getMobno()+"><br><br>");
		pw.write("email :<input type='text' name='email' value="+contact.getEmail()+"><br><br>");
		
		pw.write("<input type='submit' value='update'");
		pw.write("</from>");
		cd.update(contact);
	}


}
