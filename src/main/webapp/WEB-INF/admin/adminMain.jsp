<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>admin main</title>
</head>
<body>

<h1>Hello ADMIN!</h1>

<a href="${pageContext.request.contextPath}/app/admin/adminUsers">To users list</a><br><br>

<a href="${pageContext.request.contextPath}/app/logout">Logout</a>
</body>
</html>