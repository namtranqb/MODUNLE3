<%@ page import="com.example.WebCalculator.Calculator" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Calculator</title>
    <link rel="stylesheet" href="css/style.css">

</head>
<body>
<div class="cal">
    <h1>Web Calculator</h1>
    <form action="/calculator" method="post">
        <div>
            <label for="inputA">Input A</label>
            <input type="number" id="inputA" name="a" step="0.001" value="0"/>
        </div>

        <div>
            <fieldset id="group1" style="border: none;margin: auto">
                <div class="row">
                    <button><input type="radio" value="+" name="group1">+</button>
                    <button><input type="radio" value="-" name="group1">-</button>
                    <button><input type="radio" value="*" name="group1">*</button>
                    <button><input type="radio" value="/" name="group1">/</button>
                </div>
                <div class="row">
                    <button><input type="radio" value="%" name="group1">%</button>
                    <button><input type="radio" value="^" name="group1">^</button>

                </div>

            </fieldset>
        </div>

        <div>
            <label for="inputB">Input B</label>
            <input type="number" id="inputB" name="b"step="0.001" value="0"/>
        </div>

        <div>
            <button type="submit"style="background-color:orange;width: 80px;height: 40px">Start</button>
            <button type="reset" style="background-color:lightskyblue;width: 80px;height: 40px">Reset</button>

        </div>
        <h4 style="color: brown"><em style="color: chocolate">Result:</em> <%=request.getAttribute("a")%> <%=request.getAttribute("group1")%> <%=request.getAttribute("b")%> = <%=request.getAttribute("ketqua") %></h4>



    </form>


</div>


</body>
</html>