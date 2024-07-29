package com.order.main;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.order.daoimp.orderimp;
import com.order.model.Order;

public class launch {

	public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
//	 System.out.println("enter userid");
//	 int userid = sc.nextInt();
	 System.out.println("enter resturantid");
	 int resturantid = sc.nextInt();
////	 System.out.println("enter orderdate");
////	 String od = sc.next();
////	 Date orderdate = Date.valueOf(od);
//	 System.out.println("enter totalamount");
//	 int totalamount = sc.nextInt();
//	 System.out.println("enter status");
//	 String status = sc.next();
//	 System.out.println("enter paymentmode");
//	 String paymentmode = sc.next();
//	
	 Order or = new Order();
	 orderimp imp = new orderimp();
	 
//	 System.out.print(imp.save(or));
	 List<Order> list = imp.getAll(resturantid);
	 
	 for(Order o:list) {
		 System.out.println(o);
	 }

	}

}
