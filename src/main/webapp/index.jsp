<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ProjectLogistics</title>
</head>

<body>
<h2>Welcome to delivery service!</h2>

<a href="${pageContext.request.contextPath}/delivery/login">Login</a><br><br>

<a href="${pageContext.request.contextPath}/delivery/registration">Registration form</a><br><br>

<a href="${pageContext.request.contextPath}/delivery/exception">Exception</a>

</body>
</html>