package com.userpackage;

import java.util.Date;

public class user {
	private int id;
	private String name;
	private String email;
	private String password;
	private long phone;
	private String address;
	private String role;
	private Date createdDate;
	private Date lastloginDate;
	
	public user() {
		// TODO Auto-generated constructor stub
	}

	public user(String name, String email, String password, long phone, String address, String role
			) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.role = role;
//		this.createdDate = createdDate;
//		this.lastloginDate = lastloginDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastloginDate() {
		return lastloginDate;
	}

	public void setLastloginDate(Date lastloginDate) {
		this.lastloginDate = lastloginDate;
	}

	@Override
	public String toString() {
		return "user [name=" + name + ", email=" + email + ", password=" + password + ", phone=" + phone + ", address="
				+ address + ", role=" + role + ", createdDate=" + createdDate + ", lastloginDate=" + lastloginDate
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	

}
