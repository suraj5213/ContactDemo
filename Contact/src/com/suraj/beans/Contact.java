package com.suraj.beans;

public class Contact {
	
	private int id;
	private String name;
	private String mobno;
	private String email;
	
	public Contact() {
		super();
	}

	public Contact(int id, String name, String mobno, String email) {
		super();
		this.id = id;
		this.name = name;
		this.mobno = mobno;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", mobno=" + mobno + ", email=" + email + "]";
	}

		
}
