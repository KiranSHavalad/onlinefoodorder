<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.menu.model.Menu" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Restaurant List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }
        h2 {
            text-align: center;
            margin-top: 20px;
        }
        .restaurant-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            width: 80%;
            margin: 20px auto;
        }
        .restaurant {
            width: calc(50% - 10px); /* Adjust for margins */
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            background-color: #ffffff;
            padding: 15px;
            margin-bottom: 20px;
            border-radius: 5px;
            overflow: hidden; /* Ensure content does not overflow */
        }
        .restaurant:nth-child(even) {
            margin-right: 0; /* Reset margin for even items */
        }
        .restaurant-image {
            float: left;
            margin-right: 20px;
        }
        .restaurant-details {
            overflow: hidden;
        }
        img {
            display: block;
            width: 100px;
            height: 100px;
            object-fit: cover;
            border-radius: 5px;
        }
        .add-to-cart {
            margin-top: 10px;
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
    <h2>Menu for Restaurants</h2>
    <div class="restaurant-container">
        <%
            List<Menu> listofmenu = (List<Menu>) request.getAttribute("men");
            if (listofmenu != null) {
                for (Menu menu : listofmenu) {
        %>
        <div class="restaurant">
            <div class="restaurant-image">
                <img src="<%= menu.getImagepath() %>" alt="<%= menu.getItemname() %> Image">
            </div>
            <div class="restaurant-details">
                <form action="cart" method="post" class="add-to-cart">
               
                <strong>Itemname:</strong> <%= menu.getItemname() %><br>
                <strong>Description:</strong> <%= menu.getDescription() %><br>
                <strong>Quantity:</strong> <%=1%><br>
                <strong>Price:</strong> <%= menu.getPrice() %><br>
                <strong>Rating:</strong> <%= menu.getRating() %><br>
                <strong>Isavailable:</strong> <%= menu.getIsavailable() %><br>
                   <input type="hidden" name="userid" value="<%= request.getAttribute("userid")%>">
                    <input type="hidden" name="itemid" value="<%= menu.getMenuid()%>">
                   <input type="hidden" name="userid" value="<%= request.getAttribute("userid") %>">
                    <input type="hidden" name="name" value="<%= menu.getItemname()%>">
                    <input type="hidden" name="price" value="<%= menu.getPrice()%>">
                    <input type="hidden" name="resturantid" value="<%= menu.getResturantid()%>">
                    <input type="hidden" name="quantity" value="<%=1%>">
                    <button type="submit">Add to Cart</button>
                    
                </form>
            </div>
        </div>
        <% 
                }
            } else {
        %>
        <div class="restaurant">
            <p>No item is available</p>
        </div>
        <% } %>
    </div>
    <div class="home-button">
              <form action="login" style="display:inline;">
              <input type="hidden"  name="userid" value="<%=request.getAttribute("userid") %>">
            
            <input type="submit" value="home" class="cancel" name = "home">
            </div>
</body>
</html>
