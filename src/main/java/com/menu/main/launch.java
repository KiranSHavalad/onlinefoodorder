package com.menu.main;

import java.util.List;
import java.util.Scanner;

import com.menu.daoimp.menuimp;
import com.menu.model.Menu;

public class launch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner scc = new Scanner(System.in);
		Scanner sccc = new Scanner(System.in);
		
//		System.out.println("enter resturantid");
//		int resturantid = sc.nextInt();
//		System.out.println("enter itemname");
//		String itemname = sc.next();
//		System.out.println("enter description");
//		String description = sc.nextLine();
//		sc.nextLine();
//		System.out.println("enter price");
//		int price = scc.nextInt();
//		System.out.println("enter rating");
//		float rating = sccc.nextFloat();
//		System.out.println("enter isavailable");
//		String isavailable = sc.next();
//		System.out.println("enter imagepath");
//		String imagepath = sc.next();
//		
//		Menu m = new Menu(resturantid,itemname,description,price,rating,isavailable,imagepath);
//		menuimp mn = new menuimp();
//	    int i = mn.save(m);
//	    System.out.println(i);
		
		
//		System.out.print("enter menuid");
//		int menuid = sc.nextInt();
//	    
//	    int i = mn.delete(menuid);
//	    System.out.print(i);
		
//		Menu m = new Menu();
//		mn.update(m);
		
		
//		System.out.print("enter menuid");
//		int menuid = sc.nextInt();
//		
//		menuimp mu = new menuimp();
//		Menu m = mu.get(menuid);
//		System.out.print(m);
		
//		System.out.println(m.getResturantid()+" "+m.getItemname()+" "+m.getDescription()+" "+m.getPrice()+" "+m.getRating()+" "+m.getIsavailable()+" "+m.getImagepath());
//		System.out.println("enter itemname");
//		String itemname = sc.next();
		menuimp mu = new menuimp();
		Menu m = new Menu();
		
//		System.out.println(mu.update(m));
		System.out.print("enter resturantid");
		int resturantid = sc.nextInt();
		List<Menu> me = mu.getAll(resturantid);
		for(Menu mf : me) {
			System.out.println(mf);
		}
		

	}

}
