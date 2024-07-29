package com.orderitem.model;

public class Orderitem {
	private int orderitemid;
	private int oderid;
	private int menuid;
	private int quantity;
	private int totalprice;
	
	public Orderitem() {
	
	}

	public Orderitem(int oderid, int menuid, int quantity, int totalprice) {
		super();
		this.oderid = oderid;
		this.menuid = menuid;
		this.quantity = quantity;
		this.totalprice = totalprice;
	}

	public int getOrderitemid() {
		return orderitemid;
	}

	public void setOrderitemid(int orderitemid) {
		this.orderitemid = orderitemid;
	}

	public int getOderid() {
		return oderid;
	}

	public void setOderid(int oderid) {
		this.oderid = oderid;
	}

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	@Override
	public String toString() {
		return "Orderitem [orderitemid=" + orderitemid + ", oderid=" + oderid + ", menuid=" + menuid + ", quantity="
				+ quantity + ", totalprice=" + totalprice + "]";
	}
	
	
	

}
