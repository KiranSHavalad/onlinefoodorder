<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "com.order.model.Order" %>
<%@ page import = "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f9fa;
        margin: 0;
        padding: 20px;
    }
    .container {
        max-width: 800px;
        margin: 0 auto;
        background: #fff;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
        text-align: center;
        color: #333;
    }
    .order {
        border-bottom: 1px solid #ddd;
        padding: 10px 0;
    }
    .order strong {
        display: inline-block;
        width: 120px;
    }
    .order p {
        margin: 5px 0;
    }
    .no-items {
        text-align: center;
        color: #888;
    }
    .back-form {
        text-align: center;
        margin-top: 20px;
    }
    .back-form input[type="submit"] {
        padding: 10px 20px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    .back-form input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Order Details</h1>
    <% 
    List<Order> list = (List<Order>) request.getAttribute("orderlist"); 
    if (list != null && !list.isEmpty()) {
        for (Order or : list) {
    %>
    <form action = "delivery">
    <div class="order">
        <p><strong>User ID:</strong><%= or.getUserid() %></p>
        <p><strong>Order Date:</strong><%= or.getOrderdate() %></p>
        <p><strong>Total Amount:</strong><%= or.getTotalamount() %></p>
        <p><strong>Status:</strong><%= or.getStatus() %></p>
        <p><strong>Payment Mode:</strong><%= or.getPaymentmode() %></p>
        <input type="hidden" name="userid" value="<%=or.getUserid() %>">
        <input type="hidden" name="orderdate" value="<%=or.getOrderid() %>">
        <input type="hidden" name="resturantid" value="<%=or.getResturantid() %>">
      <input type="submit"  value="allot">
    </div>
    </form>
    <% 
        }
    } else { 
    %>
    <p class="no-items">No Items</p>
    <% } %>

    <div class="back-form">
        <form action="resturant2" method="post">
            <input type="hidden" name="restid" value="<%= request.getAttribute("resturantid") %>">
            <input type="submit" value="Back" name="back">
        </form>
    </div>
</div>
</body>
</html>
