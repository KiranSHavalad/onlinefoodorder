package com.cart;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter itemid");
		int itemid = sc.nextInt();
		System.out.println("enter itemname");
		String itemname = sc.next();
		System.out.println("enter quantity");
		int quantity = sc.nextInt();
		System.out.println("enter price");
		int price = sc.nextInt();
		System.out.println("enter resturantid");
		int resturantid = sc.nextInt();
		Cartitem  ci = new Cartitem(itemid,itemname,quantity,price,resturantid);
		Cartcreator cr = new Cartcreator();
		
//		cr.additemcart(ci);
//	     System.out.print("enter new quantity");
//	     int qib = sc.nextInt();
//		cr.update(ci,qib);
		
		HashMap<Integer,Cartitem> map = cr.additemcart(ci);
		
		for(Map.Entry<Integer,Cartitem> entry : map.entrySet()) {
		        Cartitem item = entry.getValue();
		        System.out.println(item);
		}
	
//		System.out.println("enter itemid");
//		
//		cr.delete(cr.additemcart(ci),itemid);
//		
//		
//		for(Map.Entry<Integer,Cartitem> entry : map.entrySet()) {
//	        Cartitem item = entry.getValue();
//	        System.out.println(item);
	}

	}


