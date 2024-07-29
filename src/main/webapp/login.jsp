<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Form</title>
    <link rel="stylesheet" type="text/css" href="stylelogin.css">
</head>
<body>
    <h2>Login Form</h2>
    <form action="login" method="post">
        <div class="container">
            <label for="email"><b>Email (User ID)</b></label>
            <input type="email" placeholder="Enter Email" name="email" required>

            <label for="password"><b>Password</b></label>
            <input type="text" placeholder="Enter Password" name="password" required>

            <button type="submit">Login</button>
        </div>
        
        <%-- Display error message if exists --%>
    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
    %>
        <p style="color: red;"><%= errorMessage %></p>
    <%
        }
    %>
    </form>
    
    <div class="container">
        <p>If you don't have an account, please click signup for registration.</p>
        <form action="signup.jsp" method="get">
            <button type="submit">Sign Up</button>
        </form>
    </div>
    
</body>
</html>