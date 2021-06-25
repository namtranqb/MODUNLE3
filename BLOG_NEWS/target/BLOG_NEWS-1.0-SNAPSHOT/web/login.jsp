<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        .ctn form{
            width: 500px;
            height:500px;
            border-radius: 10px;
            margin: 5% auto;
            border: 1px solid dimgray;
            background-color: lavender;
            padding: 50px;
        }

        .message{
            color:red;
        }


    </style>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body >

<div class="container ctn">
    <form method="get" action="login" >
        <h1 style="text-align: center">Login</h1>
        <div class="mb-3">
            <label for="username" class="form-label">User name</label>
            <input type="text" class="form-control" name="username" id="username" placeholder="username">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control"  name="password" id="password" placeholder="password">
        </div>
        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Check me out</label>



        </div>
        <button type="submit" class="btn btn-primary" style="align-items: center">Login</button>
    </form>

</div>

</body>
</html>