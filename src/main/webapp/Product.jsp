<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Product Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
        h1, h2 {
            color: #333;
        }
        form {
            margin-bottom: 20px;
            padding: 10px;
            background: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin: 8px 0 4px;
        }
        input[type="text"],
        input[type="number"],
        select {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="file"] {
            margin-bottom: 10px;
        }
        button {
            background-color: #5cb85c;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #4cae4c;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background: #fff;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        img {
            max-width: 50px;
            height: auto;
        }
    </style>
</head>
<body>
    <h1>Product Management</h1>

    <!-- Add Product Form -->
    <h2>Add New Product</h2>
    <form action="ProductAction.do?action=add" method="post" enctype="multipart/form-data">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <label for="price">Price:</label>
        <input type="number" id="price" name="price" step="0.01" required>
        <label for="id_category">Category:</label>
        <select id="id_category" name="id_category" required>
            <c:forEach var="category" items="${categories}">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
        <label for="photo">Photo:</label>
        <input type="file" id="photo" name="photo" accept="image/*"><br>
        <button type="submit">Add Product</button>
    </form>

    <!-- Product List -->
    <h2>Product List</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Category</th>
            <th>Photo</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.category.name}</td>
                <td><img src="images/products/${product.photo}" alt="${product.name}"></td>
                <td>
                    <form action="ProductAction.do?action=edit" method="post" enctype="multipart/form-data" style="display:inline;">
                        <input type="hidden" name="id" value="${product.id}">
                        <input type="text" name="name" value="${product.name}" required style="width: auto; display: inline;">
                        <input type="number" name="price" step="0.01" value="${product.price}" required style="width: auto; display: inline;">
                        <select name="id_category" style="width: auto; display: inline;">
                            <c:forEach var="category" items="${categories}">
                                <option value="${category.id}" ${category.id == product.category.id ? 'selected' : ''}>${category.name}</option>
                            </c:forEach>
                        </select>
                        <input type="file" name="photo" accept="image/*" style="width: auto; display: inline;">
                        <button type="submit">Edit</button>
                    </form>
                    <form action="ProductAction.do?action=delete" method="post" style="display:inline;">
                        <input type="hidden" name="id" value="${product.id}">
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
