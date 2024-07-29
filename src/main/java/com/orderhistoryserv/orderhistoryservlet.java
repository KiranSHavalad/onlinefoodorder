package com.orderhistoryserv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orderhistory.daoimp.orderhistorydaoimp;
import com.orderhistory.model.Orderhistory;

@WebServlet("/orderhistory")
public class orderhistoryservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Orderhistory oh = new Orderhistory();
		orderhistorydaoimp ohi = new orderhistorydaoimp();
		String usid = request.getParameter("userid");
		int userid = Integer.parseInt(usid);
		List<Orderhistory>  ohr = ohi.getAll(userid);
		request.setAttribute("userid", userid);
		request.setAttribute("orderhistory", ohr);
		RequestDispatcher rd = request.getRequestDispatcher("orderhistory.jsp");
		rd.forward(request, response);
		
		
	}

}
