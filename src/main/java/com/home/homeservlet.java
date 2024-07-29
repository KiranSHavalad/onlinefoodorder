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

@WebServlet("/home")
public class homeservlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
    	
    	
    	Resturantimp imp = new Resturantimp();
    	
    	
        List<Resturant> ri = imp.getAll();
        
        
        
        
        req.setAttribute("listofresturants", ri);
        RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
        rd.forward(req, res);
    }
}
