<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.rest.model.Resturant" %>
<%@ page import="java.io.IOException" %>
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
            cursor: pointer;
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
        .auth-buttons {
            text-align: center;
            margin: 20px 0;
        }
        .auth-buttons form,
        .auth-buttons button {
            display: inline-block;
            margin: 0 10px;
        }
    </style>
</head>
<body>
    <div class="auth-buttons">
        <form action="orderhistory" method="post" style="display: inline-block;">
            <input type="hidden" name="userid" value="<%= (int)request.getAttribute("userid") %>">
         
            <input type="submit" value="Order History">
        </form>
        <button onclick="location.href='index.jsp'">Log Out</button>
    </div>
    <h2>List of Restaurants</h2>
    <div class="restaurant-container">
        <%
            List<Resturant> listofresturant = (List<Resturant>) request.getAttribute("listofresturant");
            if (listofresturant != null) {
                for (Resturant restaurant : listofresturant) {
        %>
        <form action="menu" class="restaurant">
            <input type="hidden" name="resturantid" value="<%= restaurant.getResturantid() %>">
            <input type="hidden" name="userid" value="<%= (int)request.getAttribute("userid") %>">
            
            <div class="restaurant-image">
                <img src="<%= restaurant.getImagepath() %>" alt="<%= restaurant.getName() %> Image">
            </div>
            <div class="restaurant-details">
                <strong>Resturant ID:</strong> <%= restaurant.getResturantid() %><br>
                <strong>Name:</strong> <%= restaurant.getName() %><br>
                <strong>Address:</strong> <%= restaurant.getAddress() %><br>
                <strong>Phone:</strong> <%= restaurant.getPhone() %><br>
                <strong>Rating:</strong> <%= restaurant.getRating() %><br>
                <strong>Cuisine Type:</strong> <%= restaurant.getCusinetype() %><br>
                <strong>Is Active:</strong> <%= restaurant.getIsactive() %><br>
                <strong>ETA:</strong> <%= restaurant.getEta() %><br>
            </div>
        </form>
        <% 
                }
            } else {
        %>
        <div class="restaurant">
            <p>No restaurants available</p>
        </div>
        <% } %>
    </div>
    <script>
        document.querySelectorAll('.restaurant').forEach(function (restaurant) {
            restaurant.addEventListener('click', function () {
                this.submit();
            });
        });
    </script>
</body>
</html>
