package com.addmenu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.menu.daoimp.menuimp;
import com.menu.model.Menu;

@WebServlet("/deleteitems")
public class deleteitemsservlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String restid = request.getParameter("resturantid");
		 int resturantid = Integer.parseInt(restid);
		 
		 
		 Menu m = new Menu();
		 menuimp mi = new menuimp();
		 
		 mi.delete(resturantid);
		 
		 request.setAttribute("resturantid", resturantid);
		 RequestDispatcher rd = request.getRequestDispatcher("resturant");
		 rd.forward(request, response);
		 
		 
	}

}
