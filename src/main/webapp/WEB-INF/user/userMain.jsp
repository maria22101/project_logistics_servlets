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
    <title>user main</title>
</head>
<body>

    <h2><fmt:message key="usercabinet.title"/>${name}</h2>

    <a href="${pageContext.request.contextPath}/app/user/userOrders">
        <fmt:message key="cabinet.orderlist.link"/>
    </a><br><br>

    <a href="${pageContext.request.contextPath}/app/user/userInvoicedOrders">
        <fmt:message key="usercabinet.invoiced.orderlist.link"/>
    </a><br><br>

    <a href="${pageContext.request.contextPath}/app/user/placeOrder">
        <fmt:message key="usercabinet.order.placing.button"/>
    </a><br><br>

    <form action="${pageContext.request.contextPath}/app/logout" method="post">
        <input class="button" type="submit" value="<fmt:message key="logout.button"/>"/>
    </form>

    <div class="locale">
        <a href="?lang=en"><fmt:message key="lang.eng"/></a><br>
        <a href="?lang=ua"><fmt:message key="lang.ua"/></a>
    </div>

</body>
</html>