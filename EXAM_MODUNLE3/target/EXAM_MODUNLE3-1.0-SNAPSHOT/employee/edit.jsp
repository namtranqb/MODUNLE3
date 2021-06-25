<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Management Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <style>
        .ctn form{
            width: 500px;
            height:1000px;
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

<h1>Employee Management</h1>
<h5>
    <a href="/employee?action=employee"><em>List All Employee</em></a>
</h5>
<div class="ctn">
    <form method="post">
        <h3>Edit Employee</h3>
        <c:if test="${employee != null}">
            <input type="hidden" name="id" value="<c:out value='${employee.id}' />"/>
        </c:if>
        <div class="mb-3">
            <label for="group" class="form-label">Group:</label>
            <select class="form-control" id="group" name="group" value="<c:out value='${employee.group}' />">
                <option>Quản trị hệ thống</option>
                <option>Lễ tân</option>
                <option>Quản lí phòng</option>
            </select>
        </div>
        <div class="mb-3">
            <label for="fullname" class="form-label">Employee Name</label>
            <input type="text" class="form-control"  name="fullname" id="fullname" value="<c:out value='${employee.fullname}'/>">
        </div>
        <div class="mb-3">
            <label for="dob" class="form-label">Date Of Birth:</label>
            <input type="date" class="form-control"  name="dob" id="dob" value="<c:out value='${employee.dob}' />">
        </div>
        <div class="mb-3">
            <label for="gender" class="form-label">Gender:</label>
            <select class="form-control" id="gender" name="gender" value="<c:out value='${employee.gender}' />">
                <option>Nam</option>
                <option>Nữ</option>
            </select>
        </div>
        <div class="mb-3">
            <label for="phone_number" class="form-label">Phone number:</label>
            <input type="tel" class="form-control"  name="phone_number" id="phone_number" value="<c:out value='${employee.phone_number}' />">
        </div>
        <div class="mb-3">
            <label for="identity" class="form-label">Identity:</label>
            <input type="text" class="form-control"  name="identity" id="identity" value="<c:out value='${employee.identity}' />">
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email:</label>
            <input type="email" class="form-control"  name="email" id="email" value="<c:out value='${employee.email}' />">
        </div>
        <div class="mb-3">
            <label for="address" class="form-label">Address:</label>
            <textarea class="form-control"  name="address" id="address" value="<c:out value='${employee.address}' />"><c:out value='${employee.address}' /></textarea>
        </div>

        <div align="center">
            <button type="submit" class="btn btn-primary" value="save" >Save</button>
            <button type="reset" class="btn btn-warning" value="Reset">Reset</button>
        </div>
    </form>
</div>

</body>
</html>