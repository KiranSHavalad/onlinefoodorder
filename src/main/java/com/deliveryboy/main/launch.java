package com.deliveryboy.main;

import java.util.List;
import java.util.Scanner;

import com.deliveryboy.daoimp.deliveryboydaoimp;
import com.deliveryboy.model.deliveryboy;

public class launch {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
          deliveryboy boy = new deliveryboy();
          deliveryboydaoimp bim = new deliveryboydaoimp();
          
          System.out.println("enter userphone");
          long uid = sc.nextLong();
          System.out.println("enter resturantphone");
          long rid = sc.nextLong();
//          System.out.println("enter ua");
//          String ua= sc.next();
          
          System.out.println(bim.add("kiran","dvg",uid,"resturanta","dvg",rid,1));
       
         
          
	}

}
