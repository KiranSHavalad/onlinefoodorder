package com.ordershow;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.daoimp.orderimp;
import com.order.model.Order;

@WebServlet("/ordershow")
public class ordershowservlet extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			Order or = new Order();
			orderimp oi = new orderimp();
			String restid = request.getParameter("resturantid");
			int resturantid = Integer.parseInt(restid);
			
			
			
			 List<Order> list = oi.getAll(resturantid);
			 
			 request.setAttribute("resturantid",resturantid);
			 request.setAttribute("orderlist", list);
			 RequestDispatcher rd = request.getRequestDispatcher("ordershow.jsp");
			 rd.forward(request, response);
			 
			
			
	}

}
