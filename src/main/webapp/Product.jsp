<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Product Management</title>
</head>
<body>
    <h1>Product Management</h1>

    <!-- Add Product Form -->
    <h2>Add New Product</h2>
    <form action="ProductAction.do?action=add" method="post" enctype="multipart/form-data">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="price">Price:</label>
        <input type="number" id="price" name="price" step="0.01" required><br>
        <label for="id_category">Category:</label>
        <select id="id_category" name="id_category" required>
            <c:forEach var="category" items="${categories}">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select><br>
        <label for="photo">Photo:</label>
        <input type="file" id="photo" name="photo" accept="image/*"><br>
        <button type="submit">Add Product</button>
    </form>

    <!-- Product List -->
    <h2>Product List</h2>
    <table border="1">
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
                <td><img src="images/products/${product.photo}" alt="${product.name}" width="50"></td>
                <td>
                    <form action="ProductAction.do?action=edit" method="post" enctype="multipart/form-data" style="display:inline;">
                        <input type="hidden" name="id" value="${product.id}">
                        <input type="text" name="name" value="${product.name}" required>
                        <input type="number" name="price" step="0.01" value="${product.price}" required>
                        <select name="id_category">
                            <c:forEach var="category" items="${categories}">
                                <option value="${category.id}" ${category.id == product.category.id ? 'selected' : ''}>${category.name}</option>
                            </c:forEach>
                        </select>
                        <input type="file" name="photo" accept="image/*">
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
