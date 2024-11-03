<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Category Management</title>
</head>
<body>
    <h1>Category Management</h1>

    <!-- Add Category Form -->
    <h2>Add New Category</h2>
    <form action="CategoryAction.do?action=add" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="description">Description:</label>
        <input type="text" id="description" name="description" required><br>
        <button type="submit">Add Category</button>
    </form>

    <!-- Category List -->
    <h2>Category List</h2>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="category" items="${categories}">
            <tr>
                <td>${category.name}</td>
                <td>${category.description}</td>
                <td>
                    <form action="CategoryAction.do?action=edit" method="post" style="display:inline;">
                        <input type="hidden" name="id" value="${category.id}">
                        <input type="text" name="name" value="${category.name}" required>
                        <input type="text" name="description" value="${category.description}" required>
                        <button type="submit">Edit</button>
                    </form>
                    <form action="CategoryAction.do?action=delete" method="post" style="display:inline;">
                        <input type="hidden" name="id" value="${category.id}">
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
