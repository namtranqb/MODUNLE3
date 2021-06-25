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
    <h1  align="center">User Management</h1>
<div>
    <c:if test="${listUser != null}">
        <table class="table table-hover">
            <h3><em>List Of Users</em></h3>
            <h5>
                <a href="/users?action=create"><em>Add New User</em></a>
            </h5>
            <div class="div-form">

                <div >
                    <form action="/users" method="get">
                        <input type="hidden" name="action" value="search">
                        <input type="text" name="keyword" placeholder="search" value="${keyword}">
                        <button class="btn btn-primary bt" type="submit" >Search</button>
                    </form>
                </div>

                <div>
                    <form action="/users" method="get">
                        <input type="hidden" name="action" value="sort">
                        <input type="hidden" name="keyWordSort" value="${keyword}">
                        <button class="btn btn-secondary bt" type="submit">Sort By Name</button>
                    </form>
                </div>

                <div>
                    <form action="/users" method="get">
                        <input type="hidden" name="action" value="reset">
                        <button class="btn btn-secondary bt" type="submit">Reset</button>
                    </form>

                </div>
            </div>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>

            <c:forEach var="user" items="${requestScope.listUser}">

                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.fullName}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.country}"/></td>
                    <td>
                        <a href="/users?action=edit&id=${user.id}">Edit</a>
                        <a href="/users?action=delete&id=${user.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${userList != null}">
        <table class="table table-hover">
            <h3><em>List of Users</em></h3>
            <div style="text-align: right">
                <form action="/users" method="get">
                    <input type="hidden" name="action" value="editSearch">
                    <input type="text" name="keyword" placeholder="search">
                    <button class="btn btn-primary bt" type="submit" >Search</button>
                </form>

            </div>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>

            </tr>

            <c:forEach var="user" items="${requestScope.userList}">

                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.fullName}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.country}"/></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>


</div>
</body>
</html>