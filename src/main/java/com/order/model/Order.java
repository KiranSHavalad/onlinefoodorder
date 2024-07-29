package com.order.model;

import java.util.Date;

public class Order {
     private int orderid;
     private int userid;
     private int resturantid;
     private Date orderdate;
     private int totalamount;
     private String status;
     private String paymentmode;
     
     public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int userid, int resturantid,int totalamount, String status, String paymentmode) {
		super();
		this.userid = userid;
		this.resturantid = resturantid;
		
		this.totalamount = totalamount;
		this.status = status;
		this.paymentmode = paymentmode;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getResturantid() {
		return resturantid;
	}

	public void setResturantid(int resturantid) {
		this.resturantid = resturantid;
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

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", userid=" + userid + ", resturantid=" + resturantid + ", orderdate="
				+ orderdate + ", totalamount=" + totalamount + ", status=" + status + ", paymentmode=" + paymentmode
				+ "]";
	}
     
     
     
}
