package com.cart;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cartitems")
public class cartitemsservlet extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	int usid = (int) getServletContext().getAttribute("userid");
	
	HashMap<Integer,Cartitem> cm = (HashMap<Integer, Cartitem>) getServletContext().getAttribute("cartitem");
	
	
	req.setAttribute("userid", usid);
	req.setAttribute("cartitem", cm);
	RequestDispatcher re = req.getRequestDispatcher("cart.jsp");
	
	re.forward(req, res);
	
	
	
	
	
	
	}

}
