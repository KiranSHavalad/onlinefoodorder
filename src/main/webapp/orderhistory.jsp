<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.orderhistory.model.Orderhistory" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order History</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 20px;
        }
        .order-history {
            width: 80%;
            margin: 20px auto;
            background-color: #ffffff;
            padding: 20px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }
        .order {
            border-bottom: 1px solid #ddd;
            padding: 10px 0;
        }
        .order:last-child {
            border-bottom: none;
        }
         .home-button {
            margin-top: 20px;
            text-align: center;
        }
        .home-button button {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border: none;
            background-color: #007BFF;
            color: white;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <h1>Order History</h1>
    <div class="order-history">
        <%
            List<Orderhistory> orderHistoryList = (List<Orderhistory>) request.getAttribute("orderhistory");
            if (orderHistoryList != null && !orderHistoryList.isEmpty()) {
                for (Orderhistory order : orderHistoryList) {
        %>
        <div class="order">
            <p><strong>Itemname:</strong> <%= order.getItemname()%></p>
            <p><strong>Order Date:</strong> <%= order.getOrderdate() %></p>
            <p><strong>Total Amount:</strong> <%= order.getTotalamount() %></p>
            <p><strong>Status:</strong> <%= order.getStatus() %></p>
        </div>
        <% 
                }
            } else {
        %>
        <p>No order history available.</p>
        <% } %>
    </div>
    <div class="home-button">
              <form action="login" method="post" style="display:inline;">
        <input type="hidden" name="userid" value="<%=request.getAttribute("userid") %>">
            <input type="submit" value="back" class="cancel" name = "back">
            </div>
</body>
</html>
