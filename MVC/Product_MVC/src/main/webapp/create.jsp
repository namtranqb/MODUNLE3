<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/27/2021
  Time: 9:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <title>Create Product</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body class="container">
<h1>Create Product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/home">Back to Product list</a>
</p>
<form method="post" action="/product">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>ID: </td>
                <td><input type="text" name="id" id="id"></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="productName" id="productName"></td>
            </tr>
            <tr>
                <td>Origin: </td>
                <td><input type="text" name="origin" id="origin"></td>
            </tr>
            <tr>
                <td>Product Type: </td>
                <td><input type="text" name="productType" id="productType"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" id="price"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create Product"></td>
            </tr>
        </table>
    </fieldset>

</form>
</body>
</html>
