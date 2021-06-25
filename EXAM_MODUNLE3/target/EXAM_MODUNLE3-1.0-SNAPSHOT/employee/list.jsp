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
<h1  align="center">Employee Management</h1>
<div>
    <table class="table table-hover">
        <h3><em>List Of Employee</em></h3>
        <h5>
            <a href="/employee?action=create"><em>Add New Employee</em></a>
        </h5>
        <div class="div-form">

            <div >
                <form method="get">
                    <input type="hidden" name="action" value="search">
                    <input type="text" name="search"value="${keyword}">
                    <button class="btn btn-primary bt" type="submit" >Search</button>
                </form>
            </div>

            <div>
                <form action="/employee" method="get">
                    <input type="hidden" name="action" value="reset">
                    <button class="btn btn-secondary bt" type="submit">Reset</button>
                </form>

            </div>
        </div>
        <tr>
            <th>ID</th>
            <th>Group</th>
            <th>Fullname</th>
            <th>Gender</th>
            <th>Phone number</th>
            <th>Actions</th>
        </tr>

        <c:forEach var="emp" items="${employeeList}">

            <tr>
                <td><c:out value="${emp.id}"/></td>
                <td><c:out value="${emp.group}"/></td>
                <td><c:out value="${emp.fullname}"/></td>
                <td><c:out value="${emp.gender}"/></td>
                <td><c:out value="${emp.phone_number}"/></td>
                <td>
                    <a href="/employee?action=edit&id=${emp.id}">Edit</a>
                    <a href="/employee?action=delete&id=${emp.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>