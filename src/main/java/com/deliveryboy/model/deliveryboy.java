package com.deliveryboy.model;

public class deliveryboy {
	private int id;
	private String name;
	private long phone;
	private String address;
	private String email;
	private String password;
	private String username;
	private String useraddress;
	private long userphone;
	private String resturantname;
	private String restutantaddress;
	private long resturantphone;
	
	
	
	public deliveryboy() {
		// TODO Auto-generated constructor stub
	}



	public deliveryboy(String name, long phone, String address, String email, String password) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.password = password;
	}

    
	

	public String getUseraddress() {
		return useraddress;
	}



	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public long getUserphone() {
		return userphone;
	}



	public void setUserphone(long userphone) {
		this.userphone = userphone;
	}



	public String getResturantname() {
		return resturantname;
	}



	public void setResturantname(String resturantname) {
		this.resturantname = resturantname;
	}



	public String getRestutantaddress() {
		return restutantaddress;
	}



	public void setRestutantaddress(String restutantaddress) {
		this.restutantaddress = restutantaddress;
	}



	public long getResturantphone() {
		return resturantphone;
	}



	public void setResturantphone(long resturantphone) {
		this.resturantphone = resturantphone;
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



	@Override
	public String toString() {
		return "deliveryboy [name=" + name + ", phone=" + phone + ", address=" + address + ", email=" + email
				+ ", password=" + password + "]";
	}
	

}
