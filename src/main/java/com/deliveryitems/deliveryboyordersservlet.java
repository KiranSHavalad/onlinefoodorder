package com.deliveryitems;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.imp.userimp;
import com.deliveryboy.daoimp.deliveryboydaoimp;
import com.deliveryboy.model.deliveryboy;
import com.rest.daoimp.Resturantimp;
import com.rest.model.Resturant;
import com.userpackage.user;

@WebServlet("/deliveryorders")
public class deliveryboyordersservlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String did = request.getParameter("id");
		  int id = Integer.parseInt(did);
		  String userid = request.getParameter("userid");
		  int uid = Integer.parseInt(userid);
		  String resturantid = request.getParameter("resturantid");
		  int rid = Integer.parseInt(resturantid);
		  String orderdate = request.getParameter("orderdate");
		  
		  
		  
		  user u = new user();
		  userimp us = new userimp();
		  
		  String username =  us.getName(uid);
		  String useraddress = us.getAddress(uid);
		  long userphone = us.getPhone(uid);
		  
		    Resturant r = new Resturant();
			Resturantimp imp = new Resturantimp();
			
			String resturantname = imp.getName(rid);
			String resturantaddress = imp.getAddress(rid);
			long resturantphone = imp.getPhone(rid);
			
			deliveryboydaoimp dimp = new deliveryboydaoimp();
			deliveryboy boy = new deliveryboy();
			
			dimp.add(username, useraddress, userphone, resturantname, resturantaddress, resturantphone, id);
			
			RequestDispatcher rd = request.getRequestDispatcher("");
			rd.forward(request, response);
		  
		 
		  
		  
	}

}
