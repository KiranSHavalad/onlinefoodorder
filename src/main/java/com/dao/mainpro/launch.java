package com.dao.mainpro;

import java.sql.Date;
import java.util.Scanner;

import com.dao.imp.userimp;
import com.userpackage.user;
import com.dao.*;
import com.*;

public class launch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.print("enter name");
//		String name = sc.next();
//		System.out.print("enter email");
//		String email = sc.next();
//		System.out.print("enter password");
//		String  pass = sc.next();
//		System.out.print("enter phone");
//		long phone = sc.nextLong();
//		System.out.print("enter address");
//		String address = sc.next();
//		System.out.print("enter role");
//		String role = sc.next();
//		System.out.print("enter createdDate");
//		String cud=sc.next();
//		Date currentDate = Date.valueOf(cud);
//		System.out.print("enter lastlogindate");
//		String lastlogn = sc.next();
//		Date lastlogindate = Date.valueOf(lastlogn);
		
		int id = sc.nextInt();
		
		userimp us = new userimp();
//		user u = new user(name,email,pass,phone,address,role);
//		
//		int i = us.save(u);
		
		user u = new user();
//		System.out.print("enter email");
//		String email = sc.next();
//		
//		
//		System.out.print(us.delete(email));
		
//		System.out.print(us.getUp(email, pass));
//		System.out.print(us.updatelastlogindate(email));
		
//		System.out.print(us.getid(email, pass));
		System.out.print(us.getName(id));
		System.out.print(us.getAddress(id));
		System.out.print(us.getPhone(id));
		
	}

}
