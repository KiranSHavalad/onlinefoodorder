<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.rest.model.Resturant" %>
<%
    
    
    
    Resturant r = new Resturant();
    
    request.getRequestDispatcher("hme").forward(request, response);
    
    
    //request.getRequestDispatcher("home").forward(request, response);
%>