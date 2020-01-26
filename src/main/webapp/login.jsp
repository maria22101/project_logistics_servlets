<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
</head>
<body>

    <h1>Вход в систему</h1><br/>

    <form method="get" action="${pageContext.request.contextPath}/app/login">

        <input type="text" name="name"><br/>
        <input type="password" name="pass"><br/><br/>
        <input class="button" type="submit" value="Войти">

    </form>

    <br><br>
    <a href="${pageContext.request.contextPath}/app/logout">На головну</a>

</body>
</html>