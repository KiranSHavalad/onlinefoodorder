package com.rest.model;

public class Resturant {
	
	private int resturantid;
	private String name;
	private String address;
	private long phone;
	private float rating;
	private String cusinetype;
	private String isactive;
	private int eta;
	private int userid;
	private String imagepath;
	private String email;
	private String password;
	
	public Resturant() {
		
	}

	public Resturant( String name, String address, long phone, float rating, String cusinetype,
			String isactive, int eta, int userid, String imagepath,String email,String password) {
		super();
//		this.resturantid = resturantid;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.rating = rating;
		this.cusinetype = cusinetype;
		this.isactive = isactive;
		this.eta = eta;
		this.userid = userid;
		this.imagepath = imagepath;
		this.email = email;
		this.password = password;
	}

	public int getResturantid() {
		return resturantid;
	}

	public void setResturantid(int resturantid) {
		this.resturantid = resturantid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getCusinetype() {
		return cusinetype;
	}

	public void setCusinetype(String cusinetype) {
		this.cusinetype = cusinetype;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	@Override
	public String toString() {
		return "Resturant [resturantid="+resturantid+ " ,name=" + name + ", address=" + address + ", phone=" + phone
				+ ", rating=" + rating + ", cusinetype=" + cusinetype + ", isactive=" + isactive + ", eta=" + eta
				+ ", userid=" + userid + ", imagepath=" + imagepath + "]";
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
}
