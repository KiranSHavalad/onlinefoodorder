package com.home;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.imp.userimp;
import com.rest.daoimp.Resturantimp;
import com.rest.model.Resturant;
import com.userpackage.user;

@WebServlet("/hme")
public class hmservlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		userimp ui = new userimp();
		user u = new user();
		
		Resturantimp ri = new Resturantimp();
		Resturant r = new Resturant();
		

		RequestDispatcher rd = request.getRequestDispatcher("home");
		
		rd.forward(request,response);
		
	}

}
