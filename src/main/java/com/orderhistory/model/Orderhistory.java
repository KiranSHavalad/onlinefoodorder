package com.orderhistory.model;

import java.sql.Date;

public class Orderhistory {
	private int orderhistoryid;
	private int userid;
	private int orderid;
	private Date orderdate;
	private int totalamount;
	private String status;
	private String itemname;
	
	public Orderhistory() {
		// TODO Auto-generated constructor stub
	}

	public Orderhistory(int userid,String itemname, int totalamount, String status) {
		super();
		this.userid = userid;
		this.orderid = orderid;
		this.totalamount = totalamount;
		this.status = status;
		this.itemname = itemname;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public int getOrderhistoryid() {
		return orderhistoryid;
	}

	public void setOrderhistoryid(int orderhistoryid) {
		this.orderhistoryid = orderhistoryid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public int getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Orderhistory [orderhistoryid=" + orderhistoryid + ", userid=" + userid + ", itemname=" + itemname
				+ ", orderdate=" + orderdate + ", totalamount=" + totalamount + ", status=" + status + "]";
	}
	
	

}
