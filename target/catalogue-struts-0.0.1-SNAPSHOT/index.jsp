<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome to E-Commerce Management System</title>
    <style>
        /* Basic reset for margin and padding */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* General body styling */
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background-color: #f4f4f9;
        }

        /* Container styling */
        .container {
            text-align: center;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        /* Title styling */
        h1 {
            font-size: 24px;
            color: #333;
            margin-bottom: 20px;
        }

        /* Link button styling */
        .link-button {
            display: block;
            margin: 10px 0;
            padding: 10px;
            font-size: 16px;
            color: #fff;
            text-decoration: none;
            background-color: #007bff;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .link-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>E-Commerce </h1>
        <a href="CategoryAction.do" class="link-button">Category Action</a>
        <a href="category.jsp" class="link-button">Manage Categories</a>
        <a href="product.jsp" class="link-button">Manage Products</a>
    </div>
</body>
</html>
