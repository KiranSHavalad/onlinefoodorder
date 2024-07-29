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

@WebServlet("/uniquerest")
public class uniquerestservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int resturantid = (int) req.getAttribute("resturantid");
		
		Resturantimp ri = new Resturantimp();
		Resturant re = ri.get(resturantid);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		req.setAttribute("Resturant", re);
		RequestDispatcher rd = req.getRequestDispatcher("resturant.jsp");
		rd.forward(req, res);
	}

}
