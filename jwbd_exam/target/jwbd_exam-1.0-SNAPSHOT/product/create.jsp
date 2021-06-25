<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <style>
        .ctn form{
            width: 500px;
            height:750px;
            border-radius: 10px;
            margin: 2% auto;
            border: 1px solid dimgray;
            background-color: honeydew;
            padding: 20px 20px 10px 20px;
        }
        .ctn button{
            margin: 20px 40px;
            width: 90px;
            height: 50px;
        }


    </style>
</head>
<body class="container">

<h1>User Management</h1>
<h5>
    <a href="/product?action=product"><em>List All Product</em></a>
</h5>
<div class="ctn">
    <form method="post">
        <h3>Create New Product</h3>
        <div class="mb-3">
            <label for="product_name" class="form-label">Product Name</label>
            <input type="text" class="form-control"  name="product_name" id="product_name" placeholder="input name">
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Price:</label>
            <input type="text" class="form-control"  name="price" id="price" placeholder="input price">
        </div>
        <div class="mb-3">
            <label for="quantity" class="form-label">Quantity:</label>
            <input type="text" class="form-control"  name="quantity" id="quantity" placeholder="input quantity">
        </div>
        <div class="mb-3">
            <label for="color" class="form-label">Color:</label>
            <input type="text" class="form-control"  name="color" id="color" placeholder="input color">
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description:</label>
            <input type="text" class="form-control"  name="description" id="description" placeholder="Description">
        </div>
        <div class="mb-3">
            <label for="category_name" class="form-label">Category:</label>
            <select class="form-control" id="category_name" name="category_name" >
                <option>Phone</option>
                <option>Television</option>
                <option>Tablet</option>
            </select>
        </div>
        <div align="center">
            <button type="submit" class="btn btn-primary" value="create" >Create</button>
            <button type="reset" class="btn btn-warning" value="Reset">Reset</button>
        </div>
    </form>
</div>

</body>
</html>