package com.suraj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.suraj.beans.Contact;


public class ContactDao {
	
	public void save(Contact contact) {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","");
			
			String sql = "insert into contact(name,mobno,email) values(?,?,?)";
			
			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setString(1, contact.getName());
			pst.setString(2, contact.getMobno());
			pst.setString(3, contact.getEmail());
			
			pst.executeUpdate();

			connection.close();
		}
		
		catch(Exception e) {
			e.getStackTrace();
		}
		
	}


	public List<Contact> getAll(){
		
		List<Contact> mycontact = new ArrayList<Contact>();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","");
			
			String sql = "select * from contact";
			
			PreparedStatement pst = connection.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Contact contact = new Contact();
				contact.setId(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setMobno(rs.getString("mobno"));
				contact.setEmail(rs.getString("email"));
				
				mycontact.add(contact);
			}	
			connection.close();
		}
		
		catch(Exception e1) {
			e1.getStackTrace();
		}
		
		return mycontact;
	}
	
	public void delete(Contact contact) {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","");
			
			String sql = "delete from contact where id=?";

			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setInt(1, contact.getId());
			
			pst.executeUpdate();

			connection.close();
		}
		
		catch(Exception e) {
			e.getStackTrace();
		}
		
	}

	public void update(Contact contact) {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","");
			
			String sql = "update contact set name=?,mobno=?,email=? where id=?";

			PreparedStatement pst = connection.prepareStatement(sql);
			
			
			pst.setString(1, contact.getName());
			pst.setString(2, contact.getMobno());
			pst.setString(3, contact.getEmail());
			pst.setInt(4, contact.getId());
			
			pst.executeUpdate();

			connection.close();
		}
		
		catch(Exception e) {
			e.getStackTrace();
		}
		
	}
	
	public void edit(Contact contact) {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","");
			
			String sql = "select * from contact where id=?";

			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setInt(1, contact.getId());
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				contact.setId(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setMobno(rs.getString("mobno"));
				contact.setEmail(rs.getString("email"));
				
			}
			connection.close();
		}
		
		catch(Exception e) {
			e.getStackTrace();
		}
		
	}

}

