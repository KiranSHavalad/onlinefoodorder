package com.cart;

public class Cartitem {
	private int itemid;
	private String itemname;
	private int quantity;
	private int price;
	private int resturantid;
	private int qprice;
	
	public Cartitem() {
		// TODO Auto-generated constructor stub
	}

	public Cartitem(int itemid, String itemname, int quantity, int price, int resturantid) {
		super();
		this.itemid = itemid;
		this.itemname = itemname;
		this.quantity = quantity;
		this.price = price;
		this.resturantid = resturantid;
		this.qprice = quantity * price;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getResturantid() {
		return resturantid;
	}

	public void setResturantid(int resturantid) {
		this.resturantid = resturantid;
	}

	public int getQprice() {
		return qprice;
	}

	public void setQprice(int qprice) {
		this.qprice = qprice;
	}

	@Override
	 public String toString() {
        return    itemname +"\n"
        		 + "Quantity:"+quantity + "\n" 
        		+ "Price:"
        		+ qprice;
    }
	
	

}
