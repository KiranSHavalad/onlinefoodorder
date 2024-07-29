package com.addmenu;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.menu.daoimp.menuimp;
import com.menu.model.Menu;

@WebServlet("/additems")
public class addmenuservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String restid = request.getParameter("resturantid");
		int resturantid = Integer.parseInt(restid);
		String itemname = request.getParameter("itemname");
		String description = request.getParameter("description");
		String pr = request.getParameter("price");
		int price = Integer.parseInt(pr);
		String ra = request.getParameter("rating");
		float rating = Float.parseFloat(ra);
		String isavailable = request.getParameter("isavailable");
		String imagepath = request.getParameter("imagepath");
		
		

		Menu m = new Menu(resturantid,itemname,description,price,rating,isavailable,imagepath);
		menuimp mi = new menuimp();
		mi.save(m);
		

		List<Menu> mli = mi.getAll(resturantid);
		
		request.setAttribute("resturantid", resturantid);
		request.setAttribute("menu", mli);
		RequestDispatcher rd = request.getRequestDispatcher("resturant.jsp");
		rd.forward(request, response);
		
		
		
		
		
	}

}
