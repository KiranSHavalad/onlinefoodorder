package com.orderhistory.main;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.orderhistory.daoimp.orderhistorydaoimp;
import com.orderhistory.model.Orderhistory;

public class launch {

	public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.print("enter userid");
	   int userid = sc.nextInt();
//	   System.out.println("enter orderid");
//	   int orderid = sc.nextInt();
//	   System.out.println("enter orderdate");
//	   String od = sc.next();
//	   Date orderdate = Date.valueOf(od);
//	   System.out.println("enter totalamount");
//	   int totalamount = sc.nextInt();
//	   System.out.println("enter status");
//	   String status = sc.next();
	   
	   Orderhistory oh = new Orderhistory();
	   orderhistorydaoimp oi= new orderhistorydaoimp();
	   
	   List<Orderhistory> list = oi.getAll(userid);
	   for(Orderhistory or : list) {
	   
	   System.out.println(or);
	   }
	   

	}

}
