package com.home;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rest.daoimp.Resturantimp;
import com.rest.model.Resturant;
@WebServlet("/home1")
public class homeservlet1 extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Resturant re = new Resturant();
		Resturantimp imp = new Resturantimp();
		
		List<Resturant> ri = imp.getAll();
		int userid = (int) req.getAttribute("userid");
		req.setAttribute("userid", userid);
		req.setAttribute("listofresturant", ri);
		
		RequestDispatcher rd = req.getRequestDispatcher("home1.jsp");
		
		rd.forward(req,res);
	}

	

}
