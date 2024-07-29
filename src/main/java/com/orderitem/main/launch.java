package com.orderitem.main;

import java.util.Scanner;

import com.orderitem.daoimp.orderitemimp;
import com.orderitem.model.Orderitem;

public class launch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter orderid");
		int orderid = sc.nextInt();
		System.out.println("enter menuid");
		int menuid = sc.nextInt();
		System.out.println("enter quantity");
		int quantity = sc.nextInt();
		System.out.println("enter total price");
		int totalprice = sc.nextInt();
		
		Orderitem oi = new Orderitem(orderid,menuid,quantity, totalprice);
		orderitemimp or = new orderitemimp();
		
		System.out.println(or.save(oi));
		

	}

}
