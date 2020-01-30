<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>

<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages"/>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ProjectLogistics</title>
</head>

<body>

    <h2>
        <fmt:message key="main.title"/>
    </h2>

    <a href="${pageContext.request.contextPath}/delivery/login">
        <fmt:message key="main.login.link"/>
    </a><br><br>

    <a href="${pageContext.request.contextPath}/delivery/registration">
        <fmt:message key="main.registration.link"/>
    </a><br><br>

<%--    <a href="${pageContext.request.contextPath}/delivery/exception">--%>
<%--        Exception--%>
<%--    </a><br><br>--%>

    <div class="locale">
        <a href="?lang=en"><fmt:message key="lang.eng"/></a><br>
        <a href="?lang=ua"><fmt:message key="lang.ua"/></a>
    </div>

<%--    <ul>--%>
<%--        <li><a href="?sessionLocale=en"><fmt:message key="lang.eng" /></a></li>--%>
<%--        <li><a href="?sessionLocale=de"><fmt:message key="lang.ua" /></a></li>--%>
<%--    </ul>--%>

</body>
</html>
