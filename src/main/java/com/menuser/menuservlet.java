package com.menuser;

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

@WebServlet("/menu1")
public class menuservlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resturantid = request.getParameter("resturantid");
		int restid = Integer.parseInt(resturantid);
		Menu m = new Menu();
		menuimp mi = new menuimp();
		List<Menu> me = mi.getAll(restid);
		request.setAttribute("men", me);
		RequestDispatcher rd = request.getRequestDispatcher("menu1.jsp");
		rd.forward(request, response);
	}

}
