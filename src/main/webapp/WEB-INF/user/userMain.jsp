<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>user main</title>
</head>
<body>

<h1>Hello USER!</h1>

<a href="${pageContext.request.contextPath}/delivery/user/userOrders">To orders list</a><br><br>

<a href="${pageContext.request.contextPath}/delivery/logout">Logout</a>
</body>
</html>