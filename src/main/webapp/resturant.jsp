<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.rest.model.Resturant" %>
<%@ page import="com.menu.model.Menu" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f9fa;
        margin: 0;
        padding: 20px;
    }
    .container {
        max-width: 1000px;
        margin: 0 auto;
        background: #fff;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
        text-align: center;
        color: #333;
    }
    .menu-item {
        border-bottom: 1px solid #ddd;
        padding: 10px 0;
        display: flex;
        align-items: center;
    }
    .menu-item img {
        width: 100px;
        height: 100px;
        object-fit: cover;
        margin-right: 20px;
    }
    .menu-item strong {
        display: inline-block;
        width: 100px;
    }
    .menu-item p {
        margin: 5px 0;
    }
    .no-items {
        text-align: center;
        color: #888;
    }
    .form-container {
        text-align: center;
        margin-top: 20px;
    }
    .form-container button {
        padding: 10px 20px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    .form-container button:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Menu</h1>
    <% List<Menu> mli = (List<Menu>) request.getAttribute("menu"); 
    if (mli != null && !mli.isEmpty()) {
        for (Menu menu : mli) {
    %>
    <div class="menu-item">
        <img src="<%= menu.getImagepath() %>" alt="<%=menu.getItemname() %> Image">
        <div>
            <p><strong>Itemname:</strong><%= menu.getItemname() %></p>
            <p><strong>Description:</strong><%= menu.getDescription() %></p>
            <p><strong>Price:</strong><%= menu.getPrice() %></p>
            <p><strong>Rating:</strong><%= menu.getRating() %></p>
        </div>
    </div>
    <% 
        }
    } else { 
    %>
    <p class="no-items">No Items</p>
    <% } %>
 
    <div class="form-container">
        <form action="additems.jsp">
            <input type="hidden" name="resturantid" value="<%= request.getAttribute("resturantid") %>">
            <button type="submit">Add items</button>
        </form>
    </div>
 
    <div class="form-container">
        <form action="ordershow" method="post">
            <input type="hidden" name="resturantid" value="<%= request.getAttribute("resturantid") %>">
            <button type="submit">Orders</button>
        </form>
    </div>
    
    
     <div class="form-container">
        <form action="login.jsp" method="post">
            <button type="submit">Home</button>
        </form>
    </div>
    
     <div class="form-container">
        <form action="editresturant.jsp" method="post">
          <input type="hidden" name="resturantid" value="<%= request.getAttribute("resturantid") %>">
            <button type="submit">Edit Resturant</button>
        </form>
    </div>
    <div class="form-container">
        <form action="deleteitems" method="post">
          <input type="hidden" name="resturantid" value="<%= request.getAttribute("resturantid") %>">
            <button type="submit">Delete Items</button>
        </form>
    </div>
    
    
</div>
</body>
</html>
