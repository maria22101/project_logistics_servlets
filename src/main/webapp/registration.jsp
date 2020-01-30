<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages"/>

<style><%@ include file="/design.css" %></style>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration Page</title>
</head>
<body>

    <h2><fmt:message key="registration.page.title"/></h2><br/>

        <form method="post" action="${pageContext.request.contextPath}/app/registration" >
            <label> <fmt:message key="user_name.indication"/> <input type="text" name="username"/> </label><br/><br/>

            <label> <fmt:message key="email.indication"/> <input type="text" name="email"/> </label><br/><br/>

            <label> <fmt:message key="password.indication"/> <input type="password" name="password"/> </label><br/><br/>

            <input class="button" type="submit" value=<fmt:message key="registration.button"/>>
        </form>

    <br/><br/>

    <a href="${pageContext.request.contextPath}/index.jsp"><fmt:message key="main.return.link"/></a>
    <br/><br/>

    <div class="locale">
        <a href="?lang=en"><fmt:message key="lang.eng"/></a><br>
        <a href="?lang=ua"><fmt:message key="lang.ua"/></a>
    </div>

</body>
</html>