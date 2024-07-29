<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Form</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        .container label {
            display: block;
            margin-bottom: 5px;
        }
        .container input[type="text"],
        .container input[type="email"],
        .container input[type="tel"],
        .container input[type="password"],
        .container select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .container button {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .container button:hover {
            background-color: #218838;
        }
        .login-link {
            text-align: center;
            margin-top: 20px;
        }
        .login-link a {
            color: #007bff;
            text-decoration: none;
        }
        .login-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Registration Form</h2>
        <form action="registrationServlets" method="post">
            <label for="name"><b>Name</b></label>
            <input type="text" placeholder="Enter Name" name="name" required>

            <label for="email"><b>Email</b></label>
            <input type="email" placeholder="Enter Email" name="email" required>

            <label for="password"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="password" required>

            <label for="phone"><b>Phone Number</b></label>
            <input type="tel" placeholder="Enter Phone Number" name="phone" required>

            <label for="address"><b>Address</b></label>
            <input type="text" placeholder="Enter Address" name="address" required>

            <label for="role"><b>Role</b></label>
            <select name="role" required>
                <option value="customer">Customer</option>
                <option value="admin">Restaurants</option>
                <option value="deliveryboy">Delivery Boy</option>
            </select>

            <button type="submit">Register</button>
        </form>
        <div class="login-link">
            <p>If you are already registered, click <a href="login.jsp">Login</a></p>
        </div>
    </div>
</body>
</html>
