package com.resturant;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rest.daoimp.Resturantimp;
import com.rest.model.Resturant;

@WebServlet("/addresturant")
public class addresturantservlet extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String rt = req.getParameter("rating");
		float rating = Float.parseFloat(rt);
		String cusinetype = req.getParameter("cusinetype");
		String isactive = req.getParameter("isactive");
		String et = req.getParameter("eta");
		int eta = Integer.parseInt(et);
		String imagepath = req.getParameter("imagepath");
		
		String resturantid = req.getParameter("resturantid");
		int rid = Integer.parseInt(resturantid);
		
		Resturant r = new Resturant();
		Resturantimp ri = new Resturantimp();
		
		ri.updateR(rating, cusinetype, isactive, eta, imagepath, rid);
		
	    req.setAttribute("resturantid", rid);
		RequestDispatcher rd = req.getRequestDispatcher("resturant");
		rd.forward(req, res);
		
		
	}

}
