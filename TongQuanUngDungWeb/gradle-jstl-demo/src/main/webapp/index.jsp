<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>


<h1>c:set</h1>
<c:set scope="request" var="greeting" value="Hello C0221H1"/>

<h2>c:out</h2>
<c:out value="${greeting}"/>
</body>
</html>