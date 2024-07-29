package com.deliveryitems;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deliveryboy.daoimp.deliveryboydaoimp;
import com.deliveryboy.model.deliveryboy;

@WebServlet("/delivery")
public class deliveryservlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String resturantid = request.getParameter("resturantid");
		String orderdate = request.getParameter("orderdate");
		
		
		deliveryboy boy = new deliveryboy();
		deliveryboydaoimp dimp = new deliveryboydaoimp();
		
	    List<deliveryboy> db  = dimp.getAll();
	    
	    request.setAttribute("orderdate",orderdate);
	    request.setAttribute("resturantid",resturantid);
	    request.setAttribute("userid",userid);
	    request.setAttribute("deliveryboy", db);
	    RequestDispatcher rd = request.getRequestDispatcher("delivery.jsp");
	    rd.forward(request, response);
		
	}

}
