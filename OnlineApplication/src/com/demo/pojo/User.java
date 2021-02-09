package com.demo.pojo;

public class User {
	private int id;
	private String fname;
	private String lname;
	private String address;
	private String email;
	private String password;
	private String phone;
	private String role;

	public User() {
		super();
	}

	public User(int id, String fname, String lname, String address, String email, String password, String phone,
			String role) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.role = role;
	}

	public User(String fname, String lname, String address, String email, String password, String phone, String role) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fname=" + fname + ", lname=" + lname + ", address=" + address + ", email=" + email
				+ ", password=" + password + ", phone=" + phone + ", role=" + role + "]";
	}

}
