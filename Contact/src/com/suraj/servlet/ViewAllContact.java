package com.suraj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suraj.beans.Contact;
import com.suraj.dao.ContactDao;

public class ViewAllContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewAllContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ContactDao cd = new ContactDao();
		List<Contact> contactList = cd.getAll();
		
		PrintWriter pw = response.getWriter();
		
		pw.write("<h1>View All Contact </h1><br><br>");
		pw.write("<table border='2'>");
		pw.write("<tr>");
		pw.write("<th>id</th>");
		pw.write("<th>name</th>");
		pw.write("<th>mobno</th>");
		pw.write("<th>email</th>");
		pw.write("<th>edit</th>");
		pw.write("<th>delete</th>");
		pw.write("</tr>");
		
		for(Contact c : contactList) {
			pw.write("<tr>");
			pw.write("<td>"+c.getId()+"</td>");
			pw.write("<td>"+c.getName()+"</td>");
			pw.write("<td>"+c.getMobno()+"</td>");
			pw.write("<td>"+c.getEmail()+"</td>");
			pw.write("<td><a href = 'UpdateContact?id="+c.getId()+"'>Edit</a></td>");
			pw.write("<td><a href = 'DeleteContact?id="+c.getId()+"'>delete</a></td>");
			pw.write("</tr>");
		}
		
		pw.write("</table><br><br>");
		
		pw.write("<a href='Index.html'>Welcome</a>");
	}
}
