<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <style>
        .div-form{
            width: 100%;
            display: flex;
            justify-content: flex-end;
        }
        .div-form div{
            margin-left: 20px;
        }

    </style>
</head>
<body class="container">
    <h1  align="center">Product Management</h1>
<div>
        <table class="table table-hover">
            <h3><em>List Of Users</em></h3>
            <h5>
                <a href="/product?action=create"><em>Add New Product</em></a>
            </h5>
            <div class="div-form">

                <div >
                    <form action="/product" method="get">
                        <input type="hidden" name="action" value="search">
                        <input type="text" name="keyword" placeholder="search" value="${keyword}">
                        <button class="btn btn-primary bt" type="submit" >Search</button>
                    </form>
                </div>

                <div>
                    <form action="/product" method="get">
                        <input type="hidden" name="action" value="sort">
                        <input type="hidden" name="keyWordSort" value="${keyword}">
                        <button class="btn btn-secondary bt" type="submit">Sort By Name</button>
                    </form>
                </div>

                <div>
                    <form action="/product" method="get">
                        <input type="hidden" name="action" value="reset">
                        <button class="btn btn-secondary bt" type="submit">Reset</button>
                    </form>

                </div>
            </div>
            <tr>
                <th>ID</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Color</th>
                <th>Category</th>
                <th>Actions</th>
            </tr>

            <c:forEach var="product" items="${requestScope.productList}">

                <tr>
                    <td><c:out value="${product.id}"/></td>
                    <td><c:out value="${product.product_name}"/></td>
                    <td><c:out value="${product.price}"/></td>
                    <td><c:out value="${product.quantity}"/></td>
                    <td><c:out value="${product.color}"/></td>
                    <td><c:out value="${product.category_name}"/></td>
                    <td>
                        <a href="/users?action=edit&id=${product.id}">Edit</a>
                        <a href="/users?action=delete&id=${product.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
</div>
</body>
</html>