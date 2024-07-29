package com.rest.main;

import java.util.List;
import java.util.Scanner;

import com.rest.daoimp.Resturantimp;
import com.rest.model.Resturant;

public class launch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
//		System.out.print("enter name");
//		String name = sc.next();
//		
//		System.out.print("enter address");
//		String address = sc.next();
//		
//		System.out.print("enter phone");
//		long phone = sc.nextLong();
//		
//		System.out.println("enter rating");
//		float rating = sc.nextFloat();
////		
//		System.out.println("enter cusinetype");
//		String cusinetype = sc.next();
////		
//		System.out.println("enter isactive");
//		String isactive = sc.next();
////		
//		System.out.println("enter eta");
//		int eta = sc.nextInt();
////		
////		System.out.print("enter userid");
////		int  userid = sc.nextInt();
////		
//		System.out.println("enter imagepath");
//		String imagepath = sc.next();
////		
//		Resturant rest = new Resturant(name,address,phone,rating,cusinetype,isactive,eta,userid,imagepath);
//		
//		Resturantimp imp = new Resturantimp();
//		int i = imp.save(rest);
//		System.out.print(i);
		
//		System.out.println("email");
//		String email = sc.next();
//		System.out.println("pass");
//		String pass = sc.next();
		
		Resturant r = new Resturant();
		Resturantimp imp = new Resturantimp();
		
//		List<Resturant> re=imp.getAll();
//		
//		for(Resturant res : re) {
//			System.out.println(res);
//		}
	  System.out.println("resturantid");
		int rid = sc.nextInt();
//		
//		System.out.print(imp.updateR(rating,cusinetype, isactive,eta,imagepath, rid));
		System.out.println(imp.getName(rid));
		System.out.println(imp.getAddress(rid));
		System.out.println(imp.getPhone(rid));
		
	}

}
