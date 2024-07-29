package com.menu.model;

public class Menu {
    private int menuid;
    private int resturantid;
    private String itemname;
    private String description;
    private int price;
    private float rating;
    private String isavailable;
    private String imagepath;
    
    public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Menu(int resturantid, String itemname, String description, int price, float rating, String isavailable,
			String imagepath) {
		super();
		this.resturantid = resturantid;
		this.itemname = itemname;
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.isavailable = isavailable;
		this.imagepath = imagepath;
	}

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public int getResturantid() {
		return resturantid;
	}

	public void setResturantid(int resturantid) {
		this.resturantid = resturantid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getIsavailable() {
		return isavailable;
	}

	public void setIsavailable(String isavailable) {
		this.isavailable = isavailable;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	@Override
	public String toString() {
		return "Menu [menuid=" + menuid + ", resturantid=" + resturantid + ", itemname=" + itemname + ", description="
				+ description + ", price=" + price + ", rating=" + rating + ", isavailable=" + isavailable
				+ ", imagepath=" + imagepath + "]";
	}
    
    
    
}
